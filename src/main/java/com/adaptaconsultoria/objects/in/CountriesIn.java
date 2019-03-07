package com.adaptaconsultoria.objects.in;

import java.util.List;

import com.adaptaconsultoria.models.Country;
import com.adaptaconsultoria.models.Token;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountriesIn extends Token {
	@JsonProperty("countries")
	private List<Country> countries;
}
