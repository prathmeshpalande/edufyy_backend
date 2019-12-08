package com.edufyy.backend.model;

public class ExamRequest {

    private String sessionKey;
    private String examType;

    public ExamRequest() {
    }

    public ExamRequest(String sessionKey, String examType) {
        this.sessionKey = sessionKey;
        this.examType = examType;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }
}
