package com.project.quiz.application.Service;

import com.project.quiz.application.dto.QuestionDTO;
import com.project.quiz.application.entity.QuestionResponse;
import com.project.quiz.application.entity.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizServiceInterface {
    ResponseEntity<Quiz> createQuiz(String category, int numOfQuestions, String title);
    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(int id);

    ResponseEntity<String> getResult(int id, List<QuestionResponse> responses);
}
