package com.dd.covid.service.impl;

import com.dd.covid.model.CasesTimeSeriesWrapper;
import com.dd.covid.model.StateTimeSeriesWrapper;
import com.dd.covid.rest.CovidRest;
import com.dd.covid.service.CovidDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidDashboardServiceImpl implements CovidDashboardService {

    @Autowired
    CovidRest covidRest;

    public CasesTimeSeriesWrapper getCountryTimeSeriesData(){

        return covidRest.getCountryTimeSeriesData();
    }

    public StateTimeSeriesWrapper getStateTimeSeriesData(){
        return covidRest.getStateTimeSeriesData();
    }
}
