package com.myspring.salesmanage.pop.custView.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface CustViewController {
	
	public ModelAndView viewCust(HttpServletRequest request, HttpServletResponse response) throws Exception;
	

}
