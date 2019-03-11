package com.adaptaconsultoria.services;

import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.adaptaconsultoria.models.User;
import com.adaptaconsultoria.objects.in.ObjectIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CbcService cbcService;

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	private static final String isLoginPath = "user/login";
	private static final String isEmailPath = "user/email";
	private static final String account = "account";

	@Override
	public Object save(User user) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Object> obj = restTemplate.exchange(cbcService.append(account), HttpMethod.POST,
					cbcService.getPostRequestHeaders( objToJson(user) ), Object.class);
			
			Optional<Object> object = Optional.of(obj.getBody());
			return object.get();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;

	}
	
	public String objToJson(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Object isLogin(String login, HttpSession session) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			MultiValueMap<String, String> map = cbcService.getBasicPublicServiceRequest();

			map.add("login", login);
			ResponseEntity<ObjectIn> obj = restTemplate.exchange(cbcService.getGetRequest(isLoginPath, map),
					HttpMethod.GET, cbcService.requestHeaders(), ObjectIn.class);

			Optional<ObjectIn> isLogin = Optional.of(obj.getBody());
			return isLogin;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Object isEmail(String email, HttpSession session) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			MultiValueMap<String, String> map = cbcService.getBasicPublicServiceRequest();
			map.add("email", email);

			ResponseEntity<ObjectIn> obj = restTemplate.exchange(cbcService.getGetRequest(isEmailPath, map),
					HttpMethod.GET, cbcService.requestHeaders(), ObjectIn.class);
			Optional<ObjectIn> isEmail = Optional.of(obj.getBody());
			return isEmail;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object saveAndLogin(User obj, HttpServletRequest request) {
		Map<Object, Object> map = (Map<Object, Object>) save(obj);
		Boolean isRegistered = (Boolean) map.get("hasError");
		if(!isRegistered) {
			if (obj.getLogin() == null || obj.getLogin().isEmpty() || obj.getPassword() == null || obj.getPassword().isEmpty() || false ) {
				return map;
			}
			
			try {
				request.login(obj.getLogin(), obj.getPassword());
			} catch (ServletException e) {
				System.out.println(e.getMessage());
			}
		}
		return map;
	}
}
