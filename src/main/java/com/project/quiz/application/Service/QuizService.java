package com.project.quiz.application.Service;

import com.project.quiz.application.dao.QuestionDao;
import com.project.quiz.application.dao.QuizDao;
import com.project.quiz.application.dto.QuestionDTO;
import com.project.quiz.application.entity.Question;
import com.project.quiz.application.entity.QuestionResponse;
import com.project.quiz.application.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService implements QuizServiceInterface{
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    @Override
    public ResponseEntity<Quiz> createQuiz(String category, int numOfQuestions, String title) {
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        List<Question> questionList = questionDao.findRandomQuestionsByCategory(category, numOfQuestions);
        quiz.setQuestions(questionList);
        quizDao.save(quiz);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();

        List<QuestionDTO> questionsToReturn = new ArrayList<>();
        for(Question question : questionsFromDB) {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setQuestionTitle(question.getQuestionTitle());
            questionDTO.setOption1(question.getOption1());
            questionDTO.setOption2(question.getOption2());
            questionDTO.setOption3(question.getOption3());
            questionDTO.setOption4(question.getOption4());
            questionsToReturn.add(questionDTO);
        }

        return new ResponseEntity<>(questionsToReturn, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getResult(int id, List<QuestionResponse> questionResponses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questionList = quiz.getQuestions();
        int score = 0;
        int i=0;
        StringBuilder builder = new StringBuilder("Candidate's score is: ");
        for(QuestionResponse questionResponse : questionResponses) {
            if(questionResponse.getResponse().equals(questionList.get(i).getCorrectAnswer()))
                score++;
            i++;
        }
        //Collections.sort(questionList, Comparator.comparingInt(Question::getId));
        builder.append(score);
        return new ResponseEntity<>(builder.toString(), HttpStatus.OK);
    }
}
