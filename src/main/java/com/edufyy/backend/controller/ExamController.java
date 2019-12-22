package com.edufyy.backend.controller;

import com.edufyy.backend.model.AnswerSubmission;
import com.edufyy.backend.model.ExamRequest;
import com.edufyy.backend.model.GeneralResponseObject;
import com.edufyy.backend.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {

    @Autowired
    ExamService examService;

    @PostMapping("/exam")
    public GeneralResponseObject getExam(@RequestBody ExamRequest examRequest) {

        GeneralResponseObject response = examService.getExam(examRequest);

        return response;

    }

    @PostMapping("/submit_answer")
    public GeneralResponseObject registerAnswer(@RequestBody AnswerSubmission answerSubmission) {

        GeneralResponseObject response = examService.registerAnswer(answerSubmission);

        return response;
    }
}
