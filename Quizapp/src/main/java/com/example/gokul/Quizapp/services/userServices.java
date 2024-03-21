package com.example.gokul.Quizapp.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.gokul.Quizapp.dao.Userdao;
import com.example.gokul.Quizapp.models.Users;
@Service
public class userServices {
    // @Autowired
    // private PasswordEncoder encoder;
    @Autowired
    Userdao userdao;

    public void saveUsers(Users users){
        userdao.save(users);
    }
}
