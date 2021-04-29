package com.dd.covid.controller;

import com.dd.covid.exception.CountryNotSupportedException;
import com.dd.covid.model.CasesTimeSeriesWrapper;
import com.dd.covid.model.StateTimeSeriesWrapper;
import com.dd.covid.service.CovidDashboardService;
import com.dd.covid.validator.CovidDashboardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
    @GetMapping("/covid/{country}")
    public CasesTimeSeriesWrapper getCountryTimeSeriesData(@PathVariable(name = "country") String country) throws CountryNotSupportedException {
        covidDashboardValidator.validate(country);
        return covidDashboardService.getCountryTimeSeriesData();
    }

    /**
     *
     * @param country
     * @param state
     * @return
     * @throws CountryNotSupportedException
     */
    @GetMapping("/covid/{country}/{state}")
    public StateTimeSeriesWrapper getStateTimeSeriesData(@PathVariable(name = "country") String country, @PathVariable(name = "state") String state) throws CountryNotSupportedException {
        covidDashboardValidator.validate(country, state);
        return covidDashboardService.getStateTimeSeriesData();
    }
}
