package com.adaptaconsultoria.objects.in;

import com.adaptaconsultoria.models.Token;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectIn extends Token {
	
	@JsonProperty("isvalid")
	private Boolean isvalid;
	
	@JsonProperty("error")
	private Object object;

}
