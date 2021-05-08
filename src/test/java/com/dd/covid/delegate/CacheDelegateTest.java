package com.dd.covid.delegate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
public class CacheDelegateTest {

    @Autowired
    private CacheDelegate cacheDelegate;

    @Autowired
    void testGetCountryData(){
        assertNotNull(cacheDelegate.getCountryTimeSeriesData());
    }
}
