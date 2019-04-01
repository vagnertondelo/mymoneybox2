package com.adaptaconsultoria.objects.in;

import java.util.List;

import com.adaptaconsultoria.models.Token;
import com.adaptaconsultoria.objects.pojo.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper=true)
public class AccountAutoCompleteIn extends Token {
	
	@JsonProperty("accounts")
	private List<Account> accounts;
	
	@JsonProperty("error")
	private Object object;
}
