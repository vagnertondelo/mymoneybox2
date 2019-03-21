package com.adaptaconsultoria.models;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CashBack extends Token {
	@JsonProperty("sale")
	private Sale sale;
	
	private String currency;
	private BigDecimal amount; 
	private Boolean isreceipt;
	private String description;
	
	@JsonProperty("bonus")
	private Bonus bonus;
	
    private Date dateSale;
    private Integer level;
    private BigDecimal rate;
}






