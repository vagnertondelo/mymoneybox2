package com.adaptaconsultoria.models;

import lombok.Data;

@Data
public class Token {
	private String token;
	private Boolean hasError;
	private String error;
	private String ipAddress;
}
