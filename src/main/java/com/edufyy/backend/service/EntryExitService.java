package com.edufyy.backend.service;

import com.edufyy.backend.model.GeneralResponseObject;
import com.edufyy.backend.model.LoginCredentials;
import com.edufyy.backend.model.SignupRequest;
import com.edufyy.backend.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryExitService {

    Logger logger = LoggerFactory.getLogger(EntryExitService.class);
    @Autowired
    UserService userService;

    public GeneralResponseObject signup(SignupRequest signupRequest) {

        // TODO: Perform Signup
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(signupRequest.getPassword());
        user.setPhone(signupRequest.getPhone());
        // Todo: Determine set premiun logic
        user.setPremium(true);
        user.setSource(signupRequest.getSource());

        try {
            userService.add(user);
        } catch(Exception e) {
            logger.error(e.toString());
            return GeneralResponseObject.getFailureResponse();
        }

        return GeneralResponseObject.getSuccessResponse();
    }

    public GeneralResponseObject login(LoginCredentials loginCredentials) {

        // TODO: Perform Login

        return GeneralResponseObject.getSuccessResponse();
    }
}
