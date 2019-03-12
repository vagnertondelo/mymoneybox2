package com.adaptaconsultoria.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.adaptaconsultoria.objects.in.CountriesIn;
import com.adaptaconsultoria.objects.in.UserIn;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CbcService cbcService;
	private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);
	private static final String path = "localization";

	@Autowired
	private TokenService tokenService;

	@SuppressWarnings("unused")
	@Override
	public Object getLocationByCompany() {
		try {
			MultiValueMap<String, String> map = null;
			RestTemplate restTemplate = new RestTemplate();
			UserIn userIn = new UserIn();
			Boolean isLoggedIn = true;

			try {
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				userIn = (UserIn) auth.getPrincipal();
				map = cbcService.getBasicPrivateServiceRequest();
			} catch (Exception e) {
				isLoggedIn = false;
				map = cbcService.getBasicPublicServiceRequest();
			}
			ResponseEntity<CountriesIn> obj = restTemplate.exchange(cbcService.getGetRequest(path, map), HttpMethod.GET,
					cbcService.requestHeaders(), CountriesIn.class);
			Optional<CountriesIn> objOp = Optional.of(obj.getBody());

			if (isLoggedIn) {
				if (objOp.get().getToken().isEmpty()) {
					throw new Exception();
				}
				tokenService.updateToken(objOp.get().getToken());
			}
			return objOp.get();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
