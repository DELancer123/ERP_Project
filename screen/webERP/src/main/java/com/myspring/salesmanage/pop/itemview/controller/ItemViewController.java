package com.myspring.salesmanage.pop.itemview.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;

public interface ItemViewController {

	public ModelAndView submitItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listAllItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addItem(@ModelAttribute("info") ItemViewVO itemviewVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeItem(@RequestParam("item_code") String item_code, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
}
