package com.myspring.MainPlan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.MainPlan.MpsOS.vo.MpsOSVO;
import com.myspring.MainPlan.service.MainPlanService;
import com.myspring.MainPlan.vo.MainPlanVO;

@Controller("mainplanController")
public class MainPlanControllerImpl implements MainPlanController {
	private static final Logger logger = LoggerFactory.getLogger(MainPlanControllerImpl.class);
	@Autowired
	private MainPlanService mainplanService;
	@Autowired
	private MainPlanVO mainplanVO;

//	@Override
//	@RequestMapping(value = "member/mainplan.do", method = RequestMethod.GET)
//	public ModelAndView listMainPlan(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String startDate = request.getParameter("startDate");
//		String endDate = request.getParameter("endDate");
//		String viewName = (String) request.getAttribute("viewName");
//		  logger.debug("debug : viewName = " + viewName); 
//		List mainplanList = mainplanService.selectAllMainPlanList(startDate, endDate);
//		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("mainplanList", mainplanList);
//		return mav;
//	}
	
	@Override
	@RequestMapping(value="/member/mainplan.do" ,method = RequestMethod.GET)
	public ModelAndView viewMPS(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			List bomView = mainplanService.SearchView(number);
			
			mav = new ModelAndView(viewName);
			
			mav.addObject("bomView", bomView);
		}
		else if(submit.equals("2")) {
			List MPSView = mainplanService.SearchView(number);
			List MPSInsert = mainplanService.setText(itemNumber);
			mav = new ModelAndView(viewName);
			mav.addObject("MPSView", MPSView);
			mav.addObject("MPSInsert",MPSInsert);
			int inputSeq = mainplanService.inputSeq();
			String inNo = Integer.toString(inputSeq+1);
			request.setAttribute("inputSeq", inputSeq);
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "member/applyorder.do", method = RequestMethod.GET)
	public ModelAndView MpsOSList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String startDate = request.getParameter("dateStart");
		String endDate = request.getParameter("dateEnd");
		String viewName = (String) request.getAttribute("viewName");
		List mpsosList = mainplanService.selectAllMpsosList(startDate, endDate);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("mpsosList", mpsosList);
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/delMps.do", method = RequestMethod.GET)
	public ModelAndView delMps(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = (String) request.getParameter("sequence");
		String viewName = getViewName(request);
		String[] numberary  = no.split(",");
		mainplanService.delMps(numberary);
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

	@ResponseBody
	@RequestMapping(value = "/member/searchMPSOS.do", method = RequestMethod.GET)
	public ModelAndView searchPopName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<MpsOSVO> popName = null;
		popName = mainplanService.searchMPSOS(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

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
