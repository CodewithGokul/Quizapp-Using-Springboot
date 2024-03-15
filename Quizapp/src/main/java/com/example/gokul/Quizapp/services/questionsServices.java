package com.example.gokul.Quizapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gokul.Quizapp.dao.allquestionsdao;
import com.example.gokul.Quizapp.dao.questionsdao;
import com.example.gokul.Quizapp.models.allquestions;
import com.example.gokul.Quizapp.models.questions;

@Service
public class questionsServices{
	@Autowired
	questionsdao qd;
	@Autowired
	allquestionsdao aqd;
	public List<questions> getalldata() {
		
		return qd.findAll();
	}
	public String deleteall() {
		
		qd.deleteAll();
		return "Deleted";
		
	}
	public  void savequestion(questions qs) {
		qd.save(qs);
		List<questions> qc = qd.findAll();
		List<allquestions> allquestions = new ArrayList<>();
		for(questions qst:qc){
			allquestions alq = new allquestions();
			alq.setCrctans(qst.getCrctans());
			alq.setCategory(qst.getCategory());
			alq.setCode(qst.getCode());
			alq.setLevel(qst.getLevel());
			alq.setTitle(qst.getTitle());
			alq.setOptiona(qst.getOptiona());
			alq.setOptionb(qst.getOptionb());
			alq.setOptionc(qst.getOptionc());
			allquestions.add(alq);
		}
		aqd.saveAll(allquestions);
	}

}
