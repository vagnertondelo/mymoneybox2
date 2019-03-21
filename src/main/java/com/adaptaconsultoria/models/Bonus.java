package com.adaptaconsultoria.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bonus {
	private String code;
	private String name;
	private String description;
}
