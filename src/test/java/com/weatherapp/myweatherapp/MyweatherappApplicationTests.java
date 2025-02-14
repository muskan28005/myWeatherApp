package com.weatherapp.myweatherapp;

import com.weatherapp.myweatherapp.service.WeatherService;
import com.weatherapp.myweatherapp.controller.WeatherController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyweatherappApplicationTests {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherController weatherController;

    @Test
    void contextLoads() {
        // Test if the application context loads successfully
        assertNotNull(weatherService, "WeatherService should be loaded");
        assertNotNull(weatherController, "WeatherController should be loaded");
    }
}
