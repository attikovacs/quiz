package com.github.attikovacs.quiz.command;

import java.util.HashSet;
import java.util.Set;

import com.github.attikovacs.quiz.enums.QuestioningType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class QuizCommand {

	private Long id;

	private String name;

	private String description;

	private Byte[] logo;

	private Set<QuestionGroupCommand> questionGroups = new HashSet<>();

	private QuestioningType questioningType;
	
}
