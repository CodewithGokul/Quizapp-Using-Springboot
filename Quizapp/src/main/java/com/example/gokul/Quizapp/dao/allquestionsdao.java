package com.example.gokul.Quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gokul.Quizapp.models.allquestions;

@Repository
public interface allquestionsdao extends JpaRepository<allquestions,Integer> {
	
}
