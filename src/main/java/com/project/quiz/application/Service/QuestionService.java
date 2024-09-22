package com.project.quiz.application.Service;

import com.project.quiz.application.dao.QuestionDao;
import com.project.quiz.application.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements QuestionServiceInterface{
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questions = questionDao.findAll();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
        List<Question> questions = questionDao.findByCategory(category);
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Question> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>(question,HttpStatus.OK);
    }
}
