package com.dd.covid.controller;

import com.dd.covid.exception.CountryNotSupportedException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.http.HttpServletResponse;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
public class CovidDashboardControllerTest {

    @Autowired
    private CovidDashboardController covidDashboardController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() throws Exception {
        assertThat(covidDashboardController).isNotNull();
        assertThat(mockMvc).isNotNull();
    }

    @Test
    void testCountryData() throws Exception{
        //401 expected
        this.mockMvc.perform(get("/api/covid/India"))
                .andExpect(status().is(401));
    }

    @Test
    void testInvalidCountryData() throws Exception{
        //401 expected
        this.mockMvc.perform(get("/api/covid/usa"))
                .andExpect(status().is(401));
    }

    @Test
    void testAuthCountryData() throws Exception{
        String jsonRequest = "{\n" +
                "\t\"username\": \"user\",\n" +
                "\t\"password\": \"12345678\"\n" +
                "}";
        MvcResult result  = this.mockMvc.perform(post("/api/auth/signin")
                .contentType("application/json")
                .content(jsonRequest))
                .andReturn();

        String response = result.getResponse().getContentAsString();

        String accessToken = getAccessToken(response);

        //200 expected
        this.mockMvc.perform(get("/api/covid/India")
                .header("Authorization", "Bearer "+accessToken)
                .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }

    @Test()
    void testAuthInvalidCountryData() throws Exception{
        String jsonRequest = "{\n" +
                "\t\"username\": \"user\",\n" +
                "\t\"password\": \"12345678\"\n" +
                "}";
        MvcResult result  = this.mockMvc.perform(post("/api/auth/signin")
                .contentType("application/json")
                .content(jsonRequest))
                .andReturn();

        String response = result.getResponse().getContentAsString();

        String accessToken = getAccessToken(response);

        Assertions.assertThrows(Exception.class, () -> this.mockMvc.perform(get("/api/covid/usa")
                .header("Authorization", "Bearer "+accessToken)
                .header("Content-Type", "application/json"))
                .andExpect(status().is(500)));
    }


    private String getAccessToken(String response) {
        int index = response.indexOf("accessToken")+14;
        String accessToken = response.substring(index, response.indexOf("\"", index));
        return accessToken;
    }
}
