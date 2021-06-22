package com.myspring.order_closing.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.MainPlan.controller.MainPlanControllerImpl;
import com.myspring.order_closing.service.OrderClosingService;
import com.myspring.order_closing.vo.OrderClosingVO;

@Controller("orderclosingController")
public class OrderClosingControllerImpl implements OrderClosingController{
	private static final Logger logger = LoggerFactory.getLogger(MainPlanControllerImpl.class);
	@Autowired
	private OrderClosingService orderclosingService;
	@Autowired
	private OrderClosingVO orderclosingVO;
	
	@Override
	@RequestMapping(value = "member/orderclosing.do", method = RequestMethod.GET)
	public ModelAndView ClosingList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String viewName = (String) request.getAttribute("viewName");
		List ClosingList = orderclosingService.selectAllClosingList(startDate, endDate);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("ClosingList", ClosingList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/updateOrderClosing.do" ,method = RequestMethod.GET)
	public ModelAndView updateOrderClosing(@ModelAttribute("OrderClosing") OrderClosingVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = orderclosingService.updateOrderClosing(vo);
		System.out.println("result "+result);
		ModelAndView mav = new ModelAndView("redirect:/member/orderclosing.do");
		return mav;
	}
}
