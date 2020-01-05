package com.edufyy.backend.question.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class HomeWork {

    @Id
    @GeneratedValue
    private long id;

    private String sectionKey;
    private String questionKey;
    private Date date;

    public HomeWork() {
    }

    public HomeWork(long id, String sectionKey, String questionKey, Date date) {
        this.id = id;
        this.sectionKey = sectionKey;
        this.questionKey = questionKey;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSectionKey() {
        return sectionKey;
    }

    public void setSectionKey(String sectionKey) {
        this.sectionKey = sectionKey;
    }

    public String getQuestionKey() {
        return questionKey;
    }

    public void setQuestionKey(String questionKey) {
        this.questionKey = questionKey;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
