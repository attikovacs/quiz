package com.github.attikovacs.quiz.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.github.attikovacs.quiz.model.Answer;
import com.github.attikovacs.quiz.model.Question;
import com.github.attikovacs.quiz.model.QuestionGroup;
import com.github.attikovacs.quiz.model.Quiz;
import com.github.attikovacs.quiz.repository.QuestionGroupRepository;
import com.github.attikovacs.quiz.repository.QuizRepository;

@Component
public class QuizBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final QuizRepository quizRepository;
	
	private final QuestionGroupRepository questionGroupRepository;

	public QuizBootstrap(QuizRepository quizRepository, QuestionGroupRepository questionGroupRepository) {
		this.quizRepository = quizRepository;
		this.questionGroupRepository = questionGroupRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		quizRepository.saveAll(initQuizzes());
	}

	private List<Quiz> initQuizzes() {
		List<Quiz> quizzes = new ArrayList<>(2);

		Quiz quiz1 = new Quiz();
		quiz1.setName("Quiz1");
		quiz1.setDescription("Living creatures");
		
		QuestionGroup qg1 = new QuestionGroup();
		qg1.setName("Animals");
		qg1.setDescription("Animal related questions");
		
		Question q1 = new Question();
		q1.setQuestion("How many legs does a horse have?");
		
		Answer a1 = new Answer();
		a1.setAnswer("4");
		a1.setCorrect(Boolean.TRUE);
		a1.setQuestion(q1);
		
		q1.getAnswers().add(a1);
		q1.setQuestionGroup(qg1);
		
		qg1.getQuestions().add(q1);
		qg1.getQuizzes().add(quiz1);
		
		questionGroupRepository.save(qg1);
		
		quiz1.getQuestionGroups().add(qg1);
		quizzes.add(quiz1);
		
		return quizzes;
	}

}
