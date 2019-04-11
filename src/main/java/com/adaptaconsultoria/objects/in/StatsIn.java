package com.adaptaconsultoria.objects.in;

import com.adaptaconsultoria.models.Sale;
import com.adaptaconsultoria.models.Stat;
import com.adaptaconsultoria.models.Token;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper=true)
public class StatsIn extends Token {
	@JsonProperty("stats")
	private List<Stat> stats;
}
