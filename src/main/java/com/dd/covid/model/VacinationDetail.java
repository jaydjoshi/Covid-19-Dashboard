package com.dd.covid.model;

import com.dd.covid.util.DateHandler;
import com.dd.covid.util.LocaleDateHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

public class VacinationDetail {
    @JsonProperty("dailyrtpcrsamplescollectedicmrapplication")
    private String dailyRtpcrSamplesCollected;
    @JsonProperty("samplereportedtoday")
    private String sampleReportedToday;
    @JsonProperty("firstdoseadministered")
    private String firstDoseAdministered;
    @JsonProperty("seconddoseadministered")
    private String seconDoseAdministered;
    @JsonDeserialize(using = LocaleDateHandler.class)
    @JsonProperty("testedasof")
    private LocalDate testedAsOf;
    private long testedAsOfDateInEpoch;

    public String getDailyRtpcrSamplesCollected() {
        return dailyRtpcrSamplesCollected;
    }

    public void setDailyRtpcrSamplesCollected(String dailyRtpcrSamplesCollected) {
        this.dailyRtpcrSamplesCollected = dailyRtpcrSamplesCollected;
    }

    public String getSampleReportedToday() {
        return sampleReportedToday;
    }

    public void setSampleReportedToday(String sampleReportedToday) {
        this.sampleReportedToday = sampleReportedToday;
    }

    public String getFirstDoseAdministered() {
        return firstDoseAdministered;
    }

    public void setFirstDoseAdministered(String firstDoseAdministered) {
        this.firstDoseAdministered = firstDoseAdministered;
    }

    public String getSeconDoseAdministered() {
        return seconDoseAdministered;
    }

    public void setSeconDoseAdministered(String seconDoseAdministered) {
        this.seconDoseAdministered = seconDoseAdministered;
    }

    public LocalDate getTestedAsOf() {
        return testedAsOf;
    }

    public void setTestedAsOf(LocalDate testedAsOf) {
        this.testedAsOf = testedAsOf;
    }

    public long getTestedAsOfDateInEpoch() {
        return testedAsOfDateInEpoch;
    }

    public void setTestedAsOfDateInEpoch(long testedAsOfDateInEpoch) {
        this.testedAsOfDateInEpoch = testedAsOfDateInEpoch;
    }
}
