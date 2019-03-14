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
	private String documentNo;
	private Integer codeRule;
	private BigDecimal saleAmount;
	private Date localTime = new Date();
	
	// Codigo da conta
	private Long codeAccount;
	
	// Número da conta
	private String accountNo;
	
	// Documento
	private String taxid;
	
	// Telefone
	private String phone; 
}