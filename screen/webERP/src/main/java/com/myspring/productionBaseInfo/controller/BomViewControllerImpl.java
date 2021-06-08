package com.myspring.productionBaseInfo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.productionBaseInfo.service.*;
import com.myspring.productionBaseInfo.BOM.vo.*;



@Controller("memberController")
//@EnableAspectJAutoProxy
public class BomViewControllerImpl implements BomViewController {
	private static final Logger logger = LoggerFactory.getLogger(BomViewControllerImpl.class);
	@Autowired
	private BomViewService viewService;
	@Autowired
	private bomVO bomVO ;
	
	@Override
	@RequestMapping(value="/member/regbom.do" ,method = RequestMethod.GET)
	public ModelAndView viewBOM(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String number = (String) request.getParameter("itemNumber");
		String submit = (String) request.getParameter("submit");
		String itemNumber = (String) request.getParameter("itemCode");
		if(number == null || number.length() == 0 || submit.equals("0")) {
			mav = new ModelAndView(viewName);
			return mav;
		}
		else if(submit.equals("1")){
			List bomView = viewService.SearchView(number);
			System.out.println("아이템코드:" + number);
			mav = new ModelAndView(viewName);
			mav.addObject("bomView", bomView);
			return mav;
		}
		else if(submit.equals("2")) {
			List bomView = viewService.SearchView(number);
			List bomInsert = viewService.setText(itemNumber);
			mav = new ModelAndView(viewName);
			mav.addObject("bomView", bomView);
			mav.addObject("bomInsert",bomInsert);
			return mav;
		}
		return mav;
		 
			
		
	}
	
	@RequestMapping(value="/member/codehelper.do" ,method = RequestMethod.GET)
	public ModelAndView codeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List itemView = viewService.itemView();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemView", itemView);
		return mav;
	}
	@RequestMapping(value="/member/bomcodehelper.do" ,method = RequestMethod.GET)
	public ModelAndView BOMcodeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List itemView = viewService.itemView();
		/* List itemSet = viewService.itemSet(); */
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemView", itemView);
		/* mav.addObject("itemSet", itemSet); */
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/addBOM.do" ,method = RequestMethod.GET)
	public ModelAndView addMember(@ModelAttribute("bom") bomVO bomVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(bomVO.getItemNumber());
		String number = (String) request.getParameter("itemNumber");
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = viewService.addBOM(bomVO);
		ModelAndView mav;
		List bomView = viewService.SearchView(number);
		mav = new ModelAndView("member/regbom.do");
		mav.addObject("bomView", bomView);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/updateBOM.do" ,method = RequestMethod.GET)
	public ModelAndView updateMember(@ModelAttribute("bom") bomVO bomVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("item_name bef:"+bomVO.getItemName());
		request.setCharacterEncoding("utf-8");
		String viewName = getViewName(request);
		List itemUpdate = viewService.itemView();
		System.out.println("item_name aft:"+bomVO.getItemName());
		StringBuffer url = request.getRequestURL();
		int result = 0;
		result = viewService.updateBOM(bomVO);
		System.out.println(result);
		String resulturl = url.toString();
		ModelAndView mav = new ModelAndView("redirect:/member/regBOM.do");
		mav.addObject("itemUpdate", itemUpdate);
		System.out.println("itemUpdate:"+itemUpdate);
		return mav;
	}
	
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
