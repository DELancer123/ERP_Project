package com.myspring.systemmag2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView addCompany(SystemmagVO company, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(systemmagVO.getCompany_Code());
		request.setCharacterEncoding("utf-8");
		StringBuffer url = request.getRequestURL();
		int result = 0;
		result = systemmagService.addCompany(systemmagVO);
		String resulturl = url.toString();
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	
}
