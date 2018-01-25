package com.github.attikovacs.quiz.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.github.attikovacs.quiz.command.QuestionGroupCommand;
import com.github.attikovacs.quiz.model.QuestionGroup;

import lombok.Synchronized;

@Component
public class QuestionGroupCommandToQuestionGroup implements Converter<QuestionGroupCommand, QuestionGroup> {

    private final QuestionCommandToQuestion questionConveter;

    public QuestionGroupCommandToQuestionGroup(QuestionCommandToQuestion questionConveter) {
        this.questionConveter = questionConveter;
    }

    @Synchronized
    @Nullable
    @Override
    public QuestionGroup convert(QuestionGroupCommand source) {
        if (source == null) {
            return null;
        }

        final QuestionGroup questionGroup = new QuestionGroup();
        
        questionGroup.setId(source.getId());
        questionGroup.setName(source.getName());
        questionGroup.setDescription(source.getDescription());

        if (source.getQuestions() != null && source.getQuestions().size() > 0) {
            source.getQuestions()
                    .forEach(question -> questionGroup.getQuestions().add(questionConveter.convert(question)));
        }

        return questionGroup;
    }

}
