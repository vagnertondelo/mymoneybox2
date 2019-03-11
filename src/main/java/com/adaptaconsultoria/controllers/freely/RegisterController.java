package com.adaptaconsultoria.controllers.freely;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.models.User;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.CountryService;
import com.adaptaconsultoria.services.UserService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "freely")
public class RegisterController {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "register")
	public ModelAndView register(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Registrar");
		pageUtil.setTitle("Registrar");
		pageUtil.setAttr("projectName", cbcService.getName());
		pageUtil.setAttr("token", cbcService.requestToken().getToken());
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		pageUtil.setJs("register.js");
		pageUtil.setFormId("register-form");
		return pageUtil.getModel();
	}
	
	@PostMapping(value = "saveuser")
	public Object register(@RequestBody User obj, HttpServletRequest request) {
		return ResponseEntity.ok( userService.saveAndLogin(obj, request) );
	}
	
	@PostMapping(path = "locations", produces = "application/json")
	@ResponseBody
	public Object getLocations() {
		return countryService.getLocationByCompany();
	}
	
	@GetMapping(value = "islogin")
	public ResponseEntity<?> isLogin(String login, HttpSession session) {
		return ResponseEntity.ok( userService.isLogin(login, session) );
	}
	
	@GetMapping(value = "isemail")
	public ResponseEntity<?> isEmail(String email, HttpSession session) {
		return ResponseEntity.ok( userService.isEmail(email, session) );
	}
	
}
