package com.adaptaconsultoria.objects.in;

import com.adaptaconsultoria.models.Partner;
import com.adaptaconsultoria.models.Token;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper=true)
public class PartnerIn extends Token {
	
	@JsonProperty("partner")
	private Partner partner;
	
	@JsonProperty("error")
	private Object object;
}
