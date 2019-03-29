package com.adaptaconsultoria.controllers.freely;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.models.Email;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.RecoveryPasswordService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "freely")
public class RecoveryPasswordController {
	
	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private RecoveryPasswordService recoveryPasswordService;

	@GetMapping(path = "recoverypassword")
	public ModelAndView forgotPassword(HttpServletRequest request) {
		PageUtil pageUtil = new PageUtil( new ModelAndView(request.getServletPath() ));
		pageUtil.setPageTitle("Esqueci minha senha");
		pageUtil.setTitle("Esqueci minha senha");
		pageUtil.setAttr("projectName", cbcService.getName());
		pageUtil.setJs("recovery-password.js");
		pageUtil.setFormId("recovery-password-form");
		return pageUtil.getModel();
	}
	
	@PostMapping(path = "recoverypassword")
	public ResponseEntity<?> post(Email email, HttpSession session) {
		return ResponseEntity.ok(recoveryPasswordService.sendEmail(email, session));
	}
}
