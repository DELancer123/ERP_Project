package com.myspring.systemmag.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;
import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagController {
	public ModelAndView addCompany (@ModelAttribute("company") SystemmagVO company,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewCompany(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView deleteCompany(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView updateCompany(SystemmagVO systemmagVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
	public ModelAndView popupCompany(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView popupZipCompany(HttpServletRequest request, HttpServletResponse response) throws Exception;
	 
	
	
			
}
