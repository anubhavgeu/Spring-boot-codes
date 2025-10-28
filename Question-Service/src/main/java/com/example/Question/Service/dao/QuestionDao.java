package com.example.Question.Service.dao;


import com.example.Question.Service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);


    @Query(value = "SELECT g.id from Question q WHERE q.category=:category ORDER BY RAND() LIMIT :numq", nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, Integer numq);
}
