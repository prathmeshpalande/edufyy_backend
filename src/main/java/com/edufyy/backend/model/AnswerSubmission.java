package com.edufyy.backend.model;

public class AnswerSubmission {

    private String sessionKey;
    private String questionKey;
    private Integer questionNumber;
    private Double studentDifficulty;
    private Integer surity;
    private Character answer;

    public AnswerSubmission() {
    }

    public AnswerSubmission(String sessionKey, String questionKey, Integer questionNumber, Double studentDifficulty, Integer surity, Character answer) {
        this.sessionKey = sessionKey;
        this.questionKey = questionKey;
        this.questionNumber = questionNumber;
        this.studentDifficulty = studentDifficulty;
        this.surity = surity;
        this.answer = answer;
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
