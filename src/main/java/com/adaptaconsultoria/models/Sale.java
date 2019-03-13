package com.adaptaconsultoria.models;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sale extends Token {
	private String documentno;
	private Integer codeRule;
	private BigDecimal saleAmount;
	private Date localTime = new Date();
	private String codeAccount;
	private Long accountNo;
	private String taxid;
	private String phone; 
}