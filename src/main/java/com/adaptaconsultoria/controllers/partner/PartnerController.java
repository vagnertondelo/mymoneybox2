package com.adaptaconsultoria.controllers.partner;

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

import com.adaptaconsultoria.models.Partner;
import com.adaptaconsultoria.services.CategoryService;
import com.adaptaconsultoria.services.CbcService;
import com.adaptaconsultoria.services.CurrencyService;
import com.adaptaconsultoria.services.PartnerService;
import com.adaptaconsultoria.utils.pages.PageUtil;

@Controller
@RequestMapping(value = "partner")
public class PartnerController {

	@Autowired
	private CbcService cbcService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping(value = "list")
	public ModelAndView list(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Parceiro");
		pageUtil.setTitle("Parceiro");
		pageUtil.setSubTitle("Parceiro");
		pageUtil.setTableId("partner-table");
		pageUtil.setJs("partner-list.js");
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		pageUtil.setAttr("mi", "partner");
		return pageUtil.getModel();
	}
	
	@PostMapping(value = "save")
	public Object register(@RequestBody Partner obj, HttpSession session) {
		return ResponseEntity.ok( partnerService.save(obj, session) );
	}
	
	@GetMapping(value = "getlist")
	public ResponseEntity<?> getList() {
		return ResponseEntity.ok( partnerService.list() );
	}
	
	@GetMapping(value = "register")
	public ModelAndView partner(HttpServletRequest request, HttpSession session) {
		PageUtil pageUtil = new PageUtil(new ModelAndView(request.getServletPath()));
		pageUtil.setPageTitle("Parceiro");
		pageUtil.setTitle("Parceiro");
		pageUtil.setInnerTitle("Parceiro");
		pageUtil.setFormId("partner-form");
		pageUtil.setJs("partner-register.js");
		pageUtil.setAttr("mi", "partner");
		Partner obj = new Partner();

//		if (id != null) {
//			pageUtil.setSubTitle("Editar");
//			try {
//				obj = credenciadoDao.findOne(id);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			pageUtil.setSubTitle("Adicionar");
//		}
		
		pageUtil.setAttr("partner", obj);
		pageUtil.setModelAttribute("partner");
		pageUtil.setAttr("ipAddress", cbcService.getIpAdress());
		pageUtil.setAttr("categories", categoryService.getPartnerCategoryByCompany(session));
		pageUtil.setAttr("currencies", currencyService.getCurrencyByCompany(session));
		return pageUtil.getModel();
	}
}
