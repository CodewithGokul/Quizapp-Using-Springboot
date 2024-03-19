package com.example.gokul.Quizapp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gokul.Quizapp.models.SecurityRoles;
import com.example.gokul.Quizapp.models.Users;
@Service
public class userServices implements UserDetailsService{
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(!username.equals("Gokul Vijay")){
            System.out.println("Unauthorized da madaya");
            throw new UsernameNotFoundException("Its Not Expected");
        }
        Set<SecurityRoles> roles = new HashSet<>();
        roles.add(new SecurityRoles(1,"Admin"));

        return new Users(1,"Gokul Vijay",encoder.encode("944343"),roles);
                
    }

}
