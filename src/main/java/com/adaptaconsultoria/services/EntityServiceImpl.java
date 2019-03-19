package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.adaptaconsultoria.objects.in.EntityIn;
import com.adaptaconsultoria.objects.in.EntityToPersistIn;

@Service
public class EntityServiceImpl implements EntityService {

	@Autowired
	private RequestService requestService;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private CbcService cbcService;

	@Autowired
	private JsonService jsonService;

	private static final Logger log = LoggerFactory.getLogger(EntityServiceImpl.class);
	private static final String entity = "entity";
	private static final String accountentity = "accountentity";

	@Override
	public Object save(EntityToPersistIn obj, HttpSession session) {
		try {
			obj.setIpAddress(cbcService.getIpAdress());
			obj.setToken(tokenService.getToken());
			return requestService.postRequest(accountentity, obj, session);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Object getEntities() {
		try {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			Object o = requestService.getRequest(entity, true, map);
			EntityIn objOp = (EntityIn) jsonService.objToObj(o, new EntityIn());
			return objOp.getEntities();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Object getEntitiesByAccount() {
		try {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			Object o = requestService.getRequest(accountentity, true, map);
			EntityToPersistIn objOp = (EntityToPersistIn) jsonService.objToObj(o, new EntityToPersistIn());
			return objOp.getEntities();
		} catch (Exception e) {
			return null;
		}
	}
}
