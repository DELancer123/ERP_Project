package com.myspring.invenBasicInfo.controller;

import java.util.ArrayList;
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

import com.myspring.invenBasicInfo.service.IupViewService;
import com.myspring.invenBasicInfo.regItemUnitPrice.vo.*;


@Controller("iupMemberController")
//@EnableAspectJAutoProxy
public class IupViewControllerImpl implements IupViewController {
	private static final Logger logger = LoggerFactory.getLogger(IupViewControllerImpl.class);
	@Autowired
	private IupViewService iupViewService;
	@Autowired
	private iupVO iupVO ;
	
	@Override
	@RequestMapping(value="/member/itemunitprice.do" ,method = RequestMethod.GET)
	public ModelAndView viewIup(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String number = (String) request.getParameter("itemNumber");
		String submit = (String) request.getParameter("submit");
		String itemNumber = (String) request.getParameter("itemCode");
		int sum = 0;
		if(number == null || number.length() == 0 || submit.equals("0")) {
			mav = new ModelAndView(viewName);
			return mav;
		}
		else if(submit.equals("1")){
			List iupView = iupViewService.SearchView(number);
			
			mav = new ModelAndView(viewName);
			
			mav.addObject("iupView", iupView);
		}
		else if(submit.equals("2")) {
			List iupView = iupViewService.SearchView(number);
			List iupInsert = iupViewService.setText(itemNumber);
			mav = new ModelAndView(viewName);
			mav.addObject("iupView", iupView);
			mav.addObject("iupInsert",iupInsert);
			int inputNo = iupViewService.inputNo();
			String inNo = Integer.toString(inputNo+1);
			System.out.println(inNo);
			request.setAttribute("inputNo", inNo);
		}
		return mav;
	}
	
	@RequestMapping(value="/member/iupcodehelper1.do" ,method = RequestMethod.GET)
	public ModelAndView codeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List itemView = iupViewService.itemView1();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemView", itemView);
		return mav;
	}
	@RequestMapping(value="/member/iupcodehelper2.do" ,method = RequestMethod.GET)
	public ModelAndView BOMcodeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		String itemNumber = (String) request.getParameter("itemCode");
		List itemView = iupViewService.itemView2();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemView", itemView);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/addIup.do" ,method = RequestMethod.GET)
	public ModelAndView iupAddMember(@ModelAttribute("iup") iupVO iupVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		System.out.println("url" + path);
		int result = 0;
		result = iupViewService.addIup(iupVO);
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/delIup.do" ,method = RequestMethod.GET)
	public ModelAndView iupDelMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no");
		String viewName = getViewName(request);
		String[] numberary = number.split(",");
		iupViewService.delIup(numberary);
		ModelAndView mav = new ModelAndView("redirect:/member/regbom.do");
		return mav;
	}
	
	/*
	 * @Override
	 * 
	 * @RequestMapping(value="/member/updateBOM.do" ,method = RequestMethod.GET)
	 * public ModelAndView iupUpdateMember(@ModelAttribute("iup") iupVO iupVO,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception{
	 * request.setCharacterEncoding("utf-8"); int result = 0; result =
	 * iupViewService.updateIup(iupVO); System.out.println("result "+result);
	 * ModelAndView mav = new ModelAndView("redirect:/member/itemunitprice.do");
	 * return mav; }
	 */
		
	private String getViewName(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}
}