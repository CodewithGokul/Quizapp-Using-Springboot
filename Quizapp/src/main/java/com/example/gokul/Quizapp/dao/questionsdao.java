package com.example.gokul.Quizapp.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.gokul.Quizapp.models.allquestions;
import com.example.gokul.Quizapp.models.questions;

@Repository
public interface questionsdao extends JpaRepository<questions, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE questions SET option_a = NULL WHERE id = :questionId", nativeQuery = true)
    void deleteOptiona(@Param("questionId") Integer questionId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE questions SET option_b = NULL WHERE id = :questionId", nativeQuery = true)
    void deleteOptionb(@Param("questionId") Integer questionId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE questions SET option_c = NULL WHERE id = :questionId", nativeQuery = true)
    void deleteOptionc(@Param("questionId") Integer questionId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE questions SET option_d = NULL WHERE id = :questionId", nativeQuery = true)
    void deleteOptiond(@Param("questionId") Integer questionId);

    ArrayList<questions> findByCode(Integer code);

}
