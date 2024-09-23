package com.project.quiz.application.Controller;

import com.project.quiz.application.Service.QuizService;
import com.project.quiz.application.dto.QuestionDTO;
import com.project.quiz.application.entity.QuestionResponse;
import com.project.quiz.application.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz/")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<Quiz> createQuiz(@RequestParam String category, @RequestParam int numOfQuestions, @RequestParam String title) {
        return quizService.createQuiz(category, numOfQuestions, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(@PathVariable int id) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<String> submitQuiz(@PathVariable int id, @RequestBody List<QuestionResponse> questionResponses) {
        return quizService.getResult(id, questionResponses);
    }
}
