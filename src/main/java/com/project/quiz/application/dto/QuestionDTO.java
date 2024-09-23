package com.project.quiz.application.dto;

import lombok.Data;

@Data
public class QuestionDTO {
    private int id;

    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
