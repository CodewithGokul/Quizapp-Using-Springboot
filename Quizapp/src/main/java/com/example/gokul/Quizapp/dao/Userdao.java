package com.example.gokul.Quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gokul.Quizapp.models.Users;
import java.util.List;
import java.util.Optional;


public interface Userdao extends JpaRepository<Users,Integer>{
    
     Optional<Users> findByUsername(String Username);
}
