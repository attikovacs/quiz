package com.github.attikovacs.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.attikovacs.quiz.command.QuizCommand;
import com.github.attikovacs.quiz.service.QuizService;

@Controller
public class QuizController {

	private final QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}

	@RequestMapping("/quiz/show/{id}")
	public String showQuizById(@PathVariable String id, Model model) {
		model.addAttribute("quiz", quizService.findQuizById(new Long(id)));
		return "quiz/quizshow";
	}
	
	@RequestMapping("/quiz/new")
    public String newQuiz(Model model){
        model.addAttribute("quiz", new QuizCommand());
        return "quiz/quizform";
    }
	
	@PostMapping
	@RequestMapping("quiz")
	public String saveOrUpdate(QuizCommand command) {
		QuizCommand savedCommand = quizService.saveQuizCommand(command);
        return "redirect:/quiz/show/" + savedCommand.getId();
    }
	
}
