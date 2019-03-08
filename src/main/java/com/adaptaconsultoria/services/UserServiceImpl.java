package com.adaptaconsultoria.services;

import java.util.Optional;

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

import net.minidev.json.JSONObject;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CbcService cbcService;

	private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);
	private static final String isLoginPath = "user/login";
	private static final String isEmailPath = "user/email";
	private static final String account = "account";

	@Override
	public Object save(User user) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Object> obj = restTemplate.exchange(cbcService.append(account), HttpMethod.POST,
					cbcService.getPostRequestHeaders(getUserJson(user)), Object.class);
			Optional<Object> object = Optional.of(obj.getBody());
			return object;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;

	}

	public JSONObject getUserJson(User user) {
		JSONObject params = cbcService.getApplicationCredentials();

		try {
			params.put("token", user.getToken());
		} catch (Exception e) {
		}
		
		try {
			params.put("doLogin", user.getDoLogin());
		} catch (Exception e) {
		}

		try {
			params.put("countryIsoCode", user.getCountryIsoCode());
		} catch (Exception e) {
		}
		
		try {
			params.put("firstname", user.getFirstname());
		} catch (Exception e) {
		}
		
		try {
			params.put("lastname", user.getLastname());
		} catch (Exception e) {
		}
		
		try {
			params.put("name", user.getName());
		} catch (Exception e) {
		}

		try {
			params.put("login", user.getLogin());
		} catch (Exception e) {
		}
		
		try {
			params.put("password", user.getPassword());
		} catch (Exception e) {
		}
		
		try {
			params.put("email", user.getEmail());
		} catch (Exception e) {
		}
		
		try {
			params.put("phone", user.getPhone());
		} catch (Exception e) {
		}
		
		try {
			params.put("taxid", user.getTaxid());
		} catch (Exception e) {
		}
		
		try {
			params.put("address", user.getAddress());
		} catch (Exception e) {
		}
		
		try {
			params.put("addressCountryIsoCode", user.getAddressCountryIsoCode());
		} catch (Exception e) {
		}
		
		try {
			params.put("addressRegionCode", user.getAddressRegionCode());
		} catch (Exception e) {
		}
		
		try {
			params.put("addressCityCode", user.getAddressCityCode());
		} catch (Exception e) {
		}
		
		try {
			params.put("addressDistrict", user.getAddressDistrict());
		} catch (Exception e) {
		}
		
		try {
			params.put("addressZipcode", user.getAddressZipcode());
		} catch (Exception e) {
		}
		
		try {
			params.put("accountNo", user.getAccountNo());
		} catch (Exception e) {
		}
		
		try {
			params.put("sponsorAccountNo", user.getSponsorAccountNo());
		} catch (Exception e) {
		}

		return params;
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

			ResponseEntity<Boolean> obj = restTemplate.exchange(cbcService.getGetRequest(isEmailPath, map),
					HttpMethod.GET, cbcService.requestHeaders(), Boolean.class);
			Optional<Object> isEmail = Optional.of(obj.getBody());
			return isEmail;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
