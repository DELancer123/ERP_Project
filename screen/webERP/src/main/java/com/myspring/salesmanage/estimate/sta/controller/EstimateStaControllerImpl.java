package com.myspring.salesmanage.estimate.sta.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.salesmanage.estimate.service.EstimateService;
import com.myspring.salesmanage.estimate.vo.EstimateVO;

@Controller("estimateStaController")
public class EstimateStaControllerImpl implements EstimateStaController{
	private static final Logger logger = LoggerFactory.getLogger(EstimateStaControllerImpl.class);
	
	@Autowired
	private EstimateService estimateService;	
	@Autowired
	private EstimateVO estimateVO;

	@Override
	@RequestMapping(value="/business_status/pop/popEstCust.do" ,method = RequestMethod.GET)
	public ModelAndView listCust(EstimateVO estimateVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {		
		
		String viewName = getViewName(request);
//		logger.info("viewName: "+ viewName);
//		logger.debug("viewName: "+ viewName);
		List allCustList = estimateService.listCust();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allCustList", allCustList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/quotationstatus.do" ,method = RequestMethod.GET)
	public ModelAndView submitEst(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String code = (String)request.getParameter("custCode");
		
		if(code == null || code.length() == 0) {
			mav = new ModelAndView(viewName);
			return mav;
		}

			List estList = estimateService.submitCust(code);
						
			mav = new ModelAndView(viewName);
			mav.addObject("estList", estList);
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
