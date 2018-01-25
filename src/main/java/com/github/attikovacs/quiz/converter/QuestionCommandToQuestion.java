package com.github.attikovacs.quiz.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.github.attikovacs.quiz.command.QuestionCommand;
import com.github.attikovacs.quiz.model.Question;

import lombok.Synchronized;

@Component
public class QuestionCommandToQuestion implements Converter<QuestionCommand, Question>{

	private final AnswerCommandToAnswer answerConveter;

    public QuestionCommandToQuestion(AnswerCommandToAnswer answerConveter) {
        this.answerConveter = answerConveter;
    }
	
    @Synchronized
    @Nullable
    @Override
    public Question convert(QuestionCommand source) {
        if (source == null) {
            return null;
        }

        final Question question = new Question();
        
        question.setId(source.getId());
        question.setQuestion(source.getQuestion());
        question.setImage(source.getImage());
        
        if (source.getAnswers() != null && source.getAnswers().size() > 0) {
            source.getAnswers()
                    .forEach(answer -> question.getAnswers().add(answerConveter.convert(answer)));
        }
        
        return question;
    }

}
