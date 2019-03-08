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

import com.adaptaconsultoria.models.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CbcService cbcService;
	private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);
	private static final String isLoginPath = "user/login";
	private static final String isEmailPath = "user/email";
	
	@Override
	public Object save(User user) {

		return null;
	}

	@Override
	public Boolean isLogin(String login) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			MultiValueMap<String, String> map = cbcService.getBasicPublicServiceRequest();
			
//			map.add("token", cbcService.requestToken().getToken());
//			map.add("ipAddress", cbcService.getIpAdress());
			
			map.add("login", login);
			
			ResponseEntity<Boolean> obj = restTemplate.exchange(cbcService.getGetRequest(isLoginPath, map), HttpMethod.GET,
					cbcService.requestHeaders(), Boolean.class);
			
			Optional<Boolean> userOp = Optional.of(obj.getBody());
			return userOp.get();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

	@Override
	public Boolean isEmail(String email) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			MultiValueMap<String, String> map = cbcService.getBasicPublicServiceRequest();
//			map.add("token", cbcService.requestToken().getToken());
//			map.add("ipAddress", cbcService.getIpAdress());
			map.add("email", email);
			
			ResponseEntity<Boolean> obj = restTemplate.exchange(cbcService.getGetRequest(isEmailPath, map), HttpMethod.GET,
					cbcService.requestHeaders(), Boolean.class);
			Optional<Boolean> userOp = Optional.of(obj.getBody());
			return userOp.get();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}
}
