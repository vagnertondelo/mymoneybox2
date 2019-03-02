package com.adaptaconsultoria.objects.in;

import com.adaptaconsultoria.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserIn {
	private String token;
	private Boolean hasError;
	private String error;
	private User user;
}
