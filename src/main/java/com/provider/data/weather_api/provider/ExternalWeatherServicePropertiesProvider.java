package com.provider.data.weather_api.provider;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weather.external.service")
public class ExternalWeatherServicePropertiesProvider {

    private String baseURL;
    private String current;
    private String apikey;

    public ExternalWeatherServicePropertiesProvider() {

    }

    public ExternalWeatherServicePropertiesProvider(String baseURL, String current, String apikey) {
        this.baseURL = baseURL;
        this.current = current;
        this.apikey = apikey;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
