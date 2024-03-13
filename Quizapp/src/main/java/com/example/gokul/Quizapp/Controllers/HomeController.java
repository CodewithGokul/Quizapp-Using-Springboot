package com.example.gokul.Quizapp.Controllers;

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

import com.example.gokul.Quizapp.models.questions;
import com.example.gokul.Quizapp.services.questionsServices;

@Controller
public class HomeController {
	@Autowired
	questionsServices questionservices;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/datas")
	public String getallData(Model model) {
		model.addAttribute("datas", questionservices.getalldata());

		return "datas";

	}

	@GetMapping("deleteall")
	public String deleteall() {
		questionservices.deleteall();
		return "redirect:/datas";
	}

	@GetMapping("/create")
	public String create() {
		return "questionForm";
	}

	@PostMapping("/save")
	public String save(@Validated @ModelAttribute questions qs, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/questionForm";
		} else {
			questionservices.savequestion(qs);
			return "redirect:/datas";
		}
	}

	@GetMapping("/generatecode")
	public String gencode(Model model) {
		Random random = new Random();

		int min = 1000;
		int max = 9999;
		int randomNumber = random.nextInt(max - min + 1) + min;
		
		model.addAttribute("otp", randomNumber);
		return "accesscode";
	}



}
