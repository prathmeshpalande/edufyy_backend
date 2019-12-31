package com.edufyy.backend.exam.service;

import com.edufyy.backend.auth.model.Session;
import com.edufyy.backend.auth.service.SessionService;
import com.edufyy.backend.exam.model.Answer;
import com.edufyy.backend.exam.model.AnswerSubmission;
import com.edufyy.backend.exam.model.ExamRequest;
import com.edufyy.backend.general.model.GeneralResponseObject;
import com.edufyy.backend.proprietary.service.ProficiencyService;
import com.edufyy.backend.question.model.Question;
import com.edufyy.backend.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

        List<Question> questions = questionService.getQuestions(examRequest.getQuestionKey(), proficiency, email);
        Collections.shuffle(questions);

        questions = questions.subList(0, (questions.size() >= examRequest.getQuestionCount()) ? examRequest.getQuestionCount() : questions.size());

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
        answer.setSurety(answerSubmission.getSurety());
        answer.setQuestionKey(answerSubmission.getQuestionKey());
        answer.setQuestionNumber(answerSubmission.getQuestionNumber());
        answer.setStudentDifficulty(answerSubmission.getStudentDifficulty());

        answerService.add(answer);

        Question question = questionService.findQuestionByUniqueIdentification(answerSubmission.getQuestionKey(), answerSubmission.getQuestionNumber(), email);

        Map<String, Boolean> responseData = new HashMap<>();
        responseData.put("isCorrect", question.getCorrectOption().equals(answerSubmission.getAnswer()));

        response.setResponseData(responseData);

        return response;
    }
}
