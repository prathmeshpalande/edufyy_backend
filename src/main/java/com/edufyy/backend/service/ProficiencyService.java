package com.edufyy.backend.service;

import com.edufyy.backend.model.Answer;
import com.edufyy.backend.model.GeneralResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProficiencyService {

    @Autowired
    AnswerService answerService;

    public GeneralResponseObject getProficiency(String email, String questionKey) {

        List<Answer> answers = answerService.findByQuestionKey(email, questionKey);

        // TODO: Proficiency Calculation Logic
        // Map difficulty to answers
        // Count total answers
        // Count total difficulty attempted
        // Find individual proficiency and calculate key proficiency

        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();

        return response;
    }
}
