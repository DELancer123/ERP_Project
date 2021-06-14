package com.myspring.invenBasicInfo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring.invenBasicInfo.regItemUnitPrice.vo.iupVO;

public interface iupViewController {
	public ModelAndView viewIup(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addMember(@ModelAttribute("iup") iupVO iupVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView delMember(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updateMember(@ModelAttribute("iup") iupVO iupVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
} 
