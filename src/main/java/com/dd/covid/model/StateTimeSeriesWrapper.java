package com.dd.covid.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class StateTimeSeriesWrapper {

    @JsonProperty("states_daily")
    private List<Map<String, String>> stateMap ;

    public List<Map<String, String>> getStateMap() {
        return stateMap;
    }

    public void setStateMap(List<Map<String, String>> stateMap) {
        this.stateMap = stateMap;
    }

    @Override
    public String toString() {
        return "StateTimeSeriesWrapper{" +
                "stateMap=" + stateMap +
                '}';
    }
}
