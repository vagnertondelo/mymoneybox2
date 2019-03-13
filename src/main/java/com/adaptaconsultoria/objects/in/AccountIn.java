package com.adaptaconsultoria.objects.in;

import com.adaptaconsultoria.models.Account;
import com.adaptaconsultoria.models.Token;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper=true)
public class AccountIn extends Token {
	
	@JsonProperty("account")
	private Account account;
	
	@JsonProperty("error")
	private Object object;
}
