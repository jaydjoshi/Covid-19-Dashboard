package com.dd.covid.rest;

import com.dd.covid.model.CasesTimeSeriesWrapper;
import com.dd.covid.model.StateTimeSeriesWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CovidRest {


    private static final Logger LOGGER = LoggerFactory.getLogger(CovidRest.class);

    /**
     * Get Timeseries data from API
     *
     * @return CasesTimeSeries
     */
    public CasesTimeSeriesWrapper getCountryTimeSeriesData(){
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
    public StateTimeSeriesWrapper getStateTimeSeriesData(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StateTimeSeriesWrapper> timeSeriesCasesResponseEntity = null;
        timeSeriesCasesResponseEntity = restTemplate.getForEntity("https://api.covid19india.org/states_daily.json", StateTimeSeriesWrapper.class);
        LOGGER.debug("HTTP response: "+timeSeriesCasesResponseEntity.toString());

        return timeSeriesCasesResponseEntity.getBody();

    }
}
