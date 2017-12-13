package com.github.attikovacs.quiz.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.attikovacs.quiz.model.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Long> {

}
