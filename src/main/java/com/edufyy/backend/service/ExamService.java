package com.edufyy.backend.service;

import com.edufyy.backend.model.ExamRequest;
import com.edufyy.backend.model.GeneralResponseObject;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

    public GeneralResponseObject getExam(ExamRequest examRequest) {

        // TODO: Return Exam

        return GeneralResponseObject.getSuccessResponse();
    }
}
