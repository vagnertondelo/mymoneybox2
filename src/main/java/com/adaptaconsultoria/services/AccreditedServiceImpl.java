package com.adaptaconsultoria.services;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaptaconsultoria.models.Accredited;
import com.adaptaconsultoria.objects.in.AccreditedIn;

@Service
public class AccreditedServiceImpl implements AccreditedService {

	@Autowired
	private RequestService requestService;

	@Autowired
	private TokenService tokenService;

	private static final Logger log = LoggerFactory.getLogger(AccreditedServiceImpl.class);
	private static final String url = "seller";

	@Override
	public Object save(Accredited obj, HttpSession session) {
		try {
			obj.setToken(tokenService.getToken());
			return requestService.postRequest(url, obj, session);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object list() {
		try {
			Boolean isLoggedIn = true;
			Optional<AccreditedIn> objOp = (Optional<AccreditedIn>) requestService.getRequest(url, isLoggedIn, null);
			
			if (isLoggedIn) {
				if (objOp.get().getToken().isEmpty()) {
					throw new Exception();
				}
				tokenService.updateToken(objOp.get().getToken());
			}
			
			return objOp.get().getAccrediteds();
		} catch (Exception e) {
			return null;
		}
	}
}
