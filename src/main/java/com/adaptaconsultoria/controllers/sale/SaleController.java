package com.adaptaconsultoria.controllers.sale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.models.Sale;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.UserService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "sale")
public class SaleController {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "register")
	public ModelAndView partner(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Registro de Compra");
		pageUtil.setTitle("Registro de Compra");
		pageUtil.setInnerTitle("Registro de Compra");
		pageUtil.setFormId("sale-form");
		pageUtil.setJs("sale-register.js");
		pageUtil.setAttr("mi", "sale");
		
		Sale obj = new Sale();
		
		userService.getAcccount(session);
		
		pageUtil.setAttr("sale", obj);
		pageUtil.setModelAttribute("sale");
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		return pageUtil.getModel();
	}
}
