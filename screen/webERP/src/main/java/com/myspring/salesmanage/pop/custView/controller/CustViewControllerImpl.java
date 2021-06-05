package com.myspring.salesmanage.pop.custView.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.salesmanage.pop.custView.service.CustViewService;
import com.myspring.salesmanage.pop.custView.vo.CustViewVO;

@Controller("custViewController")
public class CustViewControllerImpl implements CustViewController{

	private static final Logger logger = LoggerFactory.getLogger(CustViewControllerImpl.class);
	
	@Autowired
	private CustViewService service;
	
	@Autowired
	private CustViewVO custViewVO;


	@Override
	@RequestMapping(value = "/member/searchcust.do", method = RequestMethod.GET)
	public ModelAndView viewCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String custCode = (String) request.getParameter("General_Customer_Code");
		if(custCode == null || custCode.length() == 0) {
			mav = new ModelAndView(viewName);
			return mav;
		}
		else {
			List bomView = service.searchView(custCode);
			mav = new ModelAndView(viewName);
			mav.addObject("bomView", bomView);
		}
			
		System.out.println("?‚˜?˜¨?‹¤ ?‚˜??" + custCode);
		return mav;
	}
	
	@RequestMapping(value="/member/requestcust.do" ,method = RequestMethod.GET)
	public ModelAndView requestCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List custView = service.custView();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("custView", custView);
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}
}
