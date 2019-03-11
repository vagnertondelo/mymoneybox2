package com.adaptaconsultoria.objects.in;

import com.adaptaconsultoria.models.Token;
import com.adaptaconsultoria.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper=true)
public class UserIn extends Token {
	
	@JsonProperty("user")
	private User user;
	
	@JsonProperty("error")
	private Object object;
}
