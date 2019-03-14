package com.adaptaconsultoria.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rule {
	private String code;
	private String description;
	private String currency;
	private String pcCashback;
	private Boolean isactive;
}