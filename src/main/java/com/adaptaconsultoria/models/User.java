package com.adaptaconsultoria.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	private String name;
	private String email;
	private String login;
	private String company;
	private Boolean status;
	private String gender;
	private String cellphone;
}