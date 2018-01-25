package com.github.attikovacs.quiz.service;

import java.util.Set;

import com.github.attikovacs.quiz.command.QuizCommand;
import com.github.attikovacs.quiz.model.Quiz;

public interface QuizService {

	Set<Quiz> getQuizzes();
	
	Quiz findQuizById(Long id);
	
	QuizCommand saveQuizCommand(QuizCommand command);

}
