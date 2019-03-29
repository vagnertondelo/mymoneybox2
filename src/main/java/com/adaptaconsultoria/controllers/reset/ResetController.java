package com.adaptaconsultoria.controllers.reset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "reset")
public class ResetController {

	@Autowired
	private CbcService cbcService;

	@GetMapping(value = "passwordreset")
	public ModelAndView reset(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil( new ModelAndView(request.getServletPath() ));
		pageUtil.setPageTitle("Redefinir Senha");
		pageUtil.setTitle("Redefinir Senha");
		pageUtil.setAttr("projectName", cbcService.getName());
		pageUtil.setJs("reset-password.js");
		pageUtil.setFormId("reset-password-form");
		return pageUtil.getModel();
	}
}
