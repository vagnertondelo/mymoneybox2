package com.adaptaconsultoria.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(path = { "login", "" })
public class LoginController {

	@Autowired
	private CbcService cbcService;

	@GetMapping
	public ModelAndView login(HttpServletRequest request) {
		
		System.out.println(request.getServletPath());
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath() + "/login"));
		pageUtil.setPageTitle("Login");
		pageUtil.setTitle("Login");
		pageUtil.setAttr("projectName", cbcService.getName());
		pageUtil.setJs("login.js");
		pageUtil.setFormId("login-form");
		return pageUtil.getModel();
	}

	@GetMapping(path = "/forgotpassword")
	public ModelAndView forgotPassword() {
		PageUtil pageUtil = new PageUtil(new ModelAndView("forgotpassword"));
		pageUtil.setPageTitle("Esqueci minha senha");
		pageUtil.setTitle("Esqueci minha senha");
		pageUtil.setAttr("projectName", cbcService.getName());
		pageUtil.setJs("forgotpassword.js");
		pageUtil.setFormId("esqueci-minha-senha-form");
		return pageUtil.getModel();
	}
}