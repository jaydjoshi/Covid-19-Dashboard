package com.dd.covid.service;

import com.dd.covid.model.CasesTimeSeriesWrapper;
import com.dd.covid.model.StateTimeSeriesWrapper;

public interface CovidDashboardService {
    public CasesTimeSeriesWrapper getCountryTimeSeriesData();
    public StateTimeSeriesWrapper getStateTimeSeriesData();
}
