package com.adaptaconsultoria.objects.in;

import com.adaptaconsultoria.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserIn extends TokenIn {
	
	@JsonProperty("user")
	private User user;
	
	@JsonProperty("error")
	private Object object;
}
