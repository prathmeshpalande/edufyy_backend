package com.edufyy.backend.service;

import com.edufyy.backend.model.*;
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

    @Autowired
    AnswerService answerService;

    public GeneralResponseObject getExam(ExamRequest examRequest) {

        // TODO: Return Exam

        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();
        Session session = sessionService.findBySessionKey(examRequest.getSessionKey());

        if (session == null) {
            response = GeneralResponseObject.getFailureResponse();
            response.setResponseCode(-1);
            response.setResponseMessage("Invalid session, please login again");
            return response;
        }

        String email = session.getEmail();

        GeneralResponseObject proficiencyObject = proficiencyService.getProficiency(email, examRequest.getQuestionKey());
        Double proficiency = ((Map <String ,Double>) proficiencyObject.getResponseData()).get("proficiency");

        List<Question> questions = questionService.getQuestions(examRequest.getQuestionKey(), proficiency);

        Map<String, List<Question>> responseData = new HashMap<>();
        responseData.put("questions", questions);
        response.setResponseData(responseData);

        return response;
    }

    public GeneralResponseObject registerAnswer(AnswerSubmission answerSubmission) {

        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();
        Session session = sessionService.findBySessionKey(answerSubmission.getSessionKey());

        if (session == null) {
            response = GeneralResponseObject.getFailureResponse();
            response.setResponseCode(-1);
            response.setResponseMessage("Invalid session, please login again");
            return response;
        }

        String email = session.getEmail();

        Answer answer = new Answer();
        answer.setEmail(email);
        answer.setAnswer(answerSubmission.getAnswer());
        answer.setSurity(answerSubmission.getSurity());
        answer.setQuestionKey(answerSubmission.getQuestionKey());
        answer.setQuestionNumber(answerSubmission.getQuestionNumber());
        answer.setStudentDifficulty(answerSubmission.getStudentDifficulty());

        answerService.add(answer);
        
        return response;
    }
}
