package com.adaptaconsultoria.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.adaptaconsultoria.objects.in.CountriesIn;

@Service
public class CountryServiceImpl implements CountryService {
	
	private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);
	private static final String path = "localization";

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private JsonService jsonService;

	@SuppressWarnings("unused")
	@Override
	public Object getLocationByCompany() {
		try {
			MultiValueMap<String, String> map = null;
			RestTemplate restTemplate = new RestTemplate();
			Object o = requestService.getRequest(path, true, map);
			
			CountriesIn objOp = (CountriesIn) jsonService.objToObj(o, new CountriesIn());
			return objOp.getCountries();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
