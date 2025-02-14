package com.weatherapp.myweatherapp.service;

import com.weatherapp.myweatherapp.model.CityInfo;
import com.weatherapp.myweatherapp.repository.VisualcrossingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.Duration;

@Service
public class WeatherService {

    @Autowired
    private VisualcrossingRepository weatherRepo;

    public CityInfo forecastByCity(String city) {
        return weatherRepo.getByCity(city);
    }

    public String compareDaylight(String city1, String city2) {
        CityInfo cityInfo1 = weatherRepo.getByCity(city1);
        CityInfo cityInfo2 = weatherRepo.getByCity(city2);

        if (cityInfo1 == null || cityInfo2 == null) {
            return "Error: Could not fetch weather data for one or both cities.";
        }

        // Extract sunrise and sunset times
        LocalTime sunrise1 = LocalTime.parse(cityInfo1.getCurrentConditions().getSunrise());
        LocalTime sunset1 = LocalTime.parse(cityInfo1.getCurrentConditions().getSunset());
        long daylight1 = Duration.between(sunrise1, sunset1).toHours();

        LocalTime sunrise2 = LocalTime.parse(cityInfo2.getCurrentConditions().getSunrise());
        LocalTime sunset2 = LocalTime.parse(cityInfo2.getCurrentConditions().getSunset());
        long daylight2 = Duration.between(sunrise2, sunset2).toHours();

        if (daylight1 > daylight2) {
            return city1 + " has a longer daylight duration.";
        } else if (daylight2 > daylight1) {
            return city2 + " has a longer daylight duration.";
        } else {
            return "Both cities have the same daylight duration.";
        }
    }

    public String checkRain(String city1, String city2) {
        CityInfo cityInfo1 = weatherRepo.getByCity(city1);
        CityInfo cityInfo2 = weatherRepo.getByCity(city2);

        if (cityInfo1 == null || cityInfo2 == null) {
            return "Error: Could not fetch weather data for one or both cities.";
        }

        boolean isRaining1 = cityInfo1.getCurrentConditions().getConditions().toLowerCase().contains("rain");
        boolean isRaining2 = cityInfo2.getCurrentConditions().getConditions().toLowerCase().contains("rain");

        if (isRaining1 && isRaining2) {
            return "It is raining in both " + city1 + " and " + city2 + ".";
        } else if (isRaining1) {
            return "It is raining in " + city1 + ".";
        } else if (isRaining2) {
            return "It is raining in " + city2 + ".";
        } else {
            return "Neither city is experiencing rain at the moment.";
        }
    }
}
