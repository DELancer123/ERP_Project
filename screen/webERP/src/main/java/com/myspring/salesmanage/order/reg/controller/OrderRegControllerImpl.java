package com.myspring.salesmanage.order.reg.controller;

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

import com.myspring.salesmanage.order.reg.service.OrderRegService;
import com.myspring.salesmanage.order.vo.OrderVO;

@Controller("orderRegController")
public class OrderRegControllerImpl implements OrderRegController{

	private static final Logger logger = LoggerFactory.getLogger(OrderRegControllerImpl.class);
	
	@Autowired
	private OrderVO orderVO;
	
	@Autowired
	private OrderRegService orderService;
	   
//	@Override
//	@RequestMapping(value="/sales_manage/pop/regorderCust.do",method = RequestMethod.GET)
//	public ModelAndView submitCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String viewName = getViewName(request);
//		logger.info("viewName: "+ viewName);
//		logger.debug("viewName: "+ viewName);
//		List orderCustList = orderService.listCusts();
//		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("orderCustList", orderCustList);
//		return mav;
//	}

	@Override
	@RequestMapping(value="/sales_manage/pop/regorderCust.do",method = RequestMethod.GET)
	public ModelAndView submitCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		List orderCustList = orderService.listCusts();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("orderCustList", orderCustList);

		return mav;
	}//"selectOrderList"
	
	@Override
	@RequestMapping(value="/member/regorder.do" ,method = RequestMethod.GET)
	public ModelAndView listAllCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String code = (String)request.getParameter("custCode");
		String submit = (String)request.getParameter("submit");
		
		if(code == null || code.length() == 0) {
//			||submit.equals("0")) {
		
			mav = new ModelAndView(viewName);
			return mav;
		}
		List orderList = orderService.submitCust(code);
		mav = new ModelAndView(viewName);
		mav.addObject("orderList", orderList);
//		else if(submit.equals("1")) {
//			List orderList = orderService.submitCust(code);
//			mav = new ModelAndView(viewName);
//			mav.addObject("orderList", orderList);
//		}else if(submit.equals("2")) {
//			List orderList = orderService.submitCust(code);
//			mav = new ModelAndView(viewName);
//			mav.addObject("orderList", orderList);
//			int inputNo = orderService.inputNo();
//			String inNo = Integer.toString(inputNo+1);
//			System.out.println(inNo+"번째 주문번호");
//			request.setAttribute("inputNo", inNo);
//		}
//		return mav;
		return mav;
	}
	@Override
	@RequestMapping(value="/member/addorder.do", method = RequestMethod.GET)
	public ModelAndView addOrder(OrderVO orderVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		System.out.println("url"+path);
		int result = 0;
		result = orderService.addOrder(orderVO);
		ModelAndView mav = new ModelAndView("redirect:" + path);
		System.out.println("list"+orderVO.getListOrd().get(2).getCustName());
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/delorder.do", method = RequestMethod.GET)
	public ModelAndView delOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = (String)request.getParameter("ordCode");
		String viewName = getViewName(request);
		String[] codeary = code.split(",");
		orderService.removeOrder(codeary);
		ModelAndView mav = new ModelAndView("redirect:/member/regorder.do");
		
		return mav;
	}
	
	@RequestMapping(value="/sales_manage/pop/regorderItem.do",method = RequestMethod.GET)
	public ModelAndView helper(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		List orderCustList = orderService.listCusts();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("orderCustList", orderCustList);

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
