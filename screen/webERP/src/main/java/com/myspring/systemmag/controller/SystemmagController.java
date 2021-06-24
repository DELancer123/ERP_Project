package com.myspring.systemmag.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;
import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagController {
	//일반거래처등록
	public ModelAndView addCustomer (@ModelAttribute("company") SystemmagVO company,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView updateCustomer(SystemmagVO systemmagVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
		
	public ModelAndView popupCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView popupZipCustomer(SystemmagVO systemmagVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	 
	//창고/공정/외주공정등록
	public ModelAndView viewOutware(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
			
}
