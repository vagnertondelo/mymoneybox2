package com.adaptaconsultoria.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Data;

@Data
public class Bean {
	public String name;
	private Map<String, String> properties;
	
	@JsonAnySetter
	public void add(String key, String value) {
		properties.put(key, value);
	}
}