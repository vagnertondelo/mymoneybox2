package com.adaptaconsultoria.models;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sale extends Token {
	private String documentNo;
	private Integer codeRule;
	private BigDecimal saleAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date localTime = new Date();

	// Codigo da conta
	private Long codeAccount;

	// Número da conta
	private String accountNo;

	// Documento
	private String taxid;

	// Telefone
	private String phone;

	private String saleCurrency;
	private BigDecimal saleCashback;
	private String countryIsoCode;
	private String currency;
	private BigDecimal cashback;
}
