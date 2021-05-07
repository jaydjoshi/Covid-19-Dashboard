package com.dd.covid.model;


import com.dd.covid.util.DateHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

public class CasesTimeSeries {

    @JsonProperty("dailyconfirmed")
    private int dailyConfirmed;
    @JsonProperty("dailydeceased")
    private int dailyDeceased;
    @JsonProperty("dailyrecovered")
    private int dailyRecovered;
    @JsonDeserialize(using = DateHandler.class)
    private LocalDate date;
    private long dateInEpoch;
    @JsonProperty("totalconfirmed")
    private int totalConfirmed;
    @JsonProperty("totaldeceased")
    private int totalDeceased;
    @JsonProperty("totalrecovered")
    private int totalRecovered;

    public int getDailyConfirmed() {
        return dailyConfirmed;
    }

    public void setDailyConfirmed(int dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
    }

    public int getDailyDeceased() {
        return dailyDeceased;
    }

    public void setDailyDeceased(int dailyDeceased) {
        this.dailyDeceased = dailyDeceased;
    }

    public int getDailyRecovered() {
        return dailyRecovered;
    }

    public void setDailyRecovered(int dailyRecovered) {
        this.dailyRecovered = dailyRecovered;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public int getTotalDeceased() {
        return totalDeceased;
    }

    public void setTotalDeceased(int totalDeceased) {
        this.totalDeceased = totalDeceased;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public long getDateInEpoch() {
        return dateInEpoch;
    }

    public void setDateInEpoch(long dateInEpoch) {
        this.dateInEpoch = dateInEpoch;
    }

    @Override
    public String toString() {
        return "CasesTimeSeries{" +
                "dailyConfirmed='" + dailyConfirmed + '\'' +
                ", dailyDeceased='" + dailyDeceased + '\'' +
                ", dailyRecovered='" + dailyRecovered + '\'' +
                ", date='" + date + '\'' +
                ", totalConfirmed='" + totalConfirmed + '\'' +
                ", totalDeceased='" + totalDeceased + '\'' +
                ", totalRecovered='" + totalRecovered + '\'' +
                '}';
    }
}

