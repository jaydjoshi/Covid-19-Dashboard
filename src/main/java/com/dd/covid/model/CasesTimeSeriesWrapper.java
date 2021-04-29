package com.dd.covid.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

public class CasesTimeSeriesWrapper {
    @JsonProperty("cases_time_series")
    List<CasesTimeSeries> casesTimeSeriesList;
    @JsonProperty("statewise")
    List<StateWiseSummary> stateWiseSummaryList;

    public List<CasesTimeSeries> getCasesTimeSeriesList() {
        return casesTimeSeriesList;
    }

    public void setCasesTimeSeriesList(List<CasesTimeSeries> casesTimeSeriesList) {
        this.casesTimeSeriesList = casesTimeSeriesList;
    }

    public List<StateWiseSummary> getStateWiseSummaryList() {
        return stateWiseSummaryList;
    }

    public void setStateWiseSummaryList(List<StateWiseSummary> stateWiseSummaryList) {
        this.stateWiseSummaryList = stateWiseSummaryList;
    }

    @Override
    public String toString() {
        return "CasesTimeSeriesWrapper{" +
                "casesTimeSeriesList=" + casesTimeSeriesList +
                ", stateWiseSummaryList=" + stateWiseSummaryList +
                '}';
    }
}

