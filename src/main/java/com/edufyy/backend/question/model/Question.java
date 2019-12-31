package com.edufyy.backend.question.model;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private long id;

    private String email;
    private String questionKey;
    private Integer questionNumber;

    @Lob
    @Column( length = 100000 )
    private String question;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private Character correctOption;
    private Double developerDifficulty;
    private Double studentDifficulty;
    private Boolean isPremium;

    public Question() {
    }

    public Question(long id, String email, String questionKey, Integer questionNumber, String question, String optionA, String optionB, String optionC, String optionD, Character correctOption, Double developerDifficulty, Double studentDifficulty, Boolean isPremium) {
        this.id = id;
        this.email = email;
        this.questionKey = questionKey;
        this.questionNumber = questionNumber;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
        this.developerDifficulty = developerDifficulty;
        this.studentDifficulty = studentDifficulty;
        this.isPremium = isPremium;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public Character getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(Character correctOption) {
        this.correctOption = correctOption;
    }

    public Double getDeveloperDifficulty() {
        return developerDifficulty;
    }

    public void setDeveloperDifficulty(Double developerDifficulty) {
        this.developerDifficulty = developerDifficulty;
    }

    public Double getStudentDifficulty() {
        return studentDifficulty;
    }

    public void setStudentDifficulty(Double studentDifficulty) {
        this.studentDifficulty = studentDifficulty;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
