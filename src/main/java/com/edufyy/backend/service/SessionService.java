package com.edufyy.backend.service;

import com.edufyy.backend.model.Answer;
import com.edufyy.backend.model.Session;
import com.edufyy.backend.repository.SessionRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionService implements InitializingBean {

    @Autowired
    SessionRepository sessionRepository;


    public void add(Session session) {
        sessionRepository.save(session);
    }

    public Integer updateSession(String sessionKey, String email) {
        return sessionRepository.updateSession(sessionKey, email);
    }

    public Session findBySessionKey(String sessionKey) {
        return sessionRepository.findBySessionKey(sessionKey);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Session session = new Session();
        session.setEmail("palande1996@gmail.com");
        session.setSessionKey("s");

        sessionRepository.save(session);
    }
}
