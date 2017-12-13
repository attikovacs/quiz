package com.github.attikovacs.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.attikovacs.quiz.service.QuizService;

@Controller
public class IndexController {

	private final QuizService quizService;

	public IndexController(QuizService quizService) {
		this.quizService = quizService;
	}

	@RequestMapping(value = { "", "/" })
	public String getIndex(Model model) {
		model.addAttribute("quizzes", quizService.getQuizzes());
		return "index";
	}

}