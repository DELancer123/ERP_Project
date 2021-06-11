package com.myspring.salesmanage.salesplan.sta.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.salesmanage.pop.itemgroup.vo.ItemGroupVO;
import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;
import com.myspring.salesmanage.salesplan.vo.SalesplanVO;

public interface SalesplanStaController {

//	public ModelAndView listSalesplan(HttpServletRequest request, HttpServletResponse response) throws Exception ;
	public ModelAndView submitItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listAllItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addItem(@ModelAttribute("info") ItemViewVO itemviewVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeItem(@RequestParam("item_code") String item_code, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
//	public ModelAndView submitGroup(HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView listAllGroup(HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView addGroup(@ModelAttribute("info") ItemGroupVO itemgroupVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView removeGroup(@RequestParam("groupcode") String item_code, HttpServletRequest request, HttpServletResponse response) throws Exception;
//	
//	
////	public ModelAndView searchCode(@RequestParam("Item_Code") String Item_Code, 
////	           HttpServletRequest request, HttpServletResponse response) throws Exception;
////	public ModelAndView searchPlanDate(@RequestParam("Plan_Date") Date Plan_Date, 
////	           HttpServletRequest request, HttpServletResponse response) throws Exception;
////	public ModelAndView searchGroup(@RequestParam("Item_Group_Code") String Item_Group_Code, 
////	           HttpServletRequest request, HttpServletResponse response) throws Exception;

}
