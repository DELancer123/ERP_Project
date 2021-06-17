package com.myspring.invenBasicInfo.controller;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.invenBasicInfo.regItemUnitPrice.vo.*;
import com.myspring.invenBasicInfo.service.*;

@Controller("iupController")
//@EnableAspectAutoProxy
public class iupViewControllerImpl implements iupViewController{
	private static final Logger logger = LoggerFactory.getLogger(iupViewControllerImpl.class);
	@Autowired
	private iupViewService viewService;
	@Autowired
	private iupVO iupVO;
	
	@Override
	@RequestMapping(value="/member/itemunitprice.do",method=RequestMethod.GET)
	public ModelAndView viewIup(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String itemCode = (String)request.getParameter("itemCode");
		String submit = (String)request.getParameter("submit");
		String itemCode1  = (String)request.getParameter("itemCode");
		int sum = 0;
		if(itemCode1 == null || itemCode1.length() == 0 || submit.equals("0")) {
			mav = new ModelAndView(viewName);
			return mav;
		}
		else if(submit.equals("1")) {
			List iupView = viewService.searchView(itemCode1);
			mav = new ModelAndView(viewName);
			mav.addObject("iupView",iupView);
		}
		else if(submit.equals("2")) {
			List iupView = viewService.searchView(itemCode1);
			List iupInsert = viewService.setText(itemCode);
			mav = new ModelAndView(viewName);
			mav.addObject("iupView",iupView);
			mav.addObject("iupInsert",iupInsert);
			int inputNo = viewService.inputNo();
			String inNo = Integer.toString(inputNo+1);
			System.out.println(inNo);
			request.setAttribute("inputNo", inNo);
		}
		return mav;
	}
	
	@RequestMapping(value="/member/iupcodehelper1.do",method=RequestMethod.GET)
	public ModelAndView iupcodeHelper1(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		List itemView = viewService.itemView();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemView",itemView);
		return mav;
	}
	
	@RequestMapping(value="/member/iupcodehelper2.do",method=RequestMethod.GET)
	public ModelAndView iupCodeHelper2(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		String itemNumber = (String) request.getParameter("itemCode");
		List itemView = viewService.itemView();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemView",itemView);
		return mav;
	}
	
	@RequestMapping(value="/member/addIup.do",method=RequestMethod.GET)
	public ModelAndView addMember(@ModelAttribute("iup") iupVO iupVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		System.out.println("url"+path);
		int result = 0;
		result = viewService.addIup(iupVO);
		ModelAndView mav = new ModelAndView("redirect:" + path);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/delIup.do",method=RequestMethod.GET)
	public ModelAndView delMember(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String number = (String) request.getParameter("no");
		String viewName = getViewName(request);
		String[] numberary = number.split(",");
		viewService.delIup(numberary);
		ModelAndView mav = new ModelAndView("redirect:/member/itemunitprice.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/updateIup.do",method=RequestMethod.GET)
	public ModelAndView updateMember(@ModelAttribute("iup") iupVO iupVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = viewService.updateIup(iupVO);
//		String resulturl = url.toString();
		ModelAndView mav = new ModelAndView("redirect:/member/itemunitprice.do");
//		mav.addObject("itemView",itemView);
//		System.out.println("itemCode:"+iupVO.getItemCode());
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		int begin = 0;
		if(!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		}else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		}else {
			end = uri.length();
		}
		
		String viewName = uri.substring(begin,end);
		if(viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0,viewName.lastIndexOf("."));
		}
		if(viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/",1), viewName.length());
		}
		return viewName;
	}
}
