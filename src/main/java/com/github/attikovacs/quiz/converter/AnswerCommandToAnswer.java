package com.github.attikovacs.quiz.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.github.attikovacs.quiz.command.AnswerCommand;
import com.github.attikovacs.quiz.model.Answer;

import lombok.Synchronized;

@Component
public class AnswerCommandToAnswer implements Converter<AnswerCommand, Answer>{

    @Synchronized
    @Nullable
    @Override
    public Answer convert(AnswerCommand source) {
        if (source == null) {
            return null;
        }

        final Answer answer = new Answer();
        
        answer.setId(source.getId());
        answer.setAnswer(source.getAnswer());
        answer.setCorrect(source.isCorrect());
        answer.setImage(source.getImage());
        
        return answer;
    }
}
