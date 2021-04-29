package com.dd.covid.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CasesTimeSeries {

    @JsonProperty("dailyconfirmed")
    private String dailyConfirmed;
    @JsonProperty("dailydeceased")
    private String dailyDeceased;
    @JsonProperty("dailyrecovered")
    private String dailyRecovered;
    private String date;
    @JsonProperty("totalconfirmed")
    private String totalConfirmed;
    @JsonProperty("totaldeceased")
    private String totalDeceased;
    @JsonProperty("totalrecovered")
    private String totalRecovered;

    public String getDailyConfirmed() {
        return dailyConfirmed;
    }

    public void setDailyConfirmed(String dailyConfirmed) {
        this.dailyConfirmed = dailyConfirmed;
    }

    public String getDailyDeceased() {
        return dailyDeceased;
    }

    public void setDailyDeceased(String dailyDeceased) {
        this.dailyDeceased = dailyDeceased;
    }

    public String getDailyRecovered() {
        return dailyRecovered;
    }

    public void setDailyRecovered(String dailyRecovered) {
        this.dailyRecovered = dailyRecovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public String getTotalDeceased() {
        return totalDeceased;
    }

    public void setTotalDeceased(String totalDeceased) {
        this.totalDeceased = totalDeceased;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
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

