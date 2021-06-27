package com.myspring.salesmanage.forward.reg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface ForwardRegController {

	public ModelAndView submitCust(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listForwardCode(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView delForward(HttpServletRequest request, HttpServletResponse response) throws Exception ;
	

	public ModelAndView submitItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listSubForwardCode(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView delSubForward(HttpServletRequest request, HttpServletResponse response) throws Exception ;
}
