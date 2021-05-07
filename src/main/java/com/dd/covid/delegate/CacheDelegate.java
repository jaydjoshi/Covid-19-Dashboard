package com.dd.covid.delegate;

import com.dd.covid.model.CasesTimeSeriesWrapper;
import com.dd.covid.model.StateTimeSeriesWrapper;
import com.dd.covid.model.jpa.Country;
import com.dd.covid.model.jpa.State;
import com.dd.covid.repository.CountryRepository;
import com.dd.covid.repository.StateRepository;
import com.dd.covid.rest.CovidRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static javax.management.timer.Timer.*;

@Component
public class CacheDelegate implements Delegate{

    @Autowired
    CovidRest covidRest;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private StateRepository stateRepository;

    private static final String STATES = "states";
    private static final String COUNTRY = "country";
    private static final String TYPE_AHEAD = "typeAhead";

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheDelegate.class);

    @Cacheable(COUNTRY)
    public CasesTimeSeriesWrapper getCountryTimeSeriesData(){
        LOGGER.info("IMP: Adding country data cache");
        return covidRest.getCountryTimeSeriesData();
    }

    @Cacheable(STATES)
    public StateTimeSeriesWrapper getStateTimeSeriesData(){
        LOGGER.info("IMP: Adding states data cache");
        return covidRest.getStateTimeSeriesData();
    }

    @Cacheable(TYPE_AHEAD)
    public List<String> getTypeAheadData() {
        LOGGER.info("IMP: Adding typeAhead data cache");
        List<Country> countries = (List<Country>) countryRepository.findAll();
        List<State> states = (List<State>) stateRepository.findAll();

        List<String> result = new ArrayList<>();

        countries.forEach(c -> result.add(c.getCountryName()));
        states.forEach(s -> result.add(s.getStateName()));

        return result;

    }

    @Scheduled(fixedRate = ONE_HOUR)
    @CacheEvict(value = { STATES })
    public void clearStatesCache() {
        LOGGER.info("----- IMP: Clearing states cache ----- ");
    }

    @Scheduled(fixedRate = ONE_HOUR)
    @CacheEvict(value = { COUNTRY })
    public void clearCountryCache() {
        LOGGER.info("----- IMP: Clearing country cache ----- ");
    }




}
