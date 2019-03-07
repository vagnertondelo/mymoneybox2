package com.adaptaconsultoria.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
	
	private String isoCode;
	private String name;
	private String isoLanguage;
	private Integer code;
	private String regionName;
	
	@JsonProperty("regions")
	private List<Region> regions;
}
