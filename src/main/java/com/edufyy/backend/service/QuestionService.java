package com.edufyy.backend.service;

import com.edufyy.backend.model.Question;
import com.edufyy.backend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public Question findQuestionByAnswer(String questionKey, Integer questionNumber) {
        return questionRepository.findQuestionByAnswer(questionKey, questionNumber);
    }

    public Question findByAnswer(String questionKey, Integer questionNumber, Character answer) {
        return questionRepository.findByAnswer(questionKey, questionNumber, answer);
    }
}
