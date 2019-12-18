package com.edufyy.backend.service;

import com.edufyy.backend.model.QuestionKey;
import com.edufyy.backend.repository.QuestionKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionKeyService {

    @Autowired
    QuestionKeyRepository questionKeyRepository;

    public List<QuestionKey> findByEmailQuestionKey(String email, String questionKey) {
        return questionKeyRepository.findByEmailQuestionKey(email, questionKey);
    }

    public List<QuestionKey> findByLength(String email, Integer length) {
        return questionKeyRepository.findByLength(email, length);
    }
}
