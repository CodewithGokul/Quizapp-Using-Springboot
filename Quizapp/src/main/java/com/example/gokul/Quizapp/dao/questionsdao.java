package com.example.gokul.Quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gokul.Quizapp.models.questions;
@Repository
public interface questionsdao extends JpaRepository<questions,Integer> {
	
}
