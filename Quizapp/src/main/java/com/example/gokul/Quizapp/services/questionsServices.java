package com.example.gokul.Quizapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.gokul.Quizapp.dao.allquestionsdao;
import com.example.gokul.Quizapp.dao.questionsdao;
import com.example.gokul.Quizapp.models.allquestions;
import com.example.gokul.Quizapp.models.questions;

@Service
public class questionsServices {
	@Autowired
	questionsdao qd;
	@Autowired
	allquestionsdao aqd;
	@Autowired
	JdbcTemplate jdbctemplate;
	public static Integer i = 0;
	public static Integer mark = 0;
	public static Integer track = 0;
	public static List<String> answers = new ArrayList<>();

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

	public List<allquestions> fetchallquestion(Integer joincode) {

		return aqd.findByCode(joincode);
	}

	public List<questions> fetchquestion(Integer joincode) {

		return qd.findByCode(joincode);
	}

	public void savehistory() {
		List<questions> qc = qd.findAll();
		List<allquestions> allquestions = new ArrayList<>();
		for (questions qst : qc) {
			allquestions alq = new allquestions();
			alq.setCrctans(qst.getCrctans());
			alq.setCategory(qst.getCategory());
			alq.setCode(qst.getCode());
			alq.setLevel(qst.getLevel());
			alq.setTitle(qst.getTitle());
			alq.setOptiona(qst.getOptiona());
			alq.setOptionb(qst.getOptionb());
			alq.setOptionc(qst.getOptionc());
			alq.setOptiond(qst.getOptiond());
			allquestions.add(alq);
		}
		aqd.saveAll(allquestions);
	}

	public void saveFor50(Integer joincode) 
	{
		List<allquestions> codeQuestion = aqd.findByCode(joincode);
		List<questions> question = new ArrayList<>();
		for(allquestions aq : codeQuestion) {
			questions questions = new questions();
			questions.setCrctans(aq.getCrctans());
			questions.setCategory(aq.getCategory());
			questions.setCode(aq.getCode());
			questions.setLevel(aq.getLevel());
			questions.setTitle(aq.getTitle());
			questions.setOptiona(aq.getOptiona());
			questions.setOptionb(aq.getOptionb());
			questions.setOptionc(aq.getOptionc());
			questions.setOptiond(aq.getOptiond());
			question.add(questions);
		}
		qd.saveAll(question);
	}

	public void resetId(String tableName) 
	{
		String sql = "ALTER TABLE " + tableName + " AUTO_INCREMENT = 1";
		jdbctemplate.execute(sql);
	}

	public void validateAnswer(Integer code, String answer) 
	{
		List<allquestions> allques = aqd.findByCode(code);
		// List<resultAns> userAns = resultdao.findAll();
		if (answer.equals(allques.get(track).getCrctans()))
		{
			mark++;
		}

		answers.add(answer);
		track++;
	}

	public void deleteByButton(Integer id)
	{

		qd.deleteById(id);
	}

	public void deleteTwoOption(Integer id) {
		questions qs = qd.findById(id).orElse(null);
		List<questions> qst = new ArrayList<>(); 
		if (qs != null) 
		{
			i = 0;
			Random random = new Random();
			int randomNumber = random.nextInt(4) + 1;
			System.out.println(qs.getTitle());
			System.out.println(qs.getCrctans());
			System.out.println(randomNumber);
			if (qs.getOptiona() != null) {
				System.out.println("hi");
			}
			while (i < 2) {
				System.out.println(i);
				randomNumber = random.nextInt(4) + 1;
				System.out.println("random" + randomNumber);
				switch (randomNumber) {
					case 1:
						if (qs.getOptiona() != null && !(qs.getOptiona().equals(qs.getCrctans()))) {
							qd.deleteOptiona(id);
							qs.setOptiona(null);
							i++;
						}
						break;
					case 2:
						if (qs.getOptionb() != null && !(qs.getOptionb().equals(qs.getCrctans()))) {
							qd.deleteOptionb(id);
							qs.setOptionb(null);
							i++;
						}
						break;

					case 3:
						if (qs.getOptionc() != null && !(qs.getOptionc().equals(qs.getCrctans()))) {
							qd.deleteOptionc(id);
							qs.setOptionc(null);
							i++;
						}
						break;

					case 4:
						if (qs.getOptiond() != null && !(qs.getOptiond().equals(qs.getCrctans()))) {
							qd.deleteOptiond(id);
							qs.setOptiond(null);
							i++;
						}
						break;

					default:
						break;
				}
				qd.save(qs);
			}
		} else {
			System.out.println("Question not found with ID: " + id);
		}
	}

}
