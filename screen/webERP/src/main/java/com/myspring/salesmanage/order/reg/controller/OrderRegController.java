package com.myspring.salesmanage.order.reg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.salesmanage.order.vo.OrderVO;

public interface OrderRegController{
	
	public ModelAndView submitCust(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listAllCust(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addOrder(@ModelAttribute("order") OrderVO orderVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView delOrder(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
