package com.edufyy.backend.model;

public class KeysByLevelRequest {

    private String sessionKey;
    private Integer level;

    public KeysByLevelRequest() {
    }

    public KeysByLevelRequest(String sessionKey, Integer level) {
        this.sessionKey = sessionKey;
        this.level = level;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
