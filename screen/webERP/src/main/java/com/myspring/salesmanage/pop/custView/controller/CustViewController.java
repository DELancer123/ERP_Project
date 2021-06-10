package com.myspring.salesmanage.pop.custview.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.salesmanage.pop.custview.vo.CustViewVO;

public interface CustViewController {
	
	public ModelAndView listAllCust(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addCust(@ModelAttribute("info") CustViewVO custviewVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeCust(@RequestParam("custCode") String custCode, HttpServletRequest request, HttpServletResponse response) throws Exception;


}
