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

//ȸ����
@Controller("SystemmagController")
public class SystemmagControllerImpl implements SystemmagController {
	@Autowired
	private SystemmagService systemmagService;
	@Autowired
	private SystemmagVO systemmagVO;
	@Autowired
	private SystemmagDAO systemmagDAO;

	//ȸ����
	@Override //@modelAttribute ����? �Ű�����
	@RequestMapping(value="/member/addbasicacc.do" ,method = RequestMethod.GET)
	public ModelAndView addCustomer(@ModelAttribute("company") SystemmagVO systemmagVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("��Ϻα������Դϴ�.");
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		System.out.println("url" + path);
		int result = 0;
		result = systemmagService.addCustomer(systemmagVO);
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}
	
	// ��ȸ
	@Override
	@RequestMapping(value = "/member/regbasicacc.do", method = RequestMethod.GET)
	public ModelAndView viewCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		
		String submit = (String) request.getParameter("submit"); //ù�������� üũ�ϴ� ������ , url�� �Ѿ��
		String code = (String) request.getParameter("com_code"); //���° ������� üũ�ϴ� ������, url�� �Ѿ��
		String zipCode = (String) request.getParameter("zipCode");

		if (code == null || submit == null) { //ù�����̶��?
			List comView = systemmagService.viewAllCustomer(); //select all ������ ȣ���Ѵ�
			mav = new ModelAndView(viewName);
			mav.addObject("comView", comView);
			return mav;
		}

		if (submit.equals("1")) { //����� ����������, �� ��ȸ�� ������
			List comView = systemmagService.viewAllCustomer(); //select����
			List comcom = systemmagService.viewCustomer(code); //where���� �߰��Ѵ�
			mav = new ModelAndView(viewName);
			mav.addObject("comView", comView);
			mav.addObject("comcom", comcom);
		}
		else if(submit.equals("2")) {
			List comView = systemmagService.viewAllCustomer();
			List comcom = systemmagService.viewCustomer(code);
//			List zipView = systemmagService.ZipView();
			
			mav = new ModelAndView(viewName);
			mav.addObject("comView", comView);
			mav.addObject("comcom",comcom);
//			mav.addObject("zipView", zipView);
			mav.addObject("zipCode", zipCode);
			
			System.out.println("zipcode:" + zipCode);
			System.out.println("comcode:"+ code);
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

	@Override
	@RequestMapping(value = "/member/deleteBasicacc.do", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no"); //üũ���� üũ�ڽ��� ������ �������� ������
		String viewName = getViewName(request);
		String[] numberary = number.split(","); //��ǥ�� �������� ������ �迭�� �����Ѵ�

		systemmagService.delCustomer(numberary);

		ModelAndView mav = new ModelAndView("redirect:/member/regbasicacc.do");

		return mav;

	}

	@Override
	@RequestMapping(value = "/member/updateBasicacc.do", method = RequestMethod.GET)
	public ModelAndView updateCustomer(@ModelAttribute("") SystemmagVO systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		systemmagService.updCustomer(systemmagVO);//������Ʈ�� ������Ʈ�Լ��� �Ű�������  VO��������
		ModelAndView mav = new ModelAndView(
				"redirect:/member/regbasicacc.do?submit=1&&com_code=" + systemmagVO.getGeneral_Customer_Code());
		return mav;
	}


	
	 @Override	 
	 @RequestMapping(value="/member/regbasicaccPopup.do", method =
	 RequestMethod.GET) public ModelAndView popupCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 request.setCharacterEncoding("utf-8"); 
		 ModelAndView mav = null; 
		 String viewName = getViewName(request); 
		 
		 List comView = systemmagService.viewAllCustomer(); //select * ����ȣ���Ѵ���
		 mav = new ModelAndView(viewName);
		 mav.addObject("comView", comView); //�˾����� ������
	 	 
		 return mav; 
	 }
	 
	
	 @Override	 
	 @RequestMapping(value="/member/regbasicaccZipPopup.do", method =
	 RequestMethod.GET) public ModelAndView popupZipCustomer(@ModelAttribute("") SystemmagVO systemmagVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		 request.setCharacterEncoding("utf-8"); 
		 ModelAndView mav = null; 
		 String viewName = getViewName(request); 
		 String com_code = request.getParameter("com_code");
		 System.out.println("com_code="+com_code);
		 
		 List ZipView = systemmagService.zipViewCustomer(); //select * ����ȣ���Ѵ���
		 mav = new ModelAndView(viewName);
		 mav.addObject("ZipView", ZipView); //�˾����� ������
		 return mav; 
	 }
	 
}
