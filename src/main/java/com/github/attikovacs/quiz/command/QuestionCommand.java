package com.github.attikovacs.quiz.command;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class QuestionCommand {

	private Long id;

	private String question;

	private Set<AnswerCommand> answers = new HashSet<>();

	private Byte[] image;

}
