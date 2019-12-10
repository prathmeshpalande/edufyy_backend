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
    private String subject;
    private String chapter;
    private String topic;
    private String subTopic;
    private Integer questionNumber;
    private Integer studentDifficulty;
    private Integer surity;
    private Boolean isCorrect;

    public Answer() {
    }

    public Answer(long id, String email, String subject, String chapter, String topic, String subTopic, Integer questionNumber, Integer studentDifficulty, Integer surity, Boolean isCorrect) {
        this.id = id;
        this.email = email;
        this.subject = subject;
        this.chapter = chapter;
        this.topic = topic;
        this.subTopic = subTopic;
        this.questionNumber = questionNumber;
        this.studentDifficulty = studentDifficulty;
        this.surity = surity;
        this.isCorrect = isCorrect;
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

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
