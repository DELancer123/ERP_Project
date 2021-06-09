//package com.myspring.salesmanage.pop.itemview.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;
//
//
//public interface ItemViewController {
//	
//	public ModelAndView listItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView addMember(@ModelAttribute("info") ItemViewVO itemviewVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
//	
////	public ModelAndView viewPlanItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
////	public ModelAndView codeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception;
//}
