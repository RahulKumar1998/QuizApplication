package com.project.quiz.application.dao;

import com.project.quiz.application.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numOfQuestions " , nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numOfQuestions);
}
