package com.myspring.salesmanage.order.reg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface OrderRegController{
	
	public ModelAndView submitCust(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listAllCust(HttpServletRequest request, HttpServletResponse response) throws Exception;


}
