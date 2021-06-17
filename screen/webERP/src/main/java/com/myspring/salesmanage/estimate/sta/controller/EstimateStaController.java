package com.myspring.salesmanage.estimate.sta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.salesmanage.estimate.vo.EstimateVO;

public interface EstimateStaController {
	public ModelAndView listCust(@ModelAttribute("est") EstimateVO estimateVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView submitEst(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
