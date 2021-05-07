package com.dd.covid.rest;

import com.dd.covid.aop.annotation.LogExecutionTime;
import com.dd.covid.model.CasesTimeSeriesWrapper;
import com.dd.covid.model.StateTimeSeriesWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static javax.management.timer.Timer.ONE_DAY;
import static javax.management.timer.Timer.ONE_MINUTE;

@Component
public class CovidRest {


    private static final Logger LOGGER = LoggerFactory.getLogger(CovidRest.class);


    /**
     * Get Timeseries data from API
     *
     * @return CasesTimeSeriesWrapper
     */

    @LogExecutionTime
    public CasesTimeSeriesWrapper getCountryTimeSeriesData(){
        LOGGER.info("calling API to get country data");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CasesTimeSeriesWrapper> timeSeriesCasesResponseEntity = null;
        timeSeriesCasesResponseEntity = restTemplate.getForEntity("https://api.covid19india.org/data.json", CasesTimeSeriesWrapper.class);
        LOGGER.debug("HTTP response: "+timeSeriesCasesResponseEntity.toString());

        return timeSeriesCasesResponseEntity.getBody();

    }


    /**
     * Call below API,
     * https://api.covid19india.org/states_daily.json
     * @return StateTimeSeriesWrapper
     */
    @LogExecutionTime
    public StateTimeSeriesWrapper getStateTimeSeriesData(){
        LOGGER.info("calling API to get states data");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StateTimeSeriesWrapper> timeSeriesCasesResponseEntity = null;
        timeSeriesCasesResponseEntity = restTemplate.getForEntity("https://api.covid19india.org/states_daily.json", StateTimeSeriesWrapper.class);
        LOGGER.debug("HTTP response: "+timeSeriesCasesResponseEntity.toString());

        return timeSeriesCasesResponseEntity.getBody();

    }


}
