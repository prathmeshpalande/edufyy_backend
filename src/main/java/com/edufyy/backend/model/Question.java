package com.edufyy.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private long id;

    private String subject;
    private String chapter;
    private String topic;
    private String subTopic;
    private Integer questionNumber;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private Character correctOption;
    private Integer developerDifficulty;
    private Integer studentDiffuculty;
    private Boolean isPremium;

    public Question() {
    }

    public Question(long id, String subject, String chapter, String topic, String subTopic, Integer questionNumber, String question, String optionA, String optionB, String optionC, String optionD, Character correctOption, Integer developerDifficulty, Integer studentDiffuculty, Boolean isPremium) {
        this.id = id;
        this.subject = subject;
        this.chapter = chapter;
        this.topic = topic;
        this.subTopic = subTopic;
        this.questionNumber = questionNumber;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
        this.developerDifficulty = developerDifficulty;
        this.studentDiffuculty = studentDiffuculty;
        this.isPremium = isPremium;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(String subTopic) {
        this.subTopic = subTopic;
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

    public Integer getDeveloperDifficulty() {
        return developerDifficulty;
    }

    public void setDeveloperDifficulty(Integer developerDifficulty) {
        this.developerDifficulty = developerDifficulty;
    }

    public Integer getStudentDiffuculty() {
        return studentDiffuculty;
    }

    public void setStudentDiffuculty(Integer studentDiffuculty) {
        this.studentDiffuculty = studentDiffuculty;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }
}
