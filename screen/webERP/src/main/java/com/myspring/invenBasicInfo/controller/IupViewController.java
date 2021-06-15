package com.myspring.invenBasicInfo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.invenBasicInfo.regItemUnitPrice.vo.iupVO;
import org.springframework.web.bind.annotation.ResponseBody;

public interface IupViewController {
	public ModelAndView viewIup(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addMember(@ModelAttribute("iup") iupVO iupVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/*
	 * public ModelAndView removeMember(@RequestParam("id") String id,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception;
	 * public ModelAndView login(@ModelAttribute("member") bomVO
	 * member,RedirectAttributes rAttr,HttpServletRequest request,
	 * HttpServletResponse response) throws Exception; public ModelAndView
	 * logout(HttpServletRequest request, HttpServletResponse response) throws
	 * Exception;
	 */

//	public ModelAndView delMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public ModelAndView updateMember(@ModelAttribute("iup") iupVO iupVO, HttpServletRequest request, HttpServletResponse response) throws Exception;

}