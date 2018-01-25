package com.github.attikovacs.quiz.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.github.attikovacs.quiz.command.AnswerCommand;
import com.github.attikovacs.quiz.model.Answer;

import lombok.Synchronized;

@Component
public class AnswerToAnswerCommand implements Converter<Answer, AnswerCommand>{

    @Synchronized
    @Nullable
    @Override
    public AnswerCommand convert(Answer source) {
        if (source == null) {
            return null;
        }

        final AnswerCommand answerCommand = new AnswerCommand();
        
        answerCommand.setId(source.getId());
        answerCommand.setAnswer(source.getAnswer());
        answerCommand.setCorrect(source.isCorrect());
        answerCommand.setImage(source.getImage());
        
        return answerCommand;
    }

}
