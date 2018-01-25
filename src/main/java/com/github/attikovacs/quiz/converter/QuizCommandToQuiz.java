package com.github.attikovacs.quiz.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.github.attikovacs.quiz.command.QuizCommand;
import com.github.attikovacs.quiz.model.Quiz;

import lombok.Synchronized;

@Component
public class QuizCommandToQuiz implements Converter<QuizCommand, Quiz> {

    private final QuestionGroupCommandToQuestionGroup questionGroupConveter;

    public QuizCommandToQuiz(QuestionGroupCommandToQuestionGroup questionGroupConveter) {
        this.questionGroupConveter = questionGroupConveter;
    }

    @Synchronized
    @Nullable
    @Override
    public Quiz convert(QuizCommand source) {
        if (source == null) {
            return null;
        }

        final Quiz quiz = new Quiz();
        
        quiz.setId(source.getId());
        quiz.setName(source.getName());
        quiz.setDescription(source.getDescription());
        quiz.setLogo(source.getLogo());
        quiz.setQuestioningType(source.getQuestioningType());

        if (source.getQuestionGroups() != null && source.getQuestionGroups().size() > 0) {
            source.getQuestionGroups()
                    .forEach(questionGroup -> quiz.getQuestionGroups().add(questionGroupConveter.convert(questionGroup)));
        }

        return quiz;
    }

}
