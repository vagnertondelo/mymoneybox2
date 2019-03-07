package com.adaptaconsultoria.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.adaptaconsultoria.objects.in.CountriesIn;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private CbcService cbcService;
	private static final Logger log = LoggerFactory.getLogger(LocationServiceImpl.class);
	private static final String path = "localization";
	
	@Override
	public Object getLocationByCompany() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			MultiValueMap<String, String> map = cbcService.getBasicPublicServiceRequest();
			ResponseEntity<CountriesIn> obj = restTemplate.exchange(cbcService.getGetRequest(path, map), HttpMethod.GET, cbcService.requestHeaders(), CountriesIn.class);
			Optional<Object> userOp = Optional.of(obj.getBody());
			return userOp.get();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
