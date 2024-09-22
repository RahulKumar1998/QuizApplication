package com.project.quiz.application.Controller;

import com.project.quiz.application.Service.QuestionService;
import com.project.quiz.application.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question/")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("category") String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);
    }
}
