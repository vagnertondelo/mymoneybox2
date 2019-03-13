package com.adaptaconsultoria.services;

import java.net.InetAddress;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.adaptaconsultoria.models.Token;

import net.minidev.json.JSONObject;

@Service
public class CbcServiceImpl implements CbcService {

	@Autowired
	private Environment env;
	
	private final String ipAPI = "https://api.ipify.org?format=json";
	
	@Autowired
	private TokenService tokenService;

	private static final Logger log = LoggerFactory.getLogger(CbcServiceImpl.class);

	@Override
	public String getUrl() {
		try {
			return env.getProperty("api.url");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public String getName() {
		try {
			return env.getProperty("app.name");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public String getAppToken() {
		try {
			return env.getProperty("app.token");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public String getPassword() {
		try {
			return env.getProperty("app.password");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getIpAdress() {
		InetAddress inetAddress = null;
		try {
			inetAddress = InetAddress.getLocalHost();
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Object> obj = restTemplate.exchange(ipAPI, HttpMethod.GET, requestHeaders(), Object.class);
			Optional<Object> object = Optional.of(obj.getBody());
			Map<Object, Object> map =  (Map<Object, Object>) object.get();
			String ipAddress = (String) map.get("ip");
			return ipAddress;
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return inetAddress.getHostAddress();
	}
	
	@Override
	public JSONObject getApplicationCredentials() {
		JSONObject params = new JSONObject();
		try {
			params.put("appToken", getAppToken());
			params.put("appPassword", getPassword());
			params.put("ipAddress", getIpAdress());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return params;
	}

	@Override
	public MultiValueMap<Object, Object> getApplicationCredentialsMultiPart() {
		MultiValueMap<Object, Object> map = new LinkedMultiValueMap<>();
		try {
			map.add("appToken", getAppToken());
			map.add("appPassword", getPassword());
			map.add("ipAddress", getIpAdress());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return map;
	}
	
	@Override
	public MultiValueMap<String, String> getBasicPublicServiceRequest() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		try {
			map.add("token", requestToken().getToken());
			map.add("ipAddress", getIpAdress());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return map;
	}
	
	@Override
	public MultiValueMap<String, String> getBasicPrivateServiceRequest() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		try {
			map.add("token", tokenService.getToken());
			map.add("ipAddress", getIpAdress());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return map;
	}

	@Override
	public String getGetRequest(String path, MultiValueMap<String, String> parameters) {
		
		try {
			return UriComponentsBuilder.fromHttpUrl(append(path)).queryParams(parameters).toUriString();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
		
	}
	
	@Override
	public HttpEntity<String> getPostRequestHeaders(String params) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			return new HttpEntity<String>(params, headers);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return new HttpEntity<>(null, null);
	}
	
	@Override
	public HttpEntity<?> requestHeaders() {
		try {
			HttpHeaders requestHeaders = new HttpHeaders();
			requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
			return new HttpEntity<>(requestHeaders);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
		
	}

	@Override
	public String append(String path) {
		try {
			return (getUrl() + path);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Token requestToken() {
		String params = getApplicationCredentials().toString();
		String path = "auth";
		
		Token token = new Token();
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Token> obj = restTemplate.exchange(append(path), HttpMethod.POST, getPostRequestHeaders(params), Token.class);
			Optional<Token> tokenOp = Optional.of(obj.getBody());
			token = tokenOp.get();
			return token;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
