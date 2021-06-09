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
public class IupViewControllerImpl implements IupViewController{
	private static final Logger logger = LoggerFactory.getLogger(IupViewControllerImpl.class);
	@Autowired
	private IupViewService viewService;
	@Autowired
	private IupVO iupVO;
	
	@Override
	@RequestMapping(value="/member/itemunitprice.do",method=RequestMethod.GET)
	public ModelAndView viewIup(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String Item_Code = (String)request.getParameter("Item_Code");
		String submit = (String)request.getParameter("submit");
//		String parentNumber  = (String)request.getParameter("parentNumber"); //부모코드값 받아올때
		System.out.println("Item_Code" +Item_Code);
		if(Item_Code == null || Item_Code.length() == 0 || submit.equals("0")) {
			mav = new ModelAndView(viewName);
			return mav;
		}
		else if(submit.equals("1")) {
			List iupView = viewService.searchView(Item_Code);
			mav = new ModelAndView(viewName);
			mav.addObject("iupView",iupView);
		}
		else if(submit.equals("2")) {
			List iupView = viewService.searchView(Item_Code);
//			List iupInsert = viewService.setText(parentNumber); //부모코드값 받아 올때
			mav = new ModelAndView(viewName);
			mav.addObject("iupView",iupView);
//			mav.addObject("iupInsert",iupInsert); //부모코드값 받아 올때
		}
		return mav;
	}
	
	@RequestMapping(value="/member/iupcodehelper1.do",method=RequestMethod.GET)
	public ModelAndView codeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		List itemView = viewService.itemView();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemView",itemView);
		return mav;
	}
	
	@RequestMapping(value="/member/iupcodehelper2.do",method=RequestMethod.GET)
	public ModelAndView IupCodeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		List itemView = viewService.itemView();
//		int inputNo = viewService.inputNo(); // 칼럼 앞 number count
//		String inNo = Integer.toString(inputNo+1); // 칼럼 앞 number count
//		System.out.println(inNO); // 칼럼 앞 number count
//		request.setAttribute("inputNo", inNo); //칼럼 앞 number count
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemView",itemView);
		return mav;
	}
	
	@RequestMapping(value="/member/addIup.do",method=RequestMethod.GET)
	public ModelAndView addMember(@ModelAttribute("iup") IupVO iupVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
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
		String number = (String) request.getParameter("no"); // 판매단가등록은 no 없음
		String viewName = getViewName(request);
		String[] numberary = number.split(",");
		viewService.delIup(numberary);
		ModelAndView mav = new ModelAndView("redirect:/member/itemunitprice.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/updateIup.do",method=RequestMethod.GET)
	public ModelAndView updateMember(@ModelAttribute("iup") IupVO iupVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-9");
		int result = 0;
		result = viewService.updateIup(iupVO);
//		String resulturl = url.toString();
		ModelAndView mav = new ModelAndView("redirect:/member/itemunitprice.do");
//		mav.addObject("itemView",itemView);
//		System.out.println("Item_Code:"+iupVO.getItem_Code());
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
