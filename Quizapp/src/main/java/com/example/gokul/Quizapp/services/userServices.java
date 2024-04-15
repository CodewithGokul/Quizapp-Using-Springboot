package com.example.gokul.Quizapp.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.gokul.Quizapp.dao.Userdao;
import com.example.gokul.Quizapp.models.Users;
@Service
public class userServices implements UserDetailsService{
    // @Autowired
    // private PasswordEncoder encoder;
    @Autowired
    Userdao userdao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Users> users = userdao.findByUsername(username);
            if(users.isPresent()){
                Users obj = users.get();
                return User.builder()
                       .username(obj.getUsername())
                       .password(obj.getPassword())
                       .roles(obj.getRole())
                       .build();
            }
            else{
                 throw new UsernameNotFoundException(username + " username Not Found");
            }
    }
}
