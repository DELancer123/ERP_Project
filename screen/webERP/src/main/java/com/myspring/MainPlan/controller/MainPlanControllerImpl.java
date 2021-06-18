package com.myspring.MainPlan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.MainPlan.service.MainPlanService;
import com.myspring.MainPlan.vo.MainPlanVO;
import com.myspring.commonProduction.operationRegist.vo.OperationRegistVO;

@Controller("mainplanController")
public class MainPlanControllerImpl implements MainPlanController {
	private static final Logger logger = LoggerFactory.getLogger(MainPlanControllerImpl.class);
	@Autowired
	private MainPlanService mainplanService;
	@Autowired
	private MainPlanVO mainplanVO;

	@Override
	@RequestMapping(value = "member/mainplan.do", method = RequestMethod.GET)
	public ModelAndView listMainPlan(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List mainplanList = mainplanService.selectAllMainPlanList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("mainplanList", mainplanList);
		return mav;
	}

	@Override
	@RequestMapping(value = "member/applyorder.do", method = RequestMethod.GET)
	public ModelAndView MpsOSList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		List mpsosList = mainplanService.selectAllMpsosList();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("mpsosList", mpsosList);
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/delMps.do", method = RequestMethod.GET)
	public ModelAndView delMps(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("planNO");
		String viewName = getViewName(request);
		String[] noary  = number.split(",");
		mainplanService.delMps(noary);
		ModelAndView mav = new ModelAndView("redirect:/member/mainplan.do");
		return mav;
	}	
	
	@Override
	@RequestMapping(value = "/member/addMPS.do", method = RequestMethod.GET)
	public ModelAndView addMPS(@ModelAttribute("mainplanList") MainPlanVO vo,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		System.out.println("url" + path);
		int result = 0;
		result = mainplanService.addMPS(vo);
		ModelAndView mav = new ModelAndView("redirect:" + path);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/updateMPS.do" ,method = RequestMethod.GET)
	public ModelAndView updateMPS(@ModelAttribute("mainplan") MainPlanVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = mainplanService.updateMPS(vo);
		System.out.println("result "+result);
		ModelAndView mav = new ModelAndView("redirect:/member/mainplan.do");
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
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
