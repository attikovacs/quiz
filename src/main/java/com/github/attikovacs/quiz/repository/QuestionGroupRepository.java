package com.github.attikovacs.quiz.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.attikovacs.quiz.model.QuestionGroup;

public interface QuestionGroupRepository extends CrudRepository<QuestionGroup, Long> {

}
