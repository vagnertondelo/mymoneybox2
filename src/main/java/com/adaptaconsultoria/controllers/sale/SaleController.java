package com.adaptaconsultoria.controllers.sale;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adaptaconsultoria.models.Account;
import com.adaptaconsultoria.models.Partner;
import com.adaptaconsultoria.models.Rule;
import com.adaptaconsultoria.models.Sale;
import com.adaptaconsultoria.services.AccountService;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.PartnerService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "sale")
public class SaleController {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private PartnerService partnerService;
	
	@GetMapping(value = "register")
	public ModelAndView partner(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		Sale obj = new Sale();
		
		pageUtil.setPageTitle("Registro de Compra");
		pageUtil.setTitle("Registro de Compra");
		pageUtil.setInnerTitle("Registro de Compra");
		pageUtil.setFormId("sale-form");
		pageUtil.setJs("sale-register.js");
		pageUtil.setAttr("rules", getRules(session));
		pageUtil.setAttr("mi", "sale");
		pageUtil.setAttr("sale", obj);
		pageUtil.setModelAttribute("sale");
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		return pageUtil.getModel();
	}
	
	private List<Rule> getRules(HttpSession session) {
		try {
			Account account = (Account) accountService.getAcccount(session);
			Partner partner = (Partner) partnerService.findByAccountNo(account.getAccountNo());
			return partner.getRules();
		} catch (Exception e) {
			return null;
		}
	}
	
}
