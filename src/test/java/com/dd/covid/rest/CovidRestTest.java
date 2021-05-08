package com.dd.covid.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
public class CovidRestTest {

    @Autowired
    private CovidRest covidRest;

    @Test
    void testGetCountryData(){
        assertNotNull(covidRest.getCountryTimeSeriesData());
    }
}
