package com.example.gokul.Quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gokul.Quizapp.models.resultAns;

@Repository
public interface resultDao extends JpaRepository<resultAns,Integer>{

}
