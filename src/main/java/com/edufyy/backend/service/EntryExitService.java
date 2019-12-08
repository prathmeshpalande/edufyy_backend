package com.edufyy.backend.service;

import com.edufyy.backend.model.GeneralResponseObject;
import com.edufyy.backend.model.LoginRequest;
import com.edufyy.backend.model.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public class EntryExitService {

    public GeneralResponseObject signup(SignupRequest signupRequest) {

        // TODO: Perform Signup

        return GeneralResponseObject.getSuccessResponse();
    }

    public GeneralResponseObject login(LoginRequest loginRequest) {

        // TODO: Perform Login

        return GeneralResponseObject.getSuccessResponse();
    }
}
