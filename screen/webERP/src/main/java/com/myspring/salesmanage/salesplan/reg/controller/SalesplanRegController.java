package com.myspring.salesmanage.salesplan.reg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.salesmanage.itemview.vo.ItemViewVO;
import com.myspring.salesmanage.salesplan.vo.SalesplanVO;

public interface SalesplanRegController {
	
	//sta, reg
	public ModelAndView submitItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listItemBySales(HttpServletRequest request, HttpServletResponse response) throws Exception;

	//reg
//	public ModelAndView updNewSalesplan(@ModelAttribute("info")ItemViewVO itemviewVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView removeSalesplan(@RequestParam("Plan_Item_Code") String Plan_Item_Code, 
//			HttpServletRequest request, HttpServletResponse response) throws Exception;

//	public ModelAndView listSalesplans(HttpServletRequest request, HttpServletResponse response) throws Exception ;
//	public ModelAndView addSalesplan(@ModelAttribute("info")ItemViewVO itemviewVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView searchCode(@RequestParam("Plan_Item_Code") String Plan_Item_Code, 
//	           HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView searchPrice(@RequestParam("Plan_Unit_Price") int Plan_Unit_Price, 
//	           HttpServletRequest request, HttpServletResponse response) throws Exception;
//	
////	public ModelAndView searchCode(@ModelAttribute("itemviewVO") ItemViewVO itemviewVO,
////            RedirectAttributes rAttr,
////            HttpServletRequest request, HttpServletResponse response) throws Exception;
////	public ModelAndView searchName(@ModelAttribute("itemviewVO") ItemViewVO itemviewVO,
////            RedirectAttributes rAttr,
////            HttpServletRequest request, HttpServletResponse response) throws Exception;
////	public ModelAndView searchDate(@ModelAttribute("itemviewVO") ItemViewVO itemviewVO,
////            RedirectAttributes rAttr,
////            HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
}
