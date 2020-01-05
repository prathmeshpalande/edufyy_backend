package com.edufyy.backend.question.model;

public class PublishHomeWorkRequest {

    private String sessionKey;
    private String sectionKey;
    private String questionKey;

    public PublishHomeWorkRequest() {
    }

    public PublishHomeWorkRequest(String sessionKey, String sectionKey, String questionKey) {
        this.sessionKey = sessionKey;
        this.sectionKey = sectionKey;
        this.questionKey = questionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSectionKey() {
        return sectionKey;
    }

    public void setSectionKey(String sectionKey) {
        this.sectionKey = sectionKey;
    }

    public String getQuestionKey() {
        return questionKey;
    }

    public void setQuestionKey(String questionKey) {
        this.questionKey = questionKey;
    }
}
