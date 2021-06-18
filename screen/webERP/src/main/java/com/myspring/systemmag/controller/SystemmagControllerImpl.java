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
import com.myspring.systemmag.vo.DepartmentVO;
import com.myspring.systemmag.vo.ItemgVO;
import com.myspring.systemmag.vo.SystemmagVO;
import com.myspring.systemmag.vo.WorkplaceVO;
import com.myspring.systemmag.vo.itemVO;

@Controller("SystemmagController")
public class SystemmagControllerImpl implements SystemmagController{
	@Autowired
	private SystemmagService systemmagService;
	@Autowired
	private SystemmagVO systemmagVO;
	
	//회사등록
	@Override
	@RequestMapping(value="/member/addcompany.do" ,method = RequestMethod.GET)
	public ModelAndView addCompany(@ModelAttribute("company") SystemmagVO systemmagVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		System.out.println("url" + path);
		int result = 0;
		result = systemmagService.addCom(systemmagVO);
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}
	//회사등록 조회
	@Override
	@RequestMapping(value="/member/regcompany.do" ,method = RequestMethod.GET)
	public ModelAndView viewCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit");
		String code = (String) request.getParameter("com_code");
		if(code == null || submit == null) {
			List comView = systemmagService.comView();
			mav = new ModelAndView(viewName);
			mav.addObject("comView", comView);
			return mav;
		}
		if(submit.equals("1")) {
			List comView = systemmagService.comView();
			List comcom = systemmagService.comcom(code);
			mav = new ModelAndView(viewName);
			mav.addObject("comView", comView);
			mav.addObject("comcom",comcom);
			
		}
		
		return mav;
	}
	
	//사업장등록
	@Override
	@RequestMapping(value="/member/addbusiness.do" ,method = RequestMethod.GET)
	public ModelAndView addWorkplace(@ModelAttribute("workplace") WorkplaceVO workplaceVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		System.out.println("url" + path);
		int result = 0;
		result = systemmagService.addWor(workplaceVO);
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}
	
	//사업장등록 조회
	@Override
	@RequestMapping(value="/member/regbusiness.do" ,method = RequestMethod.GET)
	public ModelAndView viewWorkplace(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit");
		String code = (String) request.getParameter("wor_code");
		if(code == null || submit == null) {
			List worView = systemmagService.worView();
			mav = new ModelAndView(viewName);
			mav.addObject("worView", worView); 
			return mav;
		}
		if(submit.equals("1")) {
			List worView = systemmagService.worView();
			List worcom = systemmagService.worcom(code);
			mav = new ModelAndView(viewName);
			mav.addObject("worView", worView);
			mav.addObject("worcom",worcom);
		}
		
		return mav;
	}
		//품목등록(조회)
		@Override
		@RequestMapping(value="/member/regitem.do" ,method = RequestMethod.GET)
		public ModelAndView viewItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView mav = null;
			String viewName = getViewName(request);
			String submit = (String) request.getParameter("submit");
			String code = (String) request.getParameter("item_code");
			if(code == null || submit == null) {
				List itemView = systemmagService.itemView();
				mav = new ModelAndView(viewName);
				mav.addObject("itemView", itemView);
				return mav;
			}
			if(submit.equals("1")) {
				List itemView = systemmagService.itemView();
				List comitem = systemmagService.comitem(code);
				mav = new ModelAndView(viewName);
				mav.addObject("itemView", itemView);
				mav.addObject("comitem",comitem);
				
			}
			
			return mav;
		}
		//품목등록
		@Override
		@RequestMapping(value="/member/additem.do" ,method = RequestMethod.GET)
		public ModelAndView addItem(@ModelAttribute("item") itemVO itemVO, HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			request.setCharacterEncoding("utf-8");
			String path = request.getParameter("path");
			path = path.replace("/webERP", "");
			System.out.println("url" + path);
			int result = 0;
			result = systemmagService.addItem(itemVO);
			ModelAndView mav = new ModelAndView("redirect:"+path);
			return mav;
		}
		//품목군등록(조회)
		@Override
		@RequestMapping(value="/member/regitemgroup.do" ,method = RequestMethod.GET)
		public ModelAndView viewItemg(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView mav = null;
			String viewName = getViewName(request);
				List itemgView = systemmagService.itemgView();
				mav = new ModelAndView(viewName);
				mav.addObject("itemgView", itemgView);
				return mav;
		}
		//품목군등록
		@Override
		@RequestMapping(value="/member/additemg.do" ,method = RequestMethod.GET)
		public ModelAndView addItemg(@ModelAttribute("itemg") ItemgVO itemgVO, HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			request.setCharacterEncoding("utf-8");
			String path = request.getParameter("path");
			path = path.replace("/webERP", "");
			System.out.println("url" + path);
			int result = 0;
			result = systemmagService.addItemg(itemgVO);
			ModelAndView mav = new ModelAndView("redirect:"+path);
			return mav;
		}
		//사원조회
		@Override
		@RequestMapping(value="/member/inquiryemployees.do" ,method = RequestMethod.GET)
		public ModelAndView viewemployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView mav = null;
			String viewName = getViewName(request);
				List employeeView = systemmagService.employeeView();
				mav = new ModelAndView(viewName);
				mav.addObject("employeeView", employeeView);
				return mav;
		}
		//부서등록(조회)
		@Override
		@RequestMapping(value="/member/regdepartment.do" ,method = RequestMethod.GET)
		public ModelAndView viewdepartment(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ModelAndView mav = null;
			String viewName = getViewName(request);
				List departmentView = systemmagService.departmentView();
				mav = new ModelAndView(viewName);
				mav.addObject("departmentView", departmentView);
				return mav;
		}
		//부서등록
		@Override
		@RequestMapping(value="/member/adddepartment.do" ,method = RequestMethod.GET)
		public ModelAndView adddepartment(@ModelAttribute("department") DepartmentVO departmentVO, HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			request.setCharacterEncoding("utf-8");
			String path = request.getParameter("path");
			path = path.replace("/webERP", "");
			System.out.println("url" + path);
			int result = 0;
			result = systemmagService.addDep(departmentVO);
			ModelAndView mav = new ModelAndView("redirect:"+path);
			return mav;
		}
	//겟뷰네임
	
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
	@Override
	public ModelAndView delCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
	@Override
	public ModelAndView adressZip(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
	
	
	@Override
	public ModelAndView updWorkplace(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
	@Override
	public ModelAndView delWorkplace(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return null;
	}
	
	
}

