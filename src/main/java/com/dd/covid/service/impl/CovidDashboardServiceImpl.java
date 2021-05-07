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

import java.time.ZoneId;
import java.time.ZoneOffset;

@Service
public class CovidDashboardServiceImpl implements CovidDashboardService {

    @Autowired
    CacheDelegate cacheDelegate;


    private static final Logger LOGGER = LoggerFactory.getLogger(CovidDashboardServiceImpl.class);
    private final ZoneId zoneId = ZoneId.systemDefault();


    public CasesTimeSeriesWrapper getCountryTimeSeriesData(){

        CasesTimeSeriesWrapper casesTimeSeriesWrapper = cacheDelegate.getCountryTimeSeriesData();
        casesTimeSeriesWrapper.getCasesTimeSeriesList().stream().forEach(a -> a.setDateInEpoch(a.getDate().atStartOfDay(zoneId).toEpochSecond()));

        return casesTimeSeriesWrapper;
    }



    public StateTimeSeriesWrapper getStateTimeSeriesData(){

        return cacheDelegate.getStateTimeSeriesData();
    }
}
