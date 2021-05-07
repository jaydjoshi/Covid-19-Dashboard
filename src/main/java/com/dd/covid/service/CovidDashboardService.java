package com.dd.covid.service;

import com.dd.covid.model.CasesTimeSeriesWrapper;
import com.dd.covid.model.StateTimeSeriesWrapper;

import java.util.List;

public interface CovidDashboardService {
    CasesTimeSeriesWrapper getCountryTimeSeriesData();
    StateTimeSeriesWrapper getStateTimeSeriesData();
    List<String> getTypeAheadData();

}
