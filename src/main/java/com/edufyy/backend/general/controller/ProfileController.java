package com.edufyy.backend.general.controller;

import com.edufyy.backend.general.model.GeneralResponseObject;
import com.edufyy.backend.general.model.ProfileRequest;
import com.edufyy.backend.general.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping("/profile")
    public GeneralResponseObject getProfile(@RequestBody ProfileRequest profileRequest) {
        GeneralResponseObject response = profileService.getProfile(profileRequest);

        return response;
    }

}
