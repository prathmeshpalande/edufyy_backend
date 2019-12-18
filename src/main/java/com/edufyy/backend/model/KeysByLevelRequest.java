package com.edufyy.backend.model;

public class KeysByLevelRequest {

    private String sessionKey;
    private String questionKey;

    public KeysByLevelRequest() {
    }

    public KeysByLevelRequest(String sessionKey, String questionKey) {
        this.sessionKey = sessionKey;
        this.questionKey = questionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getQuestionKey() {
        return questionKey;
    }

    public void setQuestionKey(String questionKey) {
        this.questionKey = questionKey;
    }
}
