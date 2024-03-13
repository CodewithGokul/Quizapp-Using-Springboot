package com.example.gokul.Quizapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		public String getallData(Model model)
		{		
			model.addAttribute("datas", questionservices.getalldata());
			
			return "datas";
			
		}
		@GetMapping("deleteall")
		public String deleteall()
		{
			 questionservices.deleteall();
			 return "redirect:/datas";
		}
}
