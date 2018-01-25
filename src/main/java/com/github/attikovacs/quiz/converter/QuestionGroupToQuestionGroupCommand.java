package com.github.attikovacs.quiz.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.github.attikovacs.quiz.command.QuestionGroupCommand;
import com.github.attikovacs.quiz.model.QuestionGroup;

import lombok.Synchronized;

@Component
public class QuestionGroupToQuestionGroupCommand implements Converter<QuestionGroup, QuestionGroupCommand> {

    private final QuestionToQuestionCommand questionConveter;

    public QuestionGroupToQuestionGroupCommand(QuestionToQuestionCommand questionConveter) {
        this.questionConveter = questionConveter;
    }

    @Synchronized
    @Nullable
    @Override
    public QuestionGroupCommand convert(QuestionGroup source) {
        if (source == null) {
            return null;
        }

        final QuestionGroupCommand questionGroupCommand = new QuestionGroupCommand();
        
        questionGroupCommand.setId(source.getId());
        questionGroupCommand.setName(source.getName());
        questionGroupCommand.setDescription(source.getDescription());

        if (source.getQuestions() != null && source.getQuestions().size() > 0) {
            source.getQuestions()
                    .forEach(question -> questionGroupCommand.getQuestions().add(questionConveter.convert(question)));
        }

        return questionGroupCommand;
    }

}
