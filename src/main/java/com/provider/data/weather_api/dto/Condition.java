package com.provider.data.weather_api.dto;

import lombok.Data;

@Data
public class Condition {

    private String text;
    private String icon;
    private int code;
}
