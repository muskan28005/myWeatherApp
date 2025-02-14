package com.weatherapp.myweatherapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CityInfo {

    @JsonProperty("address")
    private String address;

    @JsonProperty("description")
    private String description;

    @JsonProperty("currentConditions")
    public CurrentConditions currentConditions;

    @JsonProperty("days")
    private List<Days> days;

    // Getter methods
    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public CurrentConditions getCurrentConditions() {
        return currentConditions;
    }

    public List<Days> getDays() {
        return days;
    }

    // Nested class for current conditions
    public static class CurrentConditions {

        @JsonProperty("temp")
        public String currentTemperature;

        @JsonProperty("sunrise")
        public String sunrise;

        @JsonProperty("sunset")
        public String sunset;

        @JsonProperty("feelslike")
        public String feelslike;

        @JsonProperty("humidity")
        public String humidity;

        @JsonProperty("conditions")
        public String conditions;

        public CurrentConditions() {
        }

        // Getter methods
        public String getCurrentTemperature() {
            return currentTemperature;
        }

        public String getSunrise() {
            return sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public String getFeelslike() {
            return feelslike;
        }

        public String getHumidity() {
            return humidity;
        }

        public String getConditions() {
            return conditions;
        }
    }

    // Nested class for day-by-day weather info
    public static class Days {

        @JsonProperty("datetime")
        private String date;

        @JsonProperty("temp")
        private String currentTemperature;

        @JsonProperty("tempmax")
        private String maxTemperature;

        @JsonProperty("tempmin")
        private String minTemperature;

        @JsonProperty("conditions")
        private String conditions;

        @JsonProperty("description")
        private String description;

        public Days() {
        }

        // Getter methods
        public String getDate() {
            return date;
        }

        public String getCurrentTemperature() {
            return currentTemperature;
        }

        public String getMaxTemperature() {
            return maxTemperature;
        }

        public String getMinTemperature() {
            return minTemperature;
        }

        public String getConditions() {
            return conditions;
        }

        public String getDescription() {
            return description;
        }
    }
}
