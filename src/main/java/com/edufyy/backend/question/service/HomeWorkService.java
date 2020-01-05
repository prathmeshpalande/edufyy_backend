package com.edufyy.backend.question.service;

import com.edufyy.backend.auth.model.Session;
import com.edufyy.backend.auth.service.SessionService;
import com.edufyy.backend.general.model.GeneralResponseObject;
import com.edufyy.backend.question.model.HomeWork;
import com.edufyy.backend.question.model.PublishHomeWorkRequest;
import com.edufyy.backend.question.model.Section;
import com.edufyy.backend.question.repository.HomeWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HomeWorkService {

    @Autowired
    SessionService sessionService;

    @Autowired
    SectionService sectionService;

    @Autowired
    HomeWorkRepository homeWorkRepository;

    public GeneralResponseObject publishHomeWork(PublishHomeWorkRequest publishHomeWorkRequest) {
        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();

        Session session = sessionService.findBySessionKey(publishHomeWorkRequest.getSessionKey());

        if (session == null) {
            response = GeneralResponseObject.getFailureResponse();
            response.setResponseCode(-1);
            response.setResponseMessage("Invalid session, please login again");
            return response;
        }

        String email = session.getEmail();

        Section section = sectionService.verifyTeacherBySectionKey(email, publishHomeWorkRequest.getSectionKey());

        if (section == null) {
            response = GeneralResponseObject.getFailureResponse();
            response.setResponseCode(-2);
            response.setResponseMessage("Teacher not authorized to publish homework to the given section!");
            return response;
        }

        HomeWork homeWork = new HomeWork();
        homeWork.setDate(new Date());
        homeWork.setQuestionKey(publishHomeWorkRequest.getQuestionKey());
        homeWork.setSectionKey(publishHomeWorkRequest.getSectionKey());

        homeWorkRepository.save(homeWork);

        return response;
    }

}
