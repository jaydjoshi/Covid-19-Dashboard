package com.dd.covid.validator;

import com.dd.covid.constants.CovidConstants;
import com.dd.covid.exception.CountryNotSupportedException;
import org.springframework.stereotype.Component;

@Component
public class CovidDashboardValidator {

    /**
     * Validate country
     * @param country
     * @return
     */
    public boolean validate(String country) throws CountryNotSupportedException {
        if(CovidConstants.INDIA.equalsIgnoreCase(country)){
            return true;
        }
        throw new CountryNotSupportedException();
    }

    public boolean validate(String country, String state) throws CountryNotSupportedException {
        if(CovidConstants.INDIA.equalsIgnoreCase(country)){
            return true;
        }
        throw new CountryNotSupportedException();
    }
}
