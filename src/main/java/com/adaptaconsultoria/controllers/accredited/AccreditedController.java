package com.adaptaconsultoria.controllers.accredited;

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

import com.adaptaconsultoria.models.Accredited;
import com.adaptaconsultoria.services.AccreditedService;
import com.adaptaconsultoria.services.CategoryService;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.CurrencyService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "accredited")
public class AccreditedController {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private AccreditedService accreditedService;
	
	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping(value = "list")
	public ModelAndView list(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Credenciado");
		pageUtil.setTitle("Credenciado");
		pageUtil.setSubTitle("Credenciado");
		pageUtil.setTableId("accredited-table");
		pageUtil.setJs("accredited-list.js");
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		pageUtil.setAttr("mi", "accredited");
		return pageUtil.getModel();
	}
	
	@GetMapping(value = "getlist")
	public ResponseEntity<?> getList() {
		return ResponseEntity.ok( accreditedService.list() );
	}
	
	@PostMapping(value = "save")
	public Object register(@RequestBody Accredited obj, HttpSession session) {
		return ResponseEntity.ok( accreditedService.save(obj, session) );
	}
	
	@GetMapping(value = "rules")
	public ResponseEntity<?> getRules(HttpServletRequest request, String id) {
		return ResponseEntity.ok( "" );
	}
	
	@GetMapping(value = "register")
	public ModelAndView accredited(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Credenciado");
		pageUtil.setTitle("Credenciado");
		pageUtil.setInnerTitle("Credenciado");
		pageUtil.setFormId("accredited-form");
		pageUtil.setJs("accredited-register.js");
		pageUtil.setTableId("accreditedpercentagedonation-table");
		pageUtil.setAttr("mi", "accredited");
		Accredited obj = new Accredited();
		
		pageUtil.setAttr("accredited", obj);
		pageUtil.setModelAttribute("accredited");
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		// last call 
 		pageUtil.setAttr("categories", categoryService.getSellerCategoryByCompany(session));
		pageUtil.setAttr("currencies", currencyService.getCurrencyByCompany(session));
		return pageUtil.getModel();
	}
}
