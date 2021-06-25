package com.myspring.salesmanage.forward.reg.controller;

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

import com.myspring.salesmanage.forward.reg.service.ForwardRegService;
import com.myspring.salesmanage.forward.vo.ForwardVO;


@Controller("forwardRegController")
public class ForwardRegControllermpl implements ForwardRegController{

	private static final Logger logger = LoggerFactory.getLogger(ForwardRegControllermpl.class);
	
	@Autowired
	private ForwardVO forwardVO;
	
	@Autowired
	private ForwardRegService forwardRegService;
	
	@Override
	@RequestMapping(value="/sales_manage/pop/regforwardCust.do",method = RequestMethod.GET)
	public ModelAndView submitCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
//		logger.info("viewName: "+ viewName);
//		logger.debug("viewName: "+ viewName);
		List forwardCustList = forwardRegService.listCusts();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("forwardCustList", forwardCustList);

		return mav;
	}

	@Override
	@RequestMapping(value="/member/forwarding.do" ,method = RequestMethod.GET)
	public ModelAndView listForwardCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String code = (String)request.getParameter("custCode");
		String submit = (String)request.getParameter("submit");
		
		if(code == null || code.length() == 0||submit.equals("0")) {
		
			mav = new ModelAndView(viewName);
			return mav;
		}
		else if(submit.equals("1")) {
			List supForwardList = forwardRegService.submitCust(code);
			mav = new ModelAndView(viewName);
			mav.addObject("supForwardList", supForwardList);
			
		}else if(submit.equals("2")) {
			List supForwardList = forwardRegService.submitCust(code);
			List forwardInsert = forwardRegService.submitCust(code);
			mav = new ModelAndView(viewName);
			mav.addObject("supForwardList", supForwardList);
			mav.addObject("forwardInsert", forwardInsert);
//			int inputNo = orderService.inputNo();
//			String inNo = Integer.toString(inputNo+1);
//			request.setAttribute("inputNo", inNo);
		}
		return mav;
	}

	private String getViewName(HttpServletRequest request)  throws Exception{
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
