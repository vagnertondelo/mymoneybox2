package com.adaptaconsultoria.objects.in;

import java.util.List;

import com.adaptaconsultoria.models.Sale;
import com.adaptaconsultoria.models.Token;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper=true)
public class SaleIn extends Token {
	@JsonProperty("sales")
	private List<Sale> sales;
}
