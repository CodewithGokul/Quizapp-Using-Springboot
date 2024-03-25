package com.example.gokul.Quizapp.Controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gokul.Quizapp.models.allquestions;
import com.example.gokul.Quizapp.models.questions;
import com.example.gokul.Quizapp.services.questionsServices;

@Controller
public class HomeController {
	static int flag=0;
	static int randomNumber;
	@Autowired
	questionsServices qss;

	@GetMapping("/")
	public String home() {
		qss.deleteall();
		return "index";
	}

	@GetMapping("/datas")
	public String getallData(Model model) {
		model.addAttribute("datas", qss.getalldata());

		return "datas";

	}

	@GetMapping("deleteall")
	public String deleteall() {
		qss.deleteall();
		return "redirect:/datas";
	}

	@GetMapping("/delete")
	public String deleteByButton(@RequestParam Integer id){
			qss.deleteByButton(id);
		return "redirect:/datas";
	}
	
	@GetMapping("/create")
	public String create() {
		qss.resetId("questions");
		return "questionForm";
	}

	@PostMapping("/save")
	public String save(@Validated @ModelAttribute questions qs, BindingResult result) {
		if(flag==0){
			Random random = new Random();
			int min = 1000;
			int max = 9999;
			randomNumber = random.nextInt(max - min + 1) + min;
			qs.setCode(randomNumber);
			flag=1;
		}
		qs.setCode(randomNumber);

		if (result.hasErrors()) {
			return "redirect:/questionForm";
		} else {
			qss.savequestion(qs);
			return "redirect:/datas";
		}
	}
	

	@GetMapping("/generatecode")
	public String gencode(Model model) {
		flag=0;
		qss.savehistory();
		qss.deleteall();
		model.addAttribute("code", randomNumber);
		return "accesscode";
	}

	@GetMapping("/accept")
	public String accept(){
		return "redirect:/datas";
	}

}

