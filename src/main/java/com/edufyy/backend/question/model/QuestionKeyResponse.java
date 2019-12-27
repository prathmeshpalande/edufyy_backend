package com.edufyy.backend.question.model;

import java.util.List;

public class QuestionKeyResponse {

    private long id;
    private String email;
    private List<QuestionKeyResponse> questionKeys;
    private String name;

    public QuestionKeyResponse() {
    }

    public QuestionKeyResponse(long id, String email, List<QuestionKeyResponse> questionKeys, String name) {
        this.id = id;
        this.email = email;
        this.questionKeys = questionKeys;
        this.name = name;
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

    public List<QuestionKeyResponse> getQuestionKeys() {
        return questionKeys;
    }

    public void setQuestionKeys(List<QuestionKeyResponse> questionKeys) {
        this.questionKeys = questionKeys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
