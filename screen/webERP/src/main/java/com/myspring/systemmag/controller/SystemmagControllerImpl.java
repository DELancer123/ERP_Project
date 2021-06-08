package com.myspring.systemmag.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.systemmag.service.SystemmagService;
import com.myspring.systemmag.vo.SystemmagVO;

@Controller("systemmagController")
@RequestMapping(value="/company")
public class SystemmagControllerImpl implements SystemmagController{
	@Autowired
	private SystemmagService systemmagService;
	@Autowired
	private SystemmagVO systemmagVO;
	
	@Override
	@RequestMapping(value="/addCompany.do" ,method = RequestMethod.POST)
	public void addCompany(@ModelAttribute("systemmagVO") SystemmagVO _systemmagVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		ResponseEntity resEntity = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			systemmagService.addCompany(_systemmagVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
