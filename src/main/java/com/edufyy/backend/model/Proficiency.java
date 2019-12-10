package com.edufyy.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Proficiency {

    @Id
    @GeneratedValue
    private long id;

    private String key;
    private Double prificiency;

    public Proficiency() {
    }

    public Proficiency(long id, String key, Double prificiency) {
        this.id = id;
        this.key = key;
        this.prificiency = prificiency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getPrificiency() {
        return prificiency;
    }

    public void setPrificiency(Double prificiency) {
        this.prificiency = prificiency;
    }
}
