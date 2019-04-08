package com.adaptaconsultoria.services;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaptaconsultoria.objects.in.CategoriesIn;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private JsonService jsonService;
	
	private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
	private static final String pathseller = "seller/category";
	private static final String pathpartner = "partner/category";
	
	@Override
	public Object getSellerCategoryByCompany(HttpSession session) {
		try {
			Object o = requestService.getRequest(pathseller, true, null);
			CategoriesIn objOp = (CategoriesIn) jsonService.objToObj(o, new CategoriesIn());
			System.out.println(objOp.getCategories());
			return objOp.getCategories();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public Object getPartnerCategoryByCompany(HttpSession session) {
		try {
			Object o = requestService.getRequest(pathpartner, true, null);
			CategoriesIn objOp = (CategoriesIn) jsonService.objToObj(o, new CategoriesIn());
			return objOp.getCategories();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
