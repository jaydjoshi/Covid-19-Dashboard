package com.dd.covid.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class State {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String stateName;

    @Column
    private String shortStateName;

    @Column
    private boolean isValid;

    @Column
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getShortStateName() {
        return shortStateName;
    }

    public void setShortStateName(String shortStateName) {
        this.shortStateName = shortStateName;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
