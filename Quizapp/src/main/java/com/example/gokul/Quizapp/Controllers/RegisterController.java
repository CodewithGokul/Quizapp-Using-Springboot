package com.example.gokul.Quizapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gokul.Quizapp.dao.Userdao;
import com.example.gokul.Quizapp.models.Users;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    Userdao userdao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    // @Autowired
    // jwtService jwtservice;

@PostMapping("/register")
public String register(@Validated @ModelAttribute Users user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userdao.save(user);
    // String token = jwtservice.generateToken(user);
    return "login";
}

@GetMapping("/signup")
	public String signUp() {
		
		return "signup";
	}



}
