package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.adaptaconsultoria.models.Partner;
import com.adaptaconsultoria.objects.in.AccreditedIn;
import com.adaptaconsultoria.objects.in.PartnerIn;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private TokenService tokenService;

	@Autowired
	private JsonService jsonService;

	private static final Logger log = LoggerFactory.getLogger(PartnerServiceImpl.class);
	private static final String url = "partner";
	
	@Override
	public Object save(Partner obj, HttpSession session) {
		try {
			obj.setToken(tokenService.getToken());
			return requestService.postRequest(url, obj, session);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Object findByAccountNo(String accountNo) {
		try {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			map.set("accountNo", accountNo);
			Object o = requestService.getRequest(url, true, map);
			PartnerIn objOp = (PartnerIn) jsonService.objToObj(o, new PartnerIn());
			return objOp.getPartner();
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public Object list() {
		try {
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			Object o = requestService.getRequest(url, true, map);
			AccreditedIn objOp = (AccreditedIn) jsonService.objToObj(o, new AccreditedIn());
			return objOp.getAccrediteds();
		} catch (Exception e) {
			return null;
		}
	}
}

