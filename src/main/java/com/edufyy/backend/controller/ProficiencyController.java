package com.edufyy.backend.controller;

import com.edufyy.backend.model.GeneralResponseObject;
import com.edufyy.backend.model.ProficiencyRequest;
import com.edufyy.backend.model.Session;
import com.edufyy.backend.service.ProficiencyService;
import com.edufyy.backend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProficiencyController {

    @Autowired
    ProficiencyService proficiencyService;

    @Autowired
    SessionService sessionService;

    @PostMapping("/get_proficiency")
    public GeneralResponseObject getProficiency(@RequestBody ProficiencyRequest proficiencyRequest) {

        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();
        // Find session to extract email
        Session session = sessionService.findBySessionKey(proficiencyRequest.getSessionKey());
        if (session == null) {
            response = GeneralResponseObject.getFailureResponse();
            response.setResponseCode(-1);
            response.setResponseMessage("Invalid session, please login again");
            return response;
        }

        response = proficiencyService.getProficiency(session.getEmail(), proficiencyRequest.getQuestionKey());

        return response;

    }
}
