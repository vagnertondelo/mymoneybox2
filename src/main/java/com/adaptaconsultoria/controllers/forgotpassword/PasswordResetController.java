package com.adaptaconsultoria.controllers.forgotpassword;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.models.Password;
import com.adaptaconsultoria.services.PasswordResetService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "reset")
public class PasswordResetController {
	
	@Autowired
	private PasswordResetService passwordResetService;
	
	@GetMapping(value = "password")
	public ModelAndView dashboard(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Redefinição de Senha");
		pageUtil.setTitle("Redefinição de Senha");
		pageUtil.setSubTitle("Extrato Cashback");
		pageUtil.setJs("password.js");
		pageUtil.setFormId("password-form");
		return pageUtil.getModel();
	}
	
	@PostMapping(value = "save")
	public ResponseEntity<?> register(@RequestBody Password obj, HttpSession session, HttpServletRequest request) {
		return ResponseEntity.ok( passwordResetService.save(obj, session, request) );
	}
}
