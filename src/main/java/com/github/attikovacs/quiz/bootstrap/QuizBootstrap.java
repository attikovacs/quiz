package com.github.attikovacs.quiz.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.github.attikovacs.quiz.enums.QuestioningType;
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
		quiz1.setQuestioningType(QuestioningType.ABCD);
		
		QuestionGroup qg1 = new QuestionGroup();
		qg1.setName("Animals");
		qg1.setDescription("Animal related questions");
		
		Question q1 = new Question();
		q1.setQuestion("What is the name of the famous little pig?");	
		Answer a1 = new Answer();
		a1.setAnswer("Babe");
		a1.setCorrect(Boolean.TRUE);
		q1.addAnswer(a1);
		qg1.addQuestion(q1);
		
		Question q2 = new Question();
		q2.setQuestion("How many lives does a cat have?");	
		Answer a2 = new Answer();
		a2.setAnswer("9");
		a2.setCorrect(Boolean.TRUE);
		q2.addAnswer(a2);
		qg1.addQuestion(q2);
		
		Question q3 = new Question();
		q3.setQuestion("How many legs does a horse have?");	
		Answer a3 = new Answer();
		a3.setAnswer("4");
		a3.setCorrect(Boolean.TRUE);
		q3.addAnswer(a3);
		qg1.addQuestion(q3);
		
		qg1.getQuizzes().add(quiz1);
		
		questionGroupRepository.save(qg1);
		
		quiz1.getQuestionGroups().add(qg1);
		quizzes.add(quiz1);
		
		return quizzes;
	}

}
