package com.example.Question.Service.controller;


import com.example.Question.Service.model.Question;
import com.example.Question.Service.model.QuestionWrapper;
import com.example.Question.Service.model.Response;
import com.example.Question.Service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {


    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }


    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    // generate Question

    // Returning list of question Id
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer noOfQuestions) {
        return questionService.getQuestionForQuiz(categoryName,noOfQuestions);
    }
    // get question of particular Quiz - > based On QuestionId;
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestParam List<Integer> questionIds){
        return questionService.getQuestionsFromId(questionIds);
    }
    // calculateScore here -> because all the questions are here
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
        return questionService.getScore(responses);
    }

}
