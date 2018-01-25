package com.github.attikovacs.quiz.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.github.attikovacs.quiz.command.QuestionCommand;
import com.github.attikovacs.quiz.model.Question;

import lombok.Synchronized;

@Component
public class QuestionToQuestionCommand implements Converter<Question, QuestionCommand>{

	private final AnswerToAnswerCommand answerConveter;

    public QuestionToQuestionCommand(AnswerToAnswerCommand answerConveter) {
        this.answerConveter = answerConveter;
    }
	
    @Synchronized
    @Nullable
    @Override
    public QuestionCommand convert(Question source) {
        if (source == null) {
            return null;
        }

        final QuestionCommand questionCommand = new QuestionCommand();
        
        questionCommand.setId(source.getId());
        questionCommand.setQuestion(source.getQuestion());
        questionCommand.setImage(source.getImage());
        
        if (source.getAnswers() != null && source.getAnswers().size() > 0) {
            source.getAnswers()
                    .forEach(answer -> questionCommand.getAnswers().add(answerConveter.convert(answer)));
        }
        
        return questionCommand;
    }

}
