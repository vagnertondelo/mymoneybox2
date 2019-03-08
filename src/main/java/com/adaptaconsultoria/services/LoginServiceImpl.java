package com.adaptaconsultoria.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.adaptaconsultoria.models.User;
import com.adaptaconsultoria.objects.in.UserIn;

import net.minidev.json.JSONObject;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CbcService cbcService;
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	private static final String path = "auth";

	@Override
	public User login(String username, String password) {
		JSONObject params = cbcService.getApplicationCredentials();
		UserIn userIn = new UserIn();
		
		try {
			params.put("userName", username);
			params.put("userPassword", password);
			RestTemplate restTemplate = new RestTemplate();
			
			ResponseEntity<UserIn> obj = restTemplate.exchange(cbcService.append(path), HttpMethod.POST, cbcService.getPostRequestHeaders(params), UserIn.class);
//			ResponseEntity<Object> r = restTemplate.exchange("http://localhost:8082/cbc/api/account", HttpMethod.POST, entity, Object.class);
			Optional<User> userOp = Optional.of(obj.getBody().getUser());
			return userOp.get();
		} catch (Exception e) {
			log.error(userIn.getObject().toString());
			log.error(e.getMessage());
		}
		return null;
	}

}
