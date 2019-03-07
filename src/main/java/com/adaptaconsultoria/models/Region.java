package com.adaptaconsultoria.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Region {
	
	private String code;
	private String name;
	
	@JsonProperty("cities")
	private List<City> cities;
}
