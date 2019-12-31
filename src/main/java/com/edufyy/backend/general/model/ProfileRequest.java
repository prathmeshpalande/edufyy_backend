package com.edufyy.backend.general.model;

public class ProfileRequest {

    private String sessionKey;

    public ProfileRequest() {
    }

    public ProfileRequest(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
