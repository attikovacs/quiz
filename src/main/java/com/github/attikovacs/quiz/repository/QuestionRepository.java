package com.github.attikovacs.quiz.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.attikovacs.quiz.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
