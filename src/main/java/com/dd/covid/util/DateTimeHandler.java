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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeHandler extends JsonDeserializer<LocalDateTime> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeHandler.class);

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = p.getText();
        try {
            if(date != null) {
                // Example - 7/5/2021 14:05:09"
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                return LocalDateTime.parse(date, formatter);
            }
            return null;
        } catch (Exception e) {
            LOGGER.error("Error occured in deserialize of DateHandler for date: "+ date);
            return null;
        }

    }
}
