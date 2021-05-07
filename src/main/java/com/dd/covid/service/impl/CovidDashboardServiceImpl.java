package com.dd.covid.service.impl;

import com.dd.covid.aop.annotation.LogExecutionTime;
import com.dd.covid.controller.AuthController;
import com.dd.covid.delegate.CacheDelegate;
import com.dd.covid.model.CasesTimeSeriesWrapper;
import com.dd.covid.model.StateTimeSeriesWrapper;
import com.dd.covid.rest.CovidRest;
import com.dd.covid.service.CovidDashboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CovidDashboardServiceImpl implements CovidDashboardService {

    @Autowired
    CacheDelegate cacheDelegate;

    private static final Logger LOGGER = LoggerFactory.getLogger(CovidDashboardServiceImpl.class);



    public CasesTimeSeriesWrapper getCountryTimeSeriesData(){

        return cacheDelegate.getCountryTimeSeriesData();
    }



    public StateTimeSeriesWrapper getStateTimeSeriesData(){

        return cacheDelegate.getStateTimeSeriesData();
    }
}
