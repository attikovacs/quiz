package com.github.attikovacs.quiz.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.github.attikovacs.quiz.model.Quiz;
import com.github.attikovacs.quiz.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	private final QuizRepository quizRepository;

	public QuizServiceImpl(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	@Override
	public Set<Quiz> getQuizzes() {
		Set<Quiz> set = new HashSet<>();
		quizRepository.findAll().iterator().forEachRemaining(set::add);
		return set;
	}

}
