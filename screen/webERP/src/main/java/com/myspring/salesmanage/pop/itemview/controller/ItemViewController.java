package com.myspring.salesmanage.pop.itemview.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface ItemViewController {
	public ModelAndView viewPlanItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView codeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
