package com.edufyy.backend.service;

import com.edufyy.backend.model.Session;
import com.edufyy.backend.model.User;
import com.edufyy.backend.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionService {

    @Autowired
    SessionRepository sessionRepository;


    public void add(Session session) {
        sessionRepository.save(session);
    }

    public Integer updateSession(String sessionKey, String email) {
        return sessionRepository.updateSession(sessionKey, email);
    }
}
