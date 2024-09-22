package com.project.quiz.application.Service;

import com.project.quiz.application.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
}
