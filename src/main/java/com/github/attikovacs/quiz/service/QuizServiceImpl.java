package com.github.attikovacs.quiz.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.attikovacs.quiz.command.QuizCommand;
import com.github.attikovacs.quiz.converter.QuizCommandToQuiz;
import com.github.attikovacs.quiz.converter.QuizToQuizCommand;
import com.github.attikovacs.quiz.model.Quiz;
import com.github.attikovacs.quiz.repository.QuizRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuizServiceImpl implements QuizService {

	private final QuizRepository quizRepository;
	private final QuizCommandToQuiz quizCommandToQuiz;
    private final QuizToQuizCommand quizToQuizCommand;

	public QuizServiceImpl(QuizRepository quizRepository, QuizCommandToQuiz quizCommandToQuiz, QuizToQuizCommand quizToQuizCommand) {
		this.quizRepository = quizRepository;
		this.quizCommandToQuiz = quizCommandToQuiz;
		this.quizToQuizCommand = quizToQuizCommand;
	}

	@Override
	public Set<Quiz> getQuizzes() {
		Set<Quiz> set = new HashSet<>();
		quizRepository.findAll().iterator().forEachRemaining(set::add);
		return set;
	}

	@Override
	public Quiz findQuizById(Long id) {
		Optional<Quiz> quizOptional = quizRepository.findById(id);
		
		if (!quizOptional.isPresent()) {
			throw new RuntimeException("Quiz not found: " + id);
		}
		
		return quizOptional.get();
	}

	@Override
	@Transactional
	public QuizCommand saveQuizCommand(QuizCommand command) {
        Quiz detachedQuiz = quizCommandToQuiz.convert(command);

        Quiz savedQuiz = quizRepository.save(detachedQuiz);
        log.debug("Saved Quiz Id: " + savedQuiz.getId());
        return quizToQuizCommand.convert(savedQuiz);
	}

}
