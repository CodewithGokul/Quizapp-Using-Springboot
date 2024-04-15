package com.example.gokul.Quizapp.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Random;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gokul.Quizapp.dao.allquestionsdao;
import com.example.gokul.Quizapp.dao.questionsdao;
import com.example.gokul.Quizapp.models.allquestions;
import com.example.gokul.Quizapp.models.questions;
import com.example.gokul.Quizapp.services.questionsServices;
import org.springframework.web.bind.annotation.RequestBody;

@Controller 
class quizController {

    @Autowired
    questionsServices questionservices;
    @Autowired
    allquestionsdao aqd;
    @Autowired
    questionsdao qd;
    static public Integer code;
    static public Integer quest=0;
    java.util.List<questions> questByCode;
    
    @GetMapping("/attendquiz")
    public String attendquiz() {

        return "joincard";
    }

    @PostMapping("/joinaccess")
    public String joinaccess(@RequestParam("joinCode") Integer joincode, Model model) {
        code = joincode;
        quest=0;
        questionservices.resetId("questions");
        questionservices.saveFor50(joincode); //In Question Table Again Saving For Eliminate The option
        questByCode = questionservices.fetchquestion(joincode);   
        model.addAttribute("codeData",questByCode.get(quest));
        questionservices.resetId("questions");
        questionservices.mark=0;
        questionservices.track=0;
        questionservices.flag=1;
        questionservices.powerups=1;
        return "quiz";
    }
    
    @PostMapping("/nextquestion")
    public String nextQuestion(@RequestParam("answer") String answer,Model model){
        questByCode = questionservices.fetchquestion(code);
            try {
                questionservices.validateAnswer(code, answer);
                quest++;
                if(questByCode.get(quest)!=null){
                    questionservices.powerups=1;
                    model.addAttribute("codeData",questByCode.get(quest));        
                }
            } 
            catch (Exception e) {
                System.out.println(e);
                model.addAttribute("marks",questionservices.mark);
                model.addAttribute("total",questionservices.track);
                return "quizresult";
            }  
            return "quiz";
    }

    @GetMapping("/resultQuestion")
    public String resultQuestion(Model model) {
        java.util.List<allquestions> question = aqd.findByCode(code); 
        model.addAttribute("allquestions",question);
        model.addAttribute("useresult", questionservices.answers);
        return "resultquiz";
    }

    @GetMapping("/powerups")
    public String powerUps(@RequestParam Integer id,Model model) {
        questionservices.deleteTwoOption(id);
        questByCode = questionservices.fetchquestion(code);
        System.out.println(questByCode.get(quest));
        model.addAttribute("codeData", questByCode.get(quest));   
        return "quiz";
    }

    @GetMapping("/userdata")
        public void userdata()
        {
            System.out.println("Userdata Fetched");
        }
        
}
