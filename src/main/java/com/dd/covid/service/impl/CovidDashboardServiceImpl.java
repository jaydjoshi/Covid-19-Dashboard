package com.dd.covid.service.impl;

import com.dd.covid.delegate.CacheDelegate;
import com.dd.covid.model.CasesTimeSeriesWrapper;
import com.dd.covid.model.StateTimeSeriesWrapper;
import com.dd.covid.service.CovidDashboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.List;

@Service
public class CovidDashboardServiceImpl implements CovidDashboardService {

    @Autowired
    CacheDelegate cacheDelegate;


    private static final Logger LOGGER = LoggerFactory.getLogger(CovidDashboardServiceImpl.class);
    private final ZoneId zoneId = ZoneId.systemDefault();


    /**
     *
     * @return CasesTimeSeriesWrapper
     */
    public CasesTimeSeriesWrapper getCountryTimeSeriesData(){

        CasesTimeSeriesWrapper casesTimeSeriesWrapper = cacheDelegate.getCountryTimeSeriesData();
        casesTimeSeriesWrapper.getCasesTimeSeriesList().stream().forEach(a -> a.setDateInEpoch(a.getDate().atStartOfDay(zoneId).toEpochSecond()));
        casesTimeSeriesWrapper.getVacinationDetailList().stream().forEach(a -> a.setTestedAsOfDateInEpoch(a.getTestedAsOf() == null ? 0l : a.getTestedAsOf().atStartOfDay(zoneId).toEpochSecond()));

        return casesTimeSeriesWrapper;
    }


    /**
     *
     * @return StateTimeSeriesWrapper
     */
    public StateTimeSeriesWrapper getStateTimeSeriesData(){

        return cacheDelegate.getStateTimeSeriesData();
    }

    @Override
    public List<String> getTypeAheadData() {

        return cacheDelegate.getTypeAheadData();
    }
}
