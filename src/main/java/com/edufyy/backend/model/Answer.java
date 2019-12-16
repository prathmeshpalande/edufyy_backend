package com.edufyy.backend.model;

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
    private Integer studentDifficulty;
    private Integer surity;
    private Character answer;
    public Answer() {
    }

    public Answer(long id, String email, String questionKey, Integer questionNumber, Integer studentDifficulty, Integer surity, Character answer) {
        this.id = id;
        this.email = email;
        this.questionKey = questionKey;
        this.questionNumber = questionNumber;
        this.studentDifficulty = studentDifficulty;
        this.surity = surity;
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

    public Integer getStudentDifficulty() {
        return studentDifficulty;
    }

    public void setStudentDifficulty(Integer studentDifficulty) {
        this.studentDifficulty = studentDifficulty;
    }

    public Integer getSurity() {
        return surity;
    }

    public void setSurity(Integer surity) {
        this.surity = surity;
    }

    public Character getAnswer() {
        return answer;
    }

    public void setAnswer(Character answer) {
        this.answer = answer;
    }
}
