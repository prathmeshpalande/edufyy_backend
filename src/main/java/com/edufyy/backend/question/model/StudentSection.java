package com.edufyy.backend.question.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StudentSection {

    @Id
    @GeneratedValue
    private long id;

    private String sectionKey;
    private String studentEmail;


}