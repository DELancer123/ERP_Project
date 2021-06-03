package com.myspring.commonProduction.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface CommonProductionController {

	public ModelAndView listProductInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listOpertaionInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;

}