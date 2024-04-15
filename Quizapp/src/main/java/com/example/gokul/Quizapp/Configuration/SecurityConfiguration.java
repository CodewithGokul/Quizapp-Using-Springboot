package com.example.gokul.Quizapp.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.example.gokul.Quizapp.Filter.Jwtfilter;
import com.example.gokul.Quizapp.services.userServices;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    userServices userservice;

    // Jwtfilter jwtFilter ; 

    //To Decrypt the Password
    @Bean
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }


    //Authentication Validation Happens Here
    @Bean
    public AuthenticationProvider authenticationprovider(){
                DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
                daoProvider.setUserDetailsService(userservice);
                daoProvider.setPasswordEncoder(passwordencoder()) ;          
                return daoProvider;
        }



    //It will Filter What are the page should Access While In Cover of Security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(registry->{
            registry.requestMatchers("/register").permitAll();
            registry.requestMatchers("/signup").permitAll();
            registry.requestMatchers("/userdata").permitAll();
            registry.requestMatchers("/**").hasRole("USER");
            registry.anyRequest().authenticated();
        })
        .userDetailsService(userservice)
        .formLogin(httpSecurityFormLoginConfigurer ->{
            httpSecurityFormLoginConfigurer.loginPage("/login").permitAll();
        })
        .build();
}

        @Bean
        public UserDetailsService userdetailservice(){
            return userservice;
        }
}