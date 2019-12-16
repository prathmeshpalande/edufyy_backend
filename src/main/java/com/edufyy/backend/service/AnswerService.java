package com.edufyy.backend.service;

import com.edufyy.backend.model.Answer;
import com.edufyy.backend.model.User;
import com.edufyy.backend.repository.AnswerRepository;
import com.edufyy.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public void add(Answer answer) {
        answerRepository.save(answer);
    }

    public List<Answer> findByQuestionKey(String email, String questionKey) {
        return answerRepository.findByQuestionKey(email, questionKey);
    }

}
