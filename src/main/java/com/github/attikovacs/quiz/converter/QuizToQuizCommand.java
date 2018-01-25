package com.github.attikovacs.quiz.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.github.attikovacs.quiz.command.QuizCommand;
import com.github.attikovacs.quiz.model.Quiz;

import lombok.Synchronized;

@Component
public class QuizToQuizCommand implements Converter<Quiz, QuizCommand> {

    private final QuestionGroupToQuestionGroupCommand questionGroupConveter;

    public QuizToQuizCommand(QuestionGroupToQuestionGroupCommand questionGroupConveter) {
        this.questionGroupConveter = questionGroupConveter;
    }

    @Synchronized
    @Nullable
    @Override
    public QuizCommand convert(Quiz source) {
        if (source == null) {
            return null;
        }

        final QuizCommand quizCommand = new QuizCommand();
        
        quizCommand.setId(source.getId());
        quizCommand.setName(source.getName());
        quizCommand.setDescription(source.getDescription());
        quizCommand.setLogo(source.getLogo());
        quizCommand.setQuestioningType(source.getQuestioningType());

        if (source.getQuestionGroups() != null && source.getQuestionGroups().size() > 0) {
            source.getQuestionGroups()
                    .forEach(questionGroup -> quizCommand.getQuestionGroups().add(questionGroupConveter.convert(questionGroup)));
        }

        return quizCommand;
    }

}
