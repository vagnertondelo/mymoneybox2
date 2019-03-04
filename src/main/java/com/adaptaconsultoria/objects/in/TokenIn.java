package com.adaptaconsultoria.objects.in;

import lombok.Data;

@Data
public class TokenIn {
	private String token;
	private Boolean hasError;
	private String error;
}
