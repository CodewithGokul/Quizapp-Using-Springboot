package com.example.gokul.Quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gokul.Quizapp.models.Users;

public interface Userdao extends JpaRepository<Users,Integer>{

}
