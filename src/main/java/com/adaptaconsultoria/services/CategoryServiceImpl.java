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

import com.adaptaconsultoria.objects.in.CategoriesIn;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private SessionService sessionService;
	
	private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
	private static final String path = "seller/category";
	
	@Override
	public Object getCategoryByCompany(HttpSession session) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			MultiValueMap<String, String> map = cbcService.getBasicPublicServiceRequest();
			ResponseEntity<CategoriesIn> obj = restTemplate.exchange(cbcService.getGetRequest(path, map), HttpMethod.GET, cbcService.requestHeaders(), CategoriesIn.class);
			Optional<CategoriesIn> userOp = Optional.of(obj.getBody());
			sessionService.setAtribute("token", userOp.get().getToken(), session);
			return userOp.get().getCategories();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
