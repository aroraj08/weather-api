package com.provider.data.weather_api.controller;

import com.provider.data.weather_api.dto.WeatherResponse;
import com.provider.data.weather_api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "/current", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<WeatherResponse> getCurrentWeather(@RequestParam String location) {
        WeatherResponse weatherResponse = weatherService.getCurrentWeatherForInputLocation(location);
        return ResponseEntity.ok(weatherResponse);
    }
}
