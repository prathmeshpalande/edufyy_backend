package com.edufyy.backend.controller;

import com.edufyy.backend.model.GeneralResponseObject;
import com.edufyy.backend.model.LoginCredentials;
import com.edufyy.backend.model.SignupRequest;
import com.edufyy.backend.service.EntryExitService;
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
}
