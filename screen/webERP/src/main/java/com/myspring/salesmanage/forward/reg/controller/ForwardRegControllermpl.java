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
	@RequestMapping(value="/member/forwardcodehelper1.do",method = RequestMethod.GET)
	public ModelAndView submitCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("야ㅐㅑ야야");
		String viewName = getViewName(request);
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
			int inputNo = forwardRegService.inputNo();
			String inNo = Integer.toString(inputNo+1);
			request.setAttribute("inputNo", inNo);
		}
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/delforward.do", method = RequestMethod.GET)
	public ModelAndView delForward(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = (String)request.getParameter("no");
		String viewName = getViewName(request);
		String[] codeary = code.split(",");
		System.out.println(codeary+"codeary");
		System.out.println(code+"code");
		forwardRegService.removeForward(codeary);
		ModelAndView mav = new ModelAndView("redirect:/member/forwarding.do");
		
		return mav;
	}

	@Override
	@RequestMapping(value="/member/forwardcodehelper2.do",method = RequestMethod.GET)
	public ModelAndView submitItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List forwardCustList = forwardRegService.listCusts();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("forwardCustList", forwardCustList);

		return mav;
	}

	@Override
	@RequestMapping(value="/member/insertByItem.do",method = RequestMethod.GET)
	public ModelAndView listSubForwardCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub  submitForwardCustReg
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String code = (String)request.getParameter("custCode");
		String submit = (String)request.getParameter("submit");
		
		if(code == null || code.length() == 0||submit.equals("0")) {
		
			mav = new ModelAndView(viewName);
			return mav;
		}
		else if(submit.equals("1")) {
			List submitCustList = forwardRegService.submitCustByInsert(code);
			mav = new ModelAndView(viewName);
			mav.addObject("submitCustList", submitCustList);
			
		}else if(submit.equals("2")) {
			List submitCustList = forwardRegService.submitCustByInsert(code);
			List supForwardInsert = forwardRegService.listForwardCust();
			mav = new ModelAndView(viewName);
			mav.addObject("submitCustList", submitCustList);
			mav.addObject("supForwardInsert", supForwardInsert);
			int inputNo = forwardRegService.inputNo();
			String inNo = Integer.toString(inputNo+1);
			request.setAttribute("inputNo", inNo);
		}
		return mav;
	}

	@Override
	public ModelAndView delSubForward(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
