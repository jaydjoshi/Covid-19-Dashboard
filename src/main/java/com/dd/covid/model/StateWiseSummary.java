package com.dd.covid.model;

import com.dd.covid.util.DateHandler;
import com.dd.covid.util.DateTimeHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

public class StateWiseSummary {


    private int active;
    private int confirmed;
    private int deaths;
    @JsonProperty("deltaconfirmed")
    private int deltaConfirmed;
    @JsonProperty("deltadeaths")
    private int deltaDeaths;
    @JsonProperty("deltarecovered")
    private int deltaRecovered;

    @JsonProperty("lastupdatedtime")
    @JsonDeserialize(using = DateTimeHandler.class)
    private LocalDateTime lastUpdatedTime;

    @JsonProperty("migratedother")
    private int migratedOther;
    private int recovered;
    private String state;
    @JsonProperty("statecode")
    private String stateCode;
    @JsonProperty("statenotes")
    private String stateNotes;


    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getDeltaConfirmed() {
        return deltaConfirmed;
    }

    public void setDeltaConfirmed(int deltaConfirmed) {
        this.deltaConfirmed = deltaConfirmed;
    }

    public int getDeltaDeaths() {
        return deltaDeaths;
    }

    public void setDeltaDeaths(int deltaDeaths) {
        this.deltaDeaths = deltaDeaths;
    }

    public int getDeltaRecovered() {
        return deltaRecovered;
    }

    public void setDeltaRecovered(int deltaRecovered) {
        this.deltaRecovered = deltaRecovered;
    }

    public int getMigratedOther() {
        return migratedOther;
    }

    public void setMigratedOther(int migratedOther) {
        this.migratedOther = migratedOther;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public LocalDateTime getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(LocalDateTime lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateNotes() {
        return stateNotes;
    }

    public void setStateNotes(String stateNotes) {
        this.stateNotes = stateNotes;
    }

    @Override
    public String toString() {
        return "StateWiseSummary{" +
                "active='" + active + '\'' +
                ", confirmed='" + confirmed + '\'' +
                ", deaths='" + deaths + '\'' +
                ", deltaConfirmed='" + deltaConfirmed + '\'' +
                ", deltaDeaths='" + deltaDeaths + '\'' +
                ", deltaRecovered='" + deltaRecovered + '\'' +
                ", lastUpdatedTime='" + lastUpdatedTime + '\'' +
                ", migratedOther='" + migratedOther + '\'' +
                ", recovered='" + recovered + '\'' +
                ", state='" + state + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", stateNotes='" + stateNotes + '\'' +
                '}';
    }
}
