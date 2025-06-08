package com.provider.data.weather_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.provider.data.weather_api.dto.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.provider.data.weather_api.provider.ExternalWeatherServicePropertiesProvider;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Autowired
    private ExternalWeatherServicePropertiesProvider externalWeatherServicePropertiesProvider;

    public WeatherService() {
        this.restTemplate = new RestTemplate();
    }

    public WeatherResponse getCurrentWeatherForInputLocation(String location) {
        String baseURL = externalWeatherServicePropertiesProvider.getBaseURL();
        String current = externalWeatherServicePropertiesProvider.getCurrent();
        String apiKey = externalWeatherServicePropertiesProvider.getApikey();
        String url = baseURL + current + "?key=" + apiKey + "&q=" + location;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("Raw JSON response: " + response.getBody());
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = objectMapper.readValue(response.getBody(), WeatherResponse.class);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return weatherResponse;
    }
}
