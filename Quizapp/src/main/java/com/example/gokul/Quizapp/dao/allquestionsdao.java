package com.example.gokul.Quizapp.dao;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.gokul.Quizapp.models.allquestions;

@Repository
@EnableJpaRepositories
public interface allquestionsdao extends JpaRepository<allquestions,Integer> {

    ArrayList<allquestions> findByCode(Integer code);
	
}
