package com.adaptaconsultoria.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Accredited extends Token {
	private String doLogin;
	private String countryIsoCode;
	private String firstname;
	private String lastname;
	private String name;
	private String login;
	private String password;
	private String email;
	private String phone;
	private String address;
	private String addressCountryIsoCode;
	private String addressRegionCode;
	private String addressCityCode;
	private String addressDistrict;
	private String addressZipcode;
	private String codeCategory;
	private List<Rule> rules;
}
