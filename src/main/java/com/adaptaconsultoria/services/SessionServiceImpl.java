package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service	
public class SessionServiceImpl implements SessionService {

	private static final Logger log = LoggerFactory.getLogger(SessionServiceImpl.class);
	
	@Override
	public void setToken(String token, HttpSession session) {
		try {
			session.setAttribute("token", token);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public String getToken(HttpSession session) {
		try {
			return (String)session.getAttribute("token");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
