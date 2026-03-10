package com.capgemini.java_advance.framework.hibernate_jpa.entity;



import jakarta.persistence.*;

@Entity
public class Biography {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String summary;
    private String birthPlace;
    private String birthDate;

    public int getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        if(summary.isEmpty())
            throw new RuntimeException("Summary cannot be empty");
        this.summary = summary;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        if(birthPlace.isEmpty())
            throw new RuntimeException("Birth place cannot be empty");
        this.birthPlace = birthPlace;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if(birthDate.isEmpty())
            throw new RuntimeException("Birth date cannot be empty");
        this.birthDate = birthDate;
    }
}
