package com.myspring.salesmanage.pop.custview.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.salesmanage.pop.custview.service.CustViewService;
import com.myspring.salesmanage.pop.custview.vo.CustViewVO;

@Controller("custviewController")
public class CustViewControllerImpl implements CustViewController{

	private static final Logger logger = LoggerFactory.getLogger(CustViewControllerImpl.class);
	
	@Autowired
	private CustViewService service;
	
	@Autowired
	private CustViewVO custViewVO;

	@Override
	@RequestMapping(value="/sales_manage/popCust.do" ,method = RequestMethod.GET)
	public ModelAndView listAllCust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
//		String viewName = (String)request.getAttribute("viewName");
		//System.out.println("viewName: " +viewName);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		List allCustsList = service.listCusts();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allCustsList", allCustsList);
		return mav;
	}



	@Override
	@RequestMapping(value="/sales_manage/addCust.do" ,method = RequestMethod.GET)
	public ModelAndView addCust(CustViewVO custviewVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = service.addCust(custviewVO);
		ModelAndView mav = new ModelAndView("redirect:/sales_manage/popCust.do");
		return mav;
	}



	@Override
	@RequestMapping(value="/sales_manage/removeCust.do" ,method = RequestMethod.GET)
	public ModelAndView removeCust(String custCode, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		service.removeCust(custCode);
			ModelAndView mav = new ModelAndView("redirect:/sales_manage/popCust.do");
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
