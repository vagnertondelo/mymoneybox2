package com.adaptaconsultoria.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stat {
    private String id;
    private String name;
    private String value;
    private String color;
    private String icon;
}
