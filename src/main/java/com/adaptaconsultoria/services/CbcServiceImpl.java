package com.adaptaconsultoria.services;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class CbcServiceImpl implements CbcService {

	@Autowired
	private Environment env;

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
	public String getToken() {
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

	@Override
	public String getIpAdress() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public MultiValueMap<Object, Object> getAll() {
		MultiValueMap<Object, Object> map = new LinkedMultiValueMap<>();
		try {
			map.add("appToken", getToken());
			map.add("appPassword", getPassword());
			map.add("ipAddress", getIpAdress());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return map;
	}

	@Override
	public HttpEntity<MultiValueMap<Object, Object>> getRequest(MultiValueMap<Object, Object> map) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			return new HttpEntity<>(map, headers);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return new HttpEntity<>(null, null);
	}
}
