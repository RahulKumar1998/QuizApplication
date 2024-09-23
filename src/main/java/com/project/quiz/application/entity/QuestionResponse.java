package com.project.quiz.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class QuestionResponse {

    private int id;
    private String response;
}
