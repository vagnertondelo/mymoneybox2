package com.adaptaconsultoria.models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EntityToPersist {
	private String code;
	private Entity entity;
	private Integer entityCode;
	private BigDecimal pcEntity;
}
