package com.myspring.salesmanage.salesplan.sta.controller;

import java.sql.Date;
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


import com.myspring.salesmanage.itemview.vo.ItemViewVO;
import com.myspring.salesmanage.salesplan.sta.service.SalesplanStaService;

@Controller("salesplanStaController")
public class SalesplanStaControllerImpl implements SalesplanStaController {

	private static final Logger logger = LoggerFactory.getLogger(SalesplanStaControllerImpl.class);
	
	@Autowired(required=false)
	private SalesplanStaService salesplanService;
	@Autowired
	private ItemViewVO itemviewVO;
	
	@Override
	@RequestMapping(value="/sales_manage/popItem.do" ,method = RequestMethod.GET)
	public ModelAndView listAllItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		System.out.println("dididi1");
		List allItemList = salesplanService.listItems();
		System.out.println("dididi2");
		ModelAndView mav = new ModelAndView(viewName);
		System.out.println("dididi3");
		mav.addObject("allItemList", allItemList);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/salesplanstat.do" ,method = RequestMethod.GET)
	public ModelAndView submitItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String code = (String)request.getParameter("item_code");
		String submit = (String)request.getParameter("submit");
		int sum = 0;
		
		if(code == null || code.length() == 0) {
			mav = new ModelAndView(viewName);
			return mav;
		}

			List itemRe = salesplanService.submitItem(code);
			
			mav = new ModelAndView(viewName);
			mav.addObject("itemRe", itemRe);//salesplanVO

		return mav;
	}

	private String getViewName(HttpServletRequest request)  throws Exception{
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