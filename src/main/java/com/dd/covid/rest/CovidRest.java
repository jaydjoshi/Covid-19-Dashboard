package com.dd.covid.rest;

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
    private static final String STATES = "states";
    private static final String COUNTRY = "country";

    /**
     * Get Timeseries data from API
     *
     * @return CasesTimeSeries
     */
    @Cacheable(COUNTRY)
    public CasesTimeSeriesWrapper getCountryTimeSeriesData(){
        LOGGER.info("calling API fto get country data");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CasesTimeSeriesWrapper> timeSeriesCasesResponseEntity = null;
        timeSeriesCasesResponseEntity = restTemplate.getForEntity("https://api.covid19india.org/data.json", CasesTimeSeriesWrapper.class);
        LOGGER.debug("HTTP response: "+timeSeriesCasesResponseEntity.toString());

        return timeSeriesCasesResponseEntity.getBody();

    }


    /**
     * Call below API,
     * https://api.covid19india.org/states_daily.json
     * @return
     */
    @Cacheable(STATES)
    public StateTimeSeriesWrapper getStateTimeSeriesData(){
        LOGGER.info("calling API fto get states data");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StateTimeSeriesWrapper> timeSeriesCasesResponseEntity = null;
        timeSeriesCasesResponseEntity = restTemplate.getForEntity("https://api.covid19india.org/states_daily.json", StateTimeSeriesWrapper.class);
        LOGGER.debug("HTTP response: "+timeSeriesCasesResponseEntity.toString());

        return timeSeriesCasesResponseEntity.getBody();

    }

    @Scheduled(fixedRate = ONE_MINUTE)
    @CacheEvict(value = { STATES })
    public void clearStatesCache() {
        LOGGER.info("##### Clearing states cache #####");
    }

    @Scheduled(fixedRate = ONE_MINUTE)
    @CacheEvict(value = { COUNTRY })
    public void clearCountryCache() {
        LOGGER.info("##### Clearing country cache #####");
    }
}
