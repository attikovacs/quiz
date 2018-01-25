package com.github.attikovacs.quiz.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AnswerCommand {

	private Long id;

	private String answer;

	private boolean isCorrect;

	private Byte[] image;

}
