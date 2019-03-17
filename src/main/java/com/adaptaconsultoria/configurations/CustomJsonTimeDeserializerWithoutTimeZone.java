package com.adaptaconsultoria.configurations;

import java.io.IOException;
import java.sql.Time;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@Component
public class CustomJsonTimeDeserializerWithoutTimeZone extends JsonDeserializer<Time> {

	@Override
	public Time deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

}
