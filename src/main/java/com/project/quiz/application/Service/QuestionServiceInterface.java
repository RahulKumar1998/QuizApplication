package com.project.quiz.application.Service;

import com.project.quiz.application.entity.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionServiceInterface {

    public ResponseEntity<List<Question>> getAllQuestions();
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category);
    public ResponseEntity<Question> addQuestion(Question question);
}
