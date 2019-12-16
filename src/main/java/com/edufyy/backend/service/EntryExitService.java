package com.edufyy.backend.service;

import com.edufyy.backend.model.*;
import com.edufyy.backend.util.Emailer;
import com.edufyy.backend.util.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EntryExitService {

    Logger logger = LoggerFactory.getLogger(EntryExitService.class);

    @Autowired
    UserService userService;

    @Autowired
    SessionService sessionService;

    public GeneralResponseObject signup(SignupRequest signupRequest) {

        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(signupRequest.getPassword());
        user.setPhone(signupRequest.getPhone());
        // Todo: Determine set premium logic
        user.setPremium(true);
        user.setSource(signupRequest.getSource());

        try {
            userService.add(user);
        } catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            logger.error(e.toString());
            response = GeneralResponseObject.getFailureResponse();
            response.setResponseMessage("User already exists, please continue to login!");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
            response = GeneralResponseObject.getFailureResponse();
            return response;
        }

        String otp = Emailer.sendOTP(signupRequest.getEmail(), signupRequest.getName());

        response.setResponseMessage("OTP Sent on Email");

        String sessionKey = MD5.getMd5(signupRequest.getEmail() + System.currentTimeMillis());
        Session session = new Session();
        session.setEmail(signupRequest.getEmail());
        session.setSessionKey(sessionKey);
        sessionService.add(session);

        Map<String, String> responseData = new HashMap<>();
        responseData.put("otp", otp);
        responseData.put("sessionKey", sessionKey);
        response.setResponseData(responseData);

        return response;
    }

    public GeneralResponseObject login(LoginCredentials loginCredentials) {

        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();
        User user = userService.findByEmail(loginCredentials.getEmail());

        if(user != null) {
            if(user.getPassword().equals(loginCredentials.getPassword())) {
                String sessionKey = MD5.getMd5(loginCredentials.getEmail() + System.currentTimeMillis());
                Integer updateResponse = sessionService.updateSession(sessionKey, loginCredentials.getEmail());

                if(updateResponse == 0) {
                    Session session = new Session();
                    session.setEmail(loginCredentials.getEmail());
                    session.setSessionKey(sessionKey);
                    sessionService.add(session);
                }

                Map<String, String> responseData = new HashMap<>();
                responseData.put("sessionKey", sessionKey);
                response.setResponseData(responseData);
            }
        }
        else {
            response = GeneralResponseObject.getFailureResponse();
            response.setResponseMessage("Invalid user. Please try signing up!");
        }

        return response;
    }
}
