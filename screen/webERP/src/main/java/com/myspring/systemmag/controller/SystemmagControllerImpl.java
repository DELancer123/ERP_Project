package com.myspring.systemmag.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.systemmag.dao.SystemmagDAO;
import com.myspring.systemmag.service.SystemmagService;
import com.myspring.systemmag.vo.SystemmagVO;

//회사등록
@Controller("SystemmagController")
public class SystemmagControllerImpl implements SystemmagController {
	@Autowired
	private SystemmagService systemmagService;
	@Autowired
	private SystemmagVO systemmagVO;
	@Autowired
	private SystemmagDAO systemmagDAO;
	
	//일반거래처등록-등록
	@Override
	@RequestMapping(value="/member/addbasicacc.do" ,method = RequestMethod.GET)
	public ModelAndView addCustomer(@ModelAttribute("company") SystemmagVO systemmagVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {		
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		System.out.println("url" + path);
		int result = 0;
		result = systemmagService.addCustomer(systemmagVO);
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}
	
	//일반거래처등록-조회
	@Override
	@RequestMapping(value = "/member/regbasicacc.do", method = RequestMethod.GET)
	public ModelAndView viewCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);	
		String submit = (String) request.getParameter("submit"); //첫접속인지 체크하는 변수임 , url로 넘어옴
		String code = (String) request.getParameter("com_code"); //몇번째 목록인지 체크하는 변수임, url로 넘어옴
		String zipCode = (String) request.getParameter("zipCode");
		String customerCode = (String) request.getParameter("customerCode");//검색부의값을 겟파라미터로 가져옴
		
		System.out.println("viewName:"+viewName);
		System.out.println("customerCode:"+customerCode);
		System.out.println("submit:"+submit);
		
		if (code == null && submit == null  && customerCode == null) { //첫접속이라면?
			System.out.println("1번분기들어옴");
			List comView = systemmagService.viewAllCustomer(); //select all 쿼리를 호출한다
			mav = new ModelAndView(viewName);
			mav.addObject("comView", comView);
			return mav;
		}

		else if (submit != null) { //목록을 선택했을때, 즉 조회를 했을때
			System.out.println("2번분기들어옴");
			List comView = systemmagService.viewAllCustomer(); //select문에
			List comcom = systemmagService.viewCustomer(code); //where절을 추가한다
			mav = new ModelAndView(viewName);
			mav.addObject("comView", comView);
			mav.addObject("comcom", comcom);
		}
		else if (customerCode != null && submit == null) {
			System.out.println("3번분기들어옴");
			System.out.println("customerCode:"+customerCode);
			System.out.println("viewName:"+viewName);
			List comView = systemmagService.searchCustomer(customerCode);
			mav = new ModelAndView("/member/regbasicacc");
			mav.addObject(comView);
			System.out.println("size:"+comView.size());
		}
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
	
	//일반거래처등록-삭제
	@Override
	@RequestMapping(value = "/member/deleteBasicacc.do", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no"); //체크가된 체크박스의 값들을 가져오는 변수임
		String viewName = getViewName(request);
		String[] numberary = number.split(","); //쉼표를 기준으로 나누어 배열에 저장한다

		systemmagService.delCustomer(numberary);

		ModelAndView mav = new ModelAndView("redirect:/member/regbasicacc.do");

		return mav;

	}
	
	//일반거래처등록-수정
	@Override
	@RequestMapping(value = "/member/updateBasicacc.do", method = RequestMethod.GET)
	public ModelAndView updateCustomer(@ModelAttribute("") SystemmagVO systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		systemmagService.updCustomer(systemmagVO);//서비스파트의 업데이트함수에 매개변수로  VO를전달함
		ModelAndView mav = new ModelAndView(
				"redirect:/member/regbasicacc.do?submit=1&&com_code=" + systemmagVO.getGeneral_Customer_Code());
		return mav;
	}


	 //일반거래처등록-팝업
	 @Override	 
	 @RequestMapping(value="/member/regbasicaccPopup.do", method =
	 RequestMethod.GET) public ModelAndView popupCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 request.setCharacterEncoding("utf-8"); 
		 ModelAndView mav = null; 
		 String viewName = getViewName(request); 
		 
		 List comView = systemmagService.viewAllCustomer(); //select * 문을호출한다음
		 mav = new ModelAndView(viewName);
		 mav.addObject("comView", comView); //팝업으로 전달함
	 	 
		 return mav; 
	 }
	 
	 //일반거래처등록-우편번호팝업
	 @Override	 
	 @RequestMapping(value="/member/regbasicaccZipPopup.do", method =
	 RequestMethod.GET) public ModelAndView popupZipCustomer(@ModelAttribute("") SystemmagVO systemmagVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		 request.setCharacterEncoding("utf-8"); 
		 ModelAndView mav = null; 
		 String viewName = getViewName(request); 
		 String com_code = request.getParameter("com_code");
		 System.out.println("com_code="+com_code);
		 
		 List ZipView = systemmagService.zipViewCustomer(); //select * 문을호출한다음
		 mav = new ModelAndView(viewName);
		 mav.addObject("ZipView", ZipView); //팝업으로 전달함
		 return mav; 
	 }
	 
	//창고/공정/외주공정등록-조회
	@Override
	@RequestMapping(value = "/member/outware.do", method = RequestMethod.GET)
	public ModelAndView viewOutware(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);	
		String submit = (String) request.getParameter("submit"); //첫접속인지 체크하는 변수임 , url로 넘어옴
		String code = (String) request.getParameter("com_code"); //몇번째 목록인지 체크하는 변수임, url로 넘어옴
		String zipCode = (String) request.getParameter("zipCode");
		String customerCode = (String) request.getParameter("customerCode");//검색부의값을 겟파라미터로 가져옴
		
		System.out.println("viewName:"+viewName);
		System.out.println("customerCode:"+customerCode);
		System.out.println("submit:"+submit);
		
		if (code == null || submit == null) { //첫접속이라면?
			System.out.println("1번분기들어옴");
			List comView = systemmagService.viewAllOutware(); //select all 쿼리를 호출한다
			mav = new ModelAndView(viewName);
			mav.addObject("comView", comView);
			return mav;
		}

//		else if (submit != null) { //목록을 선택했을때, 즉 조회를 했을때
//			System.out.println("2번분기들어옴");
//			List comView = systemmagService.viewAllCustomer(); //select문에
//			List comcom = systemmagService.viewCustomer(code); //where절을 추가한다
//			mav = new ModelAndView(viewName);
//			mav.addObject("comView", comView);
//			mav.addObject("comcom", comcom);
//		}
//		else if (customerCode != null && submit == null) {//검색했을때
//			System.out.println("3번분기들어옴");
//			System.out.println("customerCode:"+customerCode);
//			System.out.println("viewName:"+viewName);
//			List comView = systemmagService.searchCustomer(customerCode);
//			mav = new ModelAndView("/member/regbasicacc");
//			mav.addObject(comView);
//			System.out.println("size:"+comView.size());
//		}
		return mav;
	}
	 
}


