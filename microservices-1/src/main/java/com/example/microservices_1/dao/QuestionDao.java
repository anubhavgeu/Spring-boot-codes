package com.example.microservices_1.dao;


import com.example.microservices_1.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);


    @Query(value = "SELECT * from Question q WHERE q.category=:category ORDER BY RAND() LIMIT :numq", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, Integer numq);
}
