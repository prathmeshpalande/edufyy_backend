package com.edufyy.backend.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Session {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String email;

    private String sessionKey;

    public Session() {
    }

    public Session(long id, String email, String sessionKey) {
        this.id = id;
        this.email = email;
        this.sessionKey = sessionKey;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
