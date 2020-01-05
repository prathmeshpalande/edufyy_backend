package com.edufyy.backend.question.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TeacherSection {

    @Id
    @GeneratedValue
    private long id;

    private String sectionKey;
    private String teacherEmail;

    public TeacherSection() {
    }

    public TeacherSection(long id, String sectionKey, String teacherEmail) {
        this.id = id;
        this.sectionKey = sectionKey;
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

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }
}
