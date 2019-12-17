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

    public List<QuestionKey> findByEmail(String email) {
        return questionKeyRepository.findByEmail(email);
    }
}
