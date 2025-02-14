package com.weatherapp.myweatherapp.service;

import com.weatherapp.myweatherapp.model.CityInfo;
import com.weatherapp.myweatherapp.repository.VisualcrossingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;


import com.weatherapp.myweatherapp.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MyweatherappApplication.class)
public class WeatherServiceTest {

    @MockBean
    private VisualcrossingRepository weatherRepo;

    @Autowired
    private WeatherService weatherService;

    @Test
    void testCompareDaylight() {
        CityInfo city1 = new CityInfo();
        city1.currentConditions = new CityInfo.CurrentConditions();
        city1.currentConditions.sunrise = "06:00";
        city1.currentConditions.sunset = "18:00"; // 12 hours

        CityInfo city2 = new CityInfo();
        city2.currentConditions = new CityInfo.CurrentConditions();
        city2.currentConditions.sunrise = "07:00";
        city2.currentConditions.sunset = "17:00"; // 10 hours

        when(weatherRepo.getByCity("London")).thenReturn(city1);
        when(weatherRepo.getByCity("Paris")).thenReturn(city2);

        String result = weatherService.compareDaylight("London", "Paris");
        assertEquals("London has a longer daylight duration.", result);
    }

    @Test
    void testCheckRain() {
        CityInfo city1 = new CityInfo();
        city1.currentConditions = new CityInfo.CurrentConditions();
        city1.currentConditions.conditions = "Rain";

        CityInfo city2 = new CityInfo();
        city2.currentConditions = new CityInfo.CurrentConditions();
        city2.currentConditions.conditions = "Clear";

        when(weatherRepo.getByCity("New York")).thenReturn(city1);
        when(weatherRepo.getByCity("Los Angeles")).thenReturn(city2);

        String result = weatherService.checkRain("New York", "Los Angeles");
        assertEquals("It is raining in New York.", result);
    }
}
