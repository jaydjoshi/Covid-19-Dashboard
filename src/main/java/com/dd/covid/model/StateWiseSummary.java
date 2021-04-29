package com.dd.covid.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StateWiseSummary {


    private String active;
    private String confirmed;
    private String deaths;
    @JsonProperty("deltaconfirmed")
    private String deltaConfirmed;
    @JsonProperty("deltadeaths")
    private String deltaDeaths;
    @JsonProperty("deltarecovered")
    private String deltaRecovered;
    @JsonProperty("lastupdatedtime")
    private String lastUpdatedTime;
    @JsonProperty("migratedother")
    private String migratedOther;
    private String recovered;
    private String state;
    @JsonProperty("statecode")
    private String stateCode;
    @JsonProperty("statenotes")
    private String stateNotes;


    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getDeltaConfirmed() {
        return deltaConfirmed;
    }

    public void setDeltaConfirmed(String deltaConfirmed) {
        this.deltaConfirmed = deltaConfirmed;
    }

    public String getDeltaDeaths() {
        return deltaDeaths;
    }

    public void setDeltaDeaths(String deltaDeaths) {
        this.deltaDeaths = deltaDeaths;
    }

    public String getDeltaRecovered() {
        return deltaRecovered;
    }

    public void setDeltaRecovered(String deltaRecovered) {
        this.deltaRecovered = deltaRecovered;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getMigratedOther() {
        return migratedOther;
    }

    public void setMigratedOther(String migratedOther) {
        this.migratedOther = migratedOther;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
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
