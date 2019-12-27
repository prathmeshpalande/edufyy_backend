package com.edufyy.backend.question.model;

import java.util.List;

public class QuestionKeyResponse {

    private long id;

    private String email;
    private String questionKey;
    private String name;
    private List<QuestionKeyResponse> questionKeys;

    public QuestionKeyResponse() {
    }
    public QuestionKeyResponse(long id, String email, String questionKey, String name, List<QuestionKeyResponse> questionKeys) {
        this.id = id;
        this.email = email;
        this.questionKey = questionKey;
        this.name = name;
        this.questionKeys = questionKeys;
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

    public String getQuestionKey() {
        return questionKey;
    }

    public void setQuestionKey(String questionKey) {
        this.questionKey = questionKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionKeyResponse> getQuestionKeys() {
        return questionKeys;
    }

    public void setQuestionKeys(List<QuestionKeyResponse> questionKeys) {
        this.questionKeys = questionKeys;
    }
}
