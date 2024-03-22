package com.example.gokul.Quizapp.Controllers;

import java.util.ArrayList;

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
import com.example.gokul.Quizapp.models.allquestions;
import com.example.gokul.Quizapp.services.questionsServices;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
class quizController {

    @Autowired
    questionsServices questionservices;
    static public Integer code;
    static public Integer quest=0;

    @GetMapping("/attendquiz")
    public String attendquiz() {

        return "joincard";
    }

    @PostMapping("/joinaccess")
    public String joinaccess(@RequestParam("joinCode") Integer joincode, Model model) {
        code = joincode;
        quest=0;
        java.util.List<allquestions> questByCode = questionservices.fetchquestion(joincode);   
        model.addAttribute("codeData",questByCode.get(quest));
        questionservices.mark=0;
        questionservices.track=0;
        return "quiz";
    }
    
    @PostMapping("/nextquestion")
    public String nextQuestion(@RequestParam("answer") String answer,Model model){
        java.util.List<allquestions> questByCode = questionservices.fetchquestion(code);
            try {
                questionservices.validateAnswer(code, answer);
                quest++;
                if(questByCode.get(quest)!=null){
                    model.addAttribute("codeData",questByCode.get(quest));        
                }
            } catch (Exception e) {
                System.out.println(e);
                model.addAttribute("marks",questionservices.mark);
                model.addAttribute("total",questionservices.track);
                return "quizresult";
            }  
            return "quiz";
    }
}