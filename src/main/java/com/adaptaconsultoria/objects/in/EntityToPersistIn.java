package com.adaptaconsultoria.objects.in;

import java.util.List;

import com.adaptaconsultoria.models.EntityToPersist;
import com.adaptaconsultoria.models.Token;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper=true)
public class EntityToPersistIn extends Token {
	
	@JsonProperty("entities")
	private List<EntityToPersist> entities;
	
	@JsonProperty("error")
	private Object object;
}
