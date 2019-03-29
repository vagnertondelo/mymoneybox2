package com.adaptaconsultoria.services;

import java.util.Optional;

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

import com.adaptaconsultoria.objects.in.CategoriesIn;
import com.adaptaconsultoria.objects.in.UserIn;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private TokenService tokenService;
	
	private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
	private static final String pathseller = "seller/category";
	private static final String pathpartner = "partner/category";
	
	@SuppressWarnings("unused")
	@Override
	public Object getSellerCategoryByCompany(HttpSession session) {
		try {
			
			MultiValueMap<String, String> map = null;
			RestTemplate restTemplate = new RestTemplate();
			UserIn userIn = new UserIn();
			try {
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				userIn = (UserIn) auth.getPrincipal();
				map = cbcService.getBasicPrivateServiceRequest();
			} catch (Exception e) {
				map = cbcService.getBasicPublicServiceRequest();
			}
			ResponseEntity<CategoriesIn> obj = restTemplate.exchange(cbcService.getGetRequest(pathseller, map), HttpMethod.GET, cbcService.requestHeaders(), CategoriesIn.class);
			Optional<CategoriesIn> objOp = Optional.of(obj.getBody());
			
			tokenService.updateToken(objOp.get().getToken());
			
			return objOp.get().getCategories();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	@Override
	public Object getPartnerCategoryByCompany(HttpSession session) {
		try {
			
			MultiValueMap<String, String> map = null;
			RestTemplate restTemplate = new RestTemplate();
			UserIn userIn = new UserIn();
			try {
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				userIn = (UserIn) auth.getPrincipal();
				map = cbcService.getBasicPrivateServiceRequest();
			} catch (Exception e) {
				map = cbcService.getBasicPublicServiceRequest();
			}
			ResponseEntity<CategoriesIn> obj = restTemplate.exchange(cbcService.getGetRequest(pathpartner, map), HttpMethod.GET, cbcService.requestHeaders(), CategoriesIn.class);
			Optional<CategoriesIn> objOp = Optional.of(obj.getBody());
			
			tokenService.updateToken(objOp.get().getToken());
			
			return objOp.get().getCategories();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
