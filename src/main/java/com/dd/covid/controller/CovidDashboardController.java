package com.dd.covid.controller;

import com.dd.covid.aop.annotation.LogExecutionTime;
import com.dd.covid.exception.CountryNotSupportedException;
import com.dd.covid.model.CasesTimeSeriesWrapper;
import com.dd.covid.model.StateTimeSeriesWrapper;
import com.dd.covid.service.CovidDashboardService;
import com.dd.covid.validator.CovidDashboardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/covid")
public class CovidDashboardController {

    @Autowired
    CovidDashboardService covidDashboardService;

    @Autowired
    CovidDashboardValidator covidDashboardValidator;

    /**
     *
     * @param country
     * @return
     * @throws CountryNotSupportedException
     */
    @GetMapping("/{country}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @LogExecutionTime
    public CasesTimeSeriesWrapper getCountryTimeSeriesData(@PathVariable(name = "country") String country) throws CountryNotSupportedException {
        covidDashboardValidator.validate(country);
        return covidDashboardService.getCountryTimeSeriesData();
    }

    /**
     * Note - not used currently, can be used to fetch daily data for states
     * @param country
     * @param state
     * @return
     * @throws CountryNotSupportedException
     */
    @GetMapping("/{country}/states/{state}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @LogExecutionTime
    public StateTimeSeriesWrapper getStateTimeSeriesData(@PathVariable(name = "country") String country, @PathVariable(name = "state") String state) throws CountryNotSupportedException {
        covidDashboardValidator.validate(country, state);
        return covidDashboardService.getStateTimeSeriesData();
    }

    /**
     * This API is not used in UI
     * But can be used of giving a list of valid states and countries to search from typeahead
     * @return
     */
    @GetMapping("/typeahead")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @LogExecutionTime
    public List<String> getTypeAheadData() {
        return covidDashboardService.getTypeAheadData();
    }
}
