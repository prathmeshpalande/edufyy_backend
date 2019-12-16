package com.edufyy.backend.service;

import com.edufyy.backend.model.ExamRequest;
import com.edufyy.backend.model.GeneralResponseObject;
import com.edufyy.backend.model.Question;
import com.edufyy.backend.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExamService {

    @Autowired
    ProficiencyService proficiencyService;

    @Autowired
    SessionService sessionService;

    @Autowired
    QuestionService questionService;

    public GeneralResponseObject getExam(ExamRequest examRequest) {

        // TODO: Return Exam

        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();
        Session session = sessionService.findBySessionKey(examRequest.getSessionKey());
        String email = session.getEmail();

        GeneralResponseObject proficiencyObject = proficiencyService.getProficiency(email, examRequest.getQuestionKey());
        Double proficiency = ((Map <String ,Double>) proficiencyObject.getResponseData()).get("proficiency");

        List<Question> questions = questionService.getQuestions(examRequest.getQuestionKey(), proficiency);

        Map<String, List<Question>> responseData = new HashMap<>();
        responseData.put("questions", questions);
        response.setResponseData(responseData);

        return response;
    }
}
