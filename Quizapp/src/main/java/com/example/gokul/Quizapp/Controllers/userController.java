package com.example.gokul.Quizapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gokul.Quizapp.models.Users;
import com.example.gokul.Quizapp.services.userServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class userController {
    @Autowired
    userServices userservices;

   @GetMapping("/signup")
   public String getMethodName() {
       return "signup";
   }
   @PostMapping("/saveAccount")
   public String postMethodName(@Validated @ModelAttribute Users users) {
        userservices.saveUsers(users);
        return "redirect:/index";
   }
   
   
    
}
