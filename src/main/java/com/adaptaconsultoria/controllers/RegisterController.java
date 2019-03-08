package com.adaptaconsultoria.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.LocationService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
public class RegisterController {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping(path = "register")
	public ModelAndView register(HttpServletRequest request) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath() + "/register"));
		pageUtil.setPageTitle("Registrar");
		pageUtil.setTitle("Registrar");
		pageUtil.setAttr("projectName", cbcService.getName());
		pageUtil.setAttr("token", cbcService.requestToken().getToken());
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		pageUtil.setJs("register.js");
		pageUtil.setFormId("register-form");
		return pageUtil.getModel();
	}
	
//	@PostMapping(value = "/save")
//	public ResponseEntity<?> register(Credenciado credenciado, HttpSession session) {
//		return ResponseEntity.ok(credenciadoService.save(credenciado, session));
//	}
	
	@PostMapping(path = "locations", produces = "application/json")
	@ResponseBody
	public Object getLocations() {
		return locationService.getLocationByCompany();
	}
}