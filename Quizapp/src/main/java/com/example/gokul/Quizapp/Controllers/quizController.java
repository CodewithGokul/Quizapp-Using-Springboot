package com.example.gokul.Quizapp.Controllers;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gokul.Quizapp.models.allquestions;
import com.example.gokul.Quizapp.services.questionsServices;

@Controller
class quizController {

    @Autowired
    questionsServices questionservices;

    @GetMapping("/attendquiz")
    public String attendquiz(){

        return "joincard";
    }

    @PostMapping("/joinaccess")
    public String joinaccess(@RequestParam("joinCode")Integer joincode,Model model)
    {
        System.out.println(joincode);
        model.addAttribute("codeData", questionservices.fetchquestion(joincode));       
        return "quiz";
    }
}
