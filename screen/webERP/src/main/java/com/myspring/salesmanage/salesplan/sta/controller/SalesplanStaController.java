package com.myspring.salesmanage.salesplan.sta.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.salesmanage.salesplan.vo.SalesplanVO;

public interface SalesplanStaController {

	public ModelAndView listSalesplans(HttpServletRequest request, HttpServletResponse response) throws Exception ;
	public ModelAndView searchCode(@RequestParam("Item_Code") String Item_Code, 
	           HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView searchPlanDate(@RequestParam("Plan_Date") Date Plan_Date, 
	           HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView searchGroup(@RequestParam("Item_Group_Code") String Item_Group_Code, 
	           HttpServletRequest request, HttpServletResponse response) throws Exception;

}
