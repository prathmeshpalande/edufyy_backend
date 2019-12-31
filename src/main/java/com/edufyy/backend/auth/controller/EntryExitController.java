package com.edufyy.backend.auth.controller;

import com.edufyy.backend.auth.model.ResetPasswordRequest;
import com.edufyy.backend.auth.service.EntryExitService;
import com.edufyy.backend.auth.model.LoginCredentials;
import com.edufyy.backend.auth.model.SignupRequest;
import com.edufyy.backend.general.model.GeneralResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryExitController {

    @Autowired
    EntryExitService entryExitService;

    @PostMapping("/signup")
    public GeneralResponseObject signup(@RequestBody SignupRequest signupRequest) {

        GeneralResponseObject response = entryExitService.signup(signupRequest);

        return response;
    }

    @PostMapping("/login")
    public GeneralResponseObject login(@RequestBody LoginCredentials loginCredentials) {

        GeneralResponseObject response = entryExitService.login(loginCredentials);

        return response;
    }

    @PostMapping("/reset_password")
    public GeneralResponseObject resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        GeneralResponseObject response = entryExitService.resetPassword(resetPasswordRequest);

        return response;
    }
}
