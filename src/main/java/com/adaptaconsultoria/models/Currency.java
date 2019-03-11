package com.adaptaconsultoria.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    private String code;
    private String name;
    private String sign;
    private String precision;
    private String icon;
}

