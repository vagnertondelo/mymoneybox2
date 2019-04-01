package com.adaptaconsultoria.objects.pojo;

import com.adaptaconsultoria.models.Token;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account extends Token {
	private String id;
	private String text;
}
