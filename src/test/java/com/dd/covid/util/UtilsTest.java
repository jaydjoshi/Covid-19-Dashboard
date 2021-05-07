package com.dd.covid.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm:ss");

    @Test
    public void testDateDeserialization(){
        String date = "1 March 2020";

        LocalDate localDate = LocalDate.parse(date, formatter);
        assertEquals(localDate.toString(), "2020-03-01");

        date = "13 March 2020";
        localDate = LocalDate.parse(date, formatter);
        assertEquals(localDate.toString(), "2020-03-13");

        date = "31 December 2020";
        localDate = LocalDate.parse(date, formatter);
        assertEquals(localDate.toString(), "2020-12-31");

        date = "01 December 2020";
        localDate = LocalDate.parse(date, formatter);
        assertEquals(localDate.toString(), "2020-12-01");

    }

    @Test
    public void testDateTimeDeserialization(){

        String date = "7/5/2021 14:05:09";
        LocalDateTime localDate = LocalDateTime.parse(date, dateTimeFormatter);
        assertEquals(localDate.toString(), "2021-05-07T14:05:09");

        date = "17/5/2021 14:05:09";
        localDate = LocalDateTime.parse(date, dateTimeFormatter);
        assertEquals(localDate.toString(), "2021-05-17T14:05:09");

        date = "07/05/2021 14:05:09";
        localDate = LocalDateTime.parse(date, dateTimeFormatter);
        assertEquals(localDate.toString(), "2021-05-07T14:05:09");

        date = "17/05/2021 14:05:09";
        localDate = LocalDateTime.parse(date, dateTimeFormatter);
        assertEquals(localDate.toString(), "2021-05-17T14:05:09");

    }

}
