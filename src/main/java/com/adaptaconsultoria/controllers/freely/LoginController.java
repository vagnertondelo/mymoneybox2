package com.adaptaconsultoria.controllers.freely;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "freely")
public class LoginController {
	
	@Autowired
	private CbcService cbcService;
	
	@GetMapping(path = "login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse resposne) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Login");
		pageUtil.setTitle("Login");
		pageUtil.setAttr("projectName", cbcService.getName());
		pageUtil.setJs("login.js");
		pageUtil.setFormId("login-form");
		resposne.setHeader("Cache-Control", "max-age=3600");
		resposne.setHeader("Service-Worker-Allowed","/mymoneybox");
		
		return pageUtil.getModel();
	}
}
