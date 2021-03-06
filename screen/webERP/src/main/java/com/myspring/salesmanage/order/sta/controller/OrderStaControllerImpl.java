package com.myspring.salesmanage.order.sta.controller;

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

import com.myspring.salesmanage.order.sta.service.OrderStaService;
import com.myspring.salesmanage.order.vo.OrderVO;
import com.myspring.salesmanage.salesplan.sta.controller.SalesplanStaControllerImpl;

@Controller("orderStaController")
public class OrderStaControllerImpl implements OrderStaController{

	private static final Logger logger = LoggerFactory.getLogger(OrderStaControllerImpl.class);
	
	@Autowired
	private OrderVO orderVO;
	
	@Autowired
	private OrderStaService orderService;
	   
	@Override
	@RequestMapping(value="/member/ordercodehelper.do",method = RequestMethod.GET)
	public ModelAndView submitCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List orderCustList = orderService.listCusts();
		List orderList = orderService.listOrder();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("orderCustList", orderCustList);
		mav.addObject("orderList", orderList);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/orderstat.do" ,method = RequestMethod.GET)
	public ModelAndView listAllCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String code = (String)request.getParameter("custCode");
		
		if(code == null || code.length() == 0) {
			mav = new ModelAndView(viewName);
			return mav;
		}

			List submitOrderCust = orderService.submitCust(code);
			
			mav = new ModelAndView(viewName);
			mav.addObject("submitOrderCust", submitOrderCust);

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
