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
import com.adaptaconsultoria.objects.in.UserIn;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CbcService cbcService;
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	private static final String url = "http://localhost:8080/cbc/api/account";

	@Override
	public User login(String username, String password) {
		MultiValueMap<Object, Object> map = cbcService.getAll();
		UserIn userIn = new UserIn();
		try {
			map.add("userName", username);
			map.add("userPassword", password);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<UserIn> obj = restTemplate.exchange(url, HttpMethod.POST, cbcService.getRequest(map), UserIn.class);
			Optional<User> userOp = Optional.of(obj.getBody().getUser());
			return userOp.get();
		} catch (Exception e) {
			log.error(userIn.getObject().toString());
			log.error(e.getMessage());
		}
		return null;
	}

}
