package com.adaptaconsultoria.utils.pages;

import org.springframework.web.servlet.ModelAndView;

public class PageUtil {
	ModelAndView model;

	public PageUtil(ModelAndView model) {
		this.model = model;
	}

	public void setPageTitle(String title) {
		this.model.addObject("page", title);
	}

	public void setTableId(String tableId) {
		this.model.addObject("tableId", tableId);
	}

	public void setTitle(String title) {
		this.model.addObject("title", title);
	}

	public void setSubTitle(String subTitle) {
		this.model.addObject("subTitle", subTitle);
	}

	public void setJs(String js) {
		this.model.addObject("js", js);
	}

	public void setInnerTitle(String innerTitle) {
		this.model.addObject("innerTitle", innerTitle);
	}

	public void setText(String text) {
		this.model.addObject("text", text);
	}

	public void setFormId(String formId) {
		this.model.addObject("formId", formId);
	}

	public void setAttr(String attr, Object value) {
		this.model.addObject(attr, value);
	}

	public void setModelAttribute(String modelAttribute) {
		this.model.addObject("modelAttribute", modelAttribute);
	}

	public ModelAndView getModel() {
		return this.model;
	}
}