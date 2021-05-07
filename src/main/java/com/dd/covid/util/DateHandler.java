package com.dd.covid.util;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateHandler extends JsonDeserializer<LocalDate> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateHandler.class);

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = p.getText();
        try {
            if(date != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);

                return LocalDate.parse(date, formatter);
            }
            return null;
        } catch (Exception e) {
            LOGGER.error("Error occured in deserialize of DateHandler for date: "+ date);
            return null;
        }

    }
}
