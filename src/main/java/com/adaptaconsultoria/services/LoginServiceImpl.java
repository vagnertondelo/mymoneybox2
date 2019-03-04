package com.adaptaconsultoria.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public User login(String username, String password) {
		MultiValueMap<Object, Object> map = cbcService.getAll();
		UserIn userIn = new UserIn();
		try {
			map.add("userName", username);
			map.add("userPassword", password);
			RestTemplate restTemplate = new RestTemplate();
			userIn = restTemplate.postForObject("http://localhost:8080/cbc/api/account", cbcService.getRequest(map),
					UserIn.class);
			Optional<User> obj = Optional.of(userIn.getUser());
			return obj.get();
		} catch (Exception e) {
			log.error(userIn.getObject().toString());
			log.error(e.getMessage());
		}
		return null;
	}

}
