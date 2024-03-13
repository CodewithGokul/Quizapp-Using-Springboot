package com.example.gokul.Quizapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gokul.Quizapp.dao.questionsdao;
import com.example.gokul.Quizapp.models.questions;

@Service
public class questionsServices {
	
	@Autowired
	questionsdao qd;
	public List<questions> getalldata() {
		
		return qd.findAll();
	}
	public String deleteall() {
		
		qd.deleteAll();
		return "Deleted";
		
	}
	public void savequestion(questions qs) {
		
		qd.save(qs);
		
	}
	
	
}
