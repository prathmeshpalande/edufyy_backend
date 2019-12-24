package com.edufyy.backend.exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    private long id;

    private String email;
    private String questionKey;
    private Integer questionNumber;
    private Double studentDifficulty;
    private Integer surety;
    private Character answer;

    public Answer() {
    }

    public Answer(long id, String email, String questionKey, Integer questionNumber, Double studentDifficulty, Integer surety, Character answer) {
        this.id = id;
        this.email = email;
        this.questionKey = questionKey;
        this.questionNumber = questionNumber;
        this.studentDifficulty = studentDifficulty;
        this.surety = surety;
        this.answer = answer;
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

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Double getStudentDifficulty() {
        return studentDifficulty;
    }

    public void setStudentDifficulty(Double studentDifficulty) {
        this.studentDifficulty = studentDifficulty;
    }

    public Integer getSurety() {
        return surety;
    }

    public void setSurety(Integer surety) {
        this.surety = surety;
    }

    public Character getAnswer() {
        return answer;
    }

    public void setAnswer(Character answer) {
        this.answer = answer;
    }
}
