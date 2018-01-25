package com.github.attikovacs.quiz.command;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class QuestionGroupCommand {

	private Long id;

	private String name;

	private String description;

	private Set<QuestionCommand> questions = new HashSet<>();
	
}
