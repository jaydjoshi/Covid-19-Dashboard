package com.dd.covid.model;

import java.util.Map;

@Deprecated
public class Timeline {
    private Map<String, Long> cases;
    private Map<String, Long> deaths;
    private Map<String, Long> recovered;

    public Map<String, Long> getCases() {
        return cases;
    }

    public void setCases(Map<String, Long> cases) {
        this.cases = cases;
    }

    public Map<String, Long> getDeaths() {
        return deaths;
    }

    public void setDeaths(Map<String, Long> deaths) {
        this.deaths = deaths;
    }

    public Map<String, Long> getRecovered() {
        return recovered;
    }

    public void setRecovered(Map<String, Long> recovered) {
        this.recovered = recovered;
    }

    @Override
    public String toString() {
        return "Timeline{" +
                "cases=" + cases +
                ", deaths=" + deaths +
                ", recovered=" + recovered +
                '}';
    }
}
