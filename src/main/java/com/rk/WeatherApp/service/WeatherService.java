package com.rk.WeatherApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.rk.WeatherApp.dto.Root;

public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.base.url}")
    private String apiUrl;

    private RestTemplate restTemplate = new RestTemplate();

    public Root getWeather(String city) {

        String url = apiUrl + "?key=" + apiKey + "&q=" + city;

        Root response = restTemplate.getForObject(url, Root.class);
        return response;
    }
}
