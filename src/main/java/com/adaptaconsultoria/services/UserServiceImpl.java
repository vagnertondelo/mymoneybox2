package com.adaptaconsultoria.services;

import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.adaptaconsultoria.models.User;
import com.adaptaconsultoria.objects.in.ObjectIn;
import com.adaptaconsultoria.objects.in.UserIn;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private TokenService tokenService;

	@Autowired
	private JsonService jsonService;

	@Autowired
	private RequestService requestService;
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	private static final String isLoginPath = "user/login";
	private static final String isEmailPath = "user/email";
	private static final String account = "account";

	@Override
	public Object save(User user) {
		try {
			user.setToken(cbcService.requestToken().getToken());
			user.setDoLogin(true);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<UserIn> obj = restTemplate.exchange(cbcService.append(account), HttpMethod.POST,
					cbcService.getPostRequestHeaders( jsonService.objToJsonString(user) ), UserIn.class);

			Optional<UserIn> object = Optional.of(obj.getBody());
			return object.get();

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}


	@Override
	public Object saveNew(User obj, HttpSession session) {
		try {
			obj.setToken(tokenService.getToken());
			return requestService.postRequest(account, obj, session);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Object saveAndLogin(User obj, HttpServletRequest request) {
		UserIn userIn = (UserIn) save(obj);
		Boolean isRegistered = userIn.getHasError();
		String token = userIn.getToken();
		if(!isRegistered) {
			if (obj.getLogin() == null || obj.getLogin().isEmpty() || obj.getPassword() == null || obj.getPassword().isEmpty() || false ) {
				return userIn;
			}
			try {
				request.login(obj.getLogin(), obj.getPassword());
				tokenService.updateToken(token);
			} catch (ServletException e) {
				System.out.println(e.getMessage());
			}
		}
		return userIn;
	}

	@Override
	public Object isLogin(String login, HttpSession session) {
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
				map = cbcService.getBasicPublicServiceRequest();
				isLoggedIn = false;
			}

			map.add("login", login);
			ResponseEntity<ObjectIn> obj = restTemplate.exchange(cbcService.getGetRequest(isLoginPath, map),
					HttpMethod.GET, cbcService.requestHeaders(), ObjectIn.class);
			Optional<ObjectIn> objOp = Optional.of(obj.getBody());
			
			if (isLoggedIn) {
				
				if (objOp.get().getToken().isEmpty()) {
					throw new Exception();
				}
				tokenService.updateToken( objOp.get().getToken() );
			}
			
			System.out.println(userIn.getToken());
			
			return objOp.get();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Object isEmail(String email, HttpSession session) {
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
				map = cbcService.getBasicPublicServiceRequest();
				isLoggedIn = false;
			}
			map.add("email", email);

			ResponseEntity<ObjectIn> obj = restTemplate.exchange(cbcService.getGetRequest(isEmailPath, map),
					HttpMethod.GET, cbcService.requestHeaders(), ObjectIn.class);
			Optional<ObjectIn> objOp = Optional.of(obj.getBody());
			
			if (isLoggedIn) {
				tokenService.updateToken( objOp.get().getToken() );
			}
			System.out.println(userIn.getToken());
			return objOp.get();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
