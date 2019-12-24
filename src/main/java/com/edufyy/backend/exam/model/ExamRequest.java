package com.edufyy.backend.exam.model;

public class ExamRequest {

    private String sessionKey;
    private String questionKey;
    private Integer questionCount;

    public ExamRequest() {
    }

    public ExamRequest(String sessionKey, String questionKey, Integer questionCount) {
        this.sessionKey = sessionKey;
        this.questionKey = questionKey;
        this.questionCount = questionCount;
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

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }
}
