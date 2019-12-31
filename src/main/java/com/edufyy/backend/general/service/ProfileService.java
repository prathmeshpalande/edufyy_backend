package com.edufyy.backend.general.service;

import com.edufyy.backend.auth.model.Session;
import com.edufyy.backend.auth.model.User;
import com.edufyy.backend.auth.service.SessionService;
import com.edufyy.backend.auth.service.UserService;
import com.edufyy.backend.general.model.GeneralResponseObject;
import com.edufyy.backend.general.model.ProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    SessionService sessionService;

    @Autowired
    UserService userService;

    public GeneralResponseObject getProfile(ProfileRequest profileRequest) {
        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();

        Session session = sessionService.findBySessionKey(profileRequest.getSessionKey());

        if (session != null) {
            User user = userService.findByEmail(session.getEmail());
            response.setResponseData(user);
        } else {
            response.setResponseMessage("Invalid Session. Please re-login");
            response.setResponseCode(-2);
        }

        return response;
    }
}
