package com.myspring.systemmag.controller;

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

import com.myspring.systemmag.service.SystemmagService;
import com.myspring.systemmag.vo.SystemmagVO;
//»∏ªÁµÓ∑œ
@Controller("SystemmagController")
public class SystemmagControllerImpl implements SystemmagController{
	@Autowired
	private SystemmagService systemmagService;
	@Autowired
	private SystemmagVO systemmagVO;
	@Override
	@RequestMapping(value="/member/addcompany.do")
	public ModelAndView addCompany(SystemmagVO company, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(systemmagVO.getCompany_Code());
		request.setCharacterEncoding("utf-8");
		StringBuffer url = request.getRequestURL();
		int result = 0;
		result = systemmagService.addCompany(systemmagVO);
		String resulturl = url.toString();
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	//¡∂»∏
	@Override
	@RequestMapping(value="/member/regcompany.do" ,method = RequestMethod.GET)
	public ModelAndView viewCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);

			List comView = systemmagService.comView();
			mav = new ModelAndView(viewName);
			mav.addObject("comView", comView);
		
		return mav;
	}
	@Override
	@RequestMapping(value = "/member/regbasicacc", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		String viewName = getViewName(request);

        ModelAndView mav = new ModelAndView(viewName);
        
        String homeView = systemmagService.home();
        System.out.println(homeView);
        mav.addObject("homeView", homeView);
        
        testy();
        
		
        
        return mav; // ∫‰ ∆ƒ¿œ ∏Æ≈œ
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
	
	public List testy() {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<10;i++) {
			list.add("≥»≥»"+i);
		}
		System.out.println(list.size());
		System.out.println(list.get(3));
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		return null;
	}
	
	


		
}


