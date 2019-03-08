package com.adaptaconsultoria.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	String token;
	String ipAddress;
	String doLogin;
	
	String countryIsoCode;
	
	String firstname;
	String lastname;
	String name;
	String login;
	String password;
	String email;
	String phone;
	String taxid;
	
	String address;
	String addressCountryIsoCode;
	String addressRegionCode;
	String addressCityCode;
	String addressDistrict;
	String addressZipcode;
	String accountNo;
	
	String sponsorAccountNo;
	
}