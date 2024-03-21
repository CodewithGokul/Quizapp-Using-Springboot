package com.example.gokul.Quizapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.gokul.Quizapp.dao.allquestionsdao;
import com.example.gokul.Quizapp.dao.questionsdao;
import com.example.gokul.Quizapp.dao.resultDao;
import com.example.gokul.Quizapp.models.allquestions;
import com.example.gokul.Quizapp.models.questions;
import com.example.gokul.Quizapp.models.resultAns;

@Service
public class questionsServices{
	@Autowired
	questionsdao qd;
	@Autowired
	allquestionsdao aqd;
	@Autowired
	JdbcTemplate jdbctemplate;
	@Autowired
	resultDao resultdao;


	public List<questions> getalldata() {
		
		return qd.findAll();
	}
	public String deleteall() {
		
		qd.deleteAll();
		return "Deleted";
		
	}
	public  void savequestion(questions qs) {
		qd.save(qs);		

	}
    public List<allquestions> fetchquestion(Integer joincode) {

			return aqd.findByCode(joincode);
    }
	public void savehistory(){
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

	public void resetId(String tableName){
		String sql = "ALTER TABLE " + tableName + " AUTO_INCREMENT = 1";
		jdbctemplate.execute(sql);
	}
	public void getresult(List<resultAns> resultans,Integer code) {
		List<allquestions> allquestions = aqd.findByCode(code);
		for(resultAns ra:resultans){

		}
	}

}
