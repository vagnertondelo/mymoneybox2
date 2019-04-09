package com.adaptaconsultoria.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends Token {
	private Boolean doLogin;
	private String countryIsoCode;

	private String firstname;
	private String lastname;
	private String name;
	private String login;
	private String password;
	private String email;
	private String phone;
	private String taxid;

	private String address;
	private String addressCountryIsoCode;
	private String addressRegionCode;
	private String addressCityCode;
	private String addressDistrict;
	private String addressZipcode;
	private String accountNo;
	private String addressNumber;

	private String sponsorAccountNo;

	private String role;

}