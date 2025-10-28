package com.example.quiz_service.service;

import com.example.quiz_service.feign.QuizInterface;
import com.example.quiz_service.model.QuizDto;
import com.example.quiz_service.dao.QuizDao;
import com.example.quiz_service.model.Question;
import com.example.quiz_service.model.QuestionWrapper;
import com.example.quiz_service.model.Quiz;
import com.example.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
//    @Autowired
//    QuestionDao questionDao;
    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String categoryName, Integer numOfQuestion, String title) {

        List<Integer> questions = quizInterface.getQuestionsForQuiz(categoryName,numOfQuestion).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
//        Optional<Quiz> quizOptional = quizDao.findById(id);
//        List<Question> questionsFromDB = quizOptional.get().getQuestions();
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
//        for (Question q: questionsFromDB) {
//            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
//            questionForUser.add(qw);
//        }

        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;
    }


}
