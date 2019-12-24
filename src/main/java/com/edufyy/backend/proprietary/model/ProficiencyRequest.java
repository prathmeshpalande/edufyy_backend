package com.edufyy.backend.proprietary.model;

public class ProficiencyRequest {

    private String sessionKey;
    private String questionKey;

    public ProficiencyRequest() {
    }

    public ProficiencyRequest(String sessionKey, String questionKey) {
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
