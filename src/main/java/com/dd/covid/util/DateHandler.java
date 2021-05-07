package com.dd.covid.util;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler extends JsonDeserializer<Date> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateHandler.class);

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = p.getText();
        try {
            if(date != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                return sdf.parse(date);
            }
            return null;
        } catch (Exception e) {
            LOGGER.error("Error occured in deserialize of DateHandler for date: "+ date);
            return null;
        }

    }
}
