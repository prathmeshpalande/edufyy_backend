package com.edufyy.backend.question.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Section {

    @Id
    @GeneratedValue
    private long id;

    private String sectionKey;
    private String studentEmail;
    private String teacherEmail;

    public Section() {
    }

    public Section(long id, String sectionKey, String studentEmail, String teacherEmail) {
        this.id = id;
        this.sectionKey = sectionKey;
        this.studentEmail = studentEmail;
        this.teacherEmail = teacherEmail;
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

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }
}
