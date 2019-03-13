package com.adaptaconsultoria.objects.in;

import java.util.List;

import com.adaptaconsultoria.models.Accredited;
import com.adaptaconsultoria.models.Token;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccreditedIn extends Token {
	@JsonProperty("partners")
	private List<Accredited> accrediteds;
}
