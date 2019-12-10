package com.edufyy.backend.component;

import com.edufyy.backend.model.Session;
import com.edufyy.backend.model.User;
import com.edufyy.backend.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionComponent {

    @Autowired
    SessionRepository sessionRepository;


    public void add(Session session) {
        sessionRepository.save(session);
    }

    public Integer updateSession(String sessionKey, String email) {
        return sessionRepository.updateSession(sessionKey, email);
    }
}
