package com.edufyy.backend.question.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuestionKey {

    @Id
    @GeneratedValue
    private long id;

    private String email;
    private String questionKey;
    private String name;

    public QuestionKey() {
    }

    public QuestionKey(long id, String email, String questionKey, String name) {
        this.id = id;
        this.email = email;
        this.questionKey = questionKey;
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
}
