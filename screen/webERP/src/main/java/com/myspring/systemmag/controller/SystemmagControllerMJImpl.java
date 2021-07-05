package com.myspring.systemmag.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.systemmag.dao.SystemmagDAOMJ;
import com.myspring.systemmag.service.SystemmagServiceMJ;
import com.myspring.systemmag.vo.SystemmagVOMJ;

//�쉶�뜝�룞�삕�뜝�룞�삕
@Controller("SystemmagControllerMJ")
public class SystemmagControllerMJImpl implements SystemmagControllerMJ {
	@Autowired
	private SystemmagServiceMJ systemmagService;
	@Autowired
	private SystemmagVOMJ systemmagVO;
	@Autowired
	private SystemmagDAOMJ systemmagDAO;

	// �뜝�떦諛섍굅琉꾩삕泥섇뜝�룞�삕�뜝占�-�뜝�룞�삕�뜝占�
	@Override
	@RequestMapping(value = "/member/addbasicacc.do", method = RequestMethod.GET)
	public ModelAndView addCustomer(@ModelAttribute("company") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		System.out.println("url" + path);
		int result = 0;
		result = systemmagService.addCustomer(systemmagVO);
		ModelAndView mav = new ModelAndView("redirect:" + path);
		return mav;
	}

	// �뜝�떦諛섍굅琉꾩삕泥섇뜝�룞�삕�뜝占�-�뜝�룞�삕�쉶
	@Override
	@RequestMapping(value = "/member/regbasicacc.do", method = RequestMethod.GET)
	public ModelAndView viewCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit"); // 泥ュ뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 泥댄겕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 , url�뜝�룞�삕 �뜝�떬�뼲�삕�뜝占�
		String com_code = (String) request.getParameter("com_code"); // �뜝�룞�삕�뜝�듅占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� 泥댄겕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕, url�뜝�룞�삕 �뜝�떬�뼲�삕�뜝占�
		String customerCode = (String) request.getParameter("customerCode");

		System.out.println("viewName:" + viewName);
		System.out.println("submit:" + submit);
		System.out.println("comcode:"+com_code);
		System.out.println("customercode:"+customerCode);

		if (com_code == null && submit == null) { // 泥ュ뜝�룞�삕�뜝�룞�삕�뜝�떛�씛�삕�뜝占�?
			if(customerCode != null) {				
				System.out.println("3�뜝�룞�삕�뜝�떩源띿삕�뜝�룞�삕�뜝占�");
				System.out.println("customerCode:"+customerCode);
				List customerList = null;
				List comcom = null;
				customerList = systemmagService.viewCustomer(customerCode);
				comcom = systemmagService.viewCustomer(customerCode);
				mav = new ModelAndView(viewName);
				mav.addObject("comView", customerList);	
				mav.addObject("comcom", comcom);
				return mav;
			}
			else {
				System.out.println("1�뜝�룞�삕�뜝�떩源띿삕�뜝�룞�삕�뜝占�");
				List comView = systemmagService.viewAllCustomer(); // select all �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �샇�뜝�룞�삕�뜝�떬�뙋�삕
				mav = new ModelAndView(viewName);
				mav.addObject("comView", comView);
				return mav;
			}
		}

		else if (submit.equals("1")) { // �뜝�룞�삕�뜝�룞�삕�뜝占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕, �뜝�룞�삕 �뜝�룞�삕�쉶�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
			System.out.println("2�뜝�룞�삕�뜝�떩源띿삕�뜝�룞�삕�뜝占�");
			List comView = systemmagService.viewAllCustomer(); // select�뜝�룞�삕�뜝�룞�삕
			List comcom = systemmagService.viewCustomer(com_code); // where�뜝�룞�삕�뜝�룞�삕 �뜝�뙥怨ㅼ삕�뜝�떬�뙋�삕
			System.out.println("comViewSize:"+comView.size());
			System.out.println("comcomSize:"+comcom.size());
			mav = new ModelAndView(viewName);
			mav.addObject("comView", comView);
			mav.addObject("comcom", comcom);
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

	// �뜝�떦諛섍굅琉꾩삕泥섇뜝�룞�삕�뜝占�-�뜝�룞�삕�뜝�룞�삕
	@Override
	@RequestMapping(value = "/member/deleteBasicacc.do", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no"); // 泥댄겕�뜝�룞�삕�뜝�룞�삕 泥댄겕�뜝�뙓�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
		String viewName = getViewName(request);
		String[] numberary = number.split(","); // �뜝�룞�삕�몴�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�띁�뿴�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�떬�뙋�삕

		systemmagService.delCustomer(numberary);

		ModelAndView mav = new ModelAndView("redirect:/member/regbasicacc.do");

		return mav;

	}

	// �뜝�떦諛섍굅琉꾩삕泥섇뜝�룞�삕�뜝占�-�뜝�룞�삕�뜝�룞�삕
	@Override
	@RequestMapping(value = "/member/updateBasicacc.do", method = RequestMethod.GET)
	public ModelAndView updateCustomer(@ModelAttribute("") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		systemmagService.updCustomer(systemmagVO);// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�듃�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�듃�뜝�뙃�눦�삕�뜝�룞�삕 �뜝�떊怨ㅼ삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 VO�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
		ModelAndView mav = new ModelAndView(
				"redirect:/member/regbasicacc.do?submit=1&&com_code=" + systemmagVO.getGeneral_Customer_Code());
		return mav;
	}

	// �뜝�떦諛섍굅琉꾩삕泥섇뜝�룞�삕�뜝占�-�뜝�떙�뼲�삕
	@Override
	@RequestMapping(value = "/member/regbasicaccPopup.do", method = RequestMethod.GET)
	public ModelAndView popupCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List comView = systemmagService.viewAllCustomer(); // select * �뜝�룞�삕�뜝�룞�삕�샇�뜝�룞�삕�뜝�떬�뙋�삕�뜝�룞�삕
		mav = new ModelAndView(viewName);
		mav.addObject("comView", comView); // �뜝�떙�뼲�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕

		return mav;
	}

	// �뜝�떦諛섍굅琉꾩삕泥섇뜝�룞�삕�뜝占�-�뜝�룞�삕�뜝�룞�삕�뜝�떕節륁삕浴뉐뜝占�
	@Override
	@RequestMapping(value = "/member/regbasicaccZipPopup.do", method = RequestMethod.GET)
	public ModelAndView popupZipCustomer(@ModelAttribute("") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String com_code = request.getParameter("com_code");
		System.out.println("com_code=" + com_code);

		List ZipView = systemmagService.zipViewCustomer(); // select * �뜝�룞�삕�뜝�룞�삕�샇�뜝�룞�삕�뜝�떬�뙋�삕�뜝�룞�삕
		mav = new ModelAndView(viewName);
		mav.addObject("ZipView", ZipView); // �뜝�떙�뼲�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
		return mav;
	}

	// 李썲뜝�룞�삕/�뜝�룞�삕�뜝�룞�삕/�뜝�룞�삕�뜝�뙇怨ㅼ삕�뜝�룞�삕�뜝�룞�삕�뜝占�-�뜝�룞�삕�쉶
	@Override
	@RequestMapping(value = "/member/outware.do", method = RequestMethod.GET)
	public ModelAndView viewOutware(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit"); // 泥ュ뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 泥댄겕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 , url�뜝�룞�삕 �뜝�떬�뼲�삕�뜝占�
		String code = (String) request.getParameter("com_code"); // �뜝�룞�삕�뜝�듅占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� 泥댄겕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕, url�뜝�룞�삕 �뜝�떬�뼲�삕�뜝占�
		String outwareCode = (String) request.getParameter("outwareCode");
		String processCode = (String) request.getParameter("processCode");
		String outsourcingCode = (String) request.getParameter("outsourcingCode");
		System.out.println("outwareCode:"+outwareCode);
		System.out.println("processCode:"+processCode);
		System.out.println("outsourcingCode:"+outsourcingCode);
		if (code == null && submit == null) { // 泥ュ뜝�룞�삕�뜝�룞�삕�뜝�떛�씛�삕�뜝占�?
			System.out.println("1�뜝�룞�삕�뜝�떩源띿삕�뜝�룞�삕�뜝占�");
			List houOutwareList = systemmagService.viewAllHouOutware(); // select all �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �샇�뜝�룞�삕�뜝�떬�뙋�삕
			List proOutwareList = systemmagService.viewAllProOutware();
			List outOutwareList = systemmagService.viewAllOutOutware();

			List houWorOutwareList = systemmagService.viewAllHouWorOutware(); // select all �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �샇�뜝�룞�삕�뜝�떬�뙋�삕
			List proWorOutwareList = systemmagService.viewAllProWorOutware();
			List outWorOutwareList = systemmagService.viewAllOutWorOutware();

			mav = new ModelAndView(viewName);
			if(outwareCode==null) {
				mav.addObject("houOutwareList", houOutwareList);
			}else {
				List  houOutwareSelectedList = systemmagService.viewSelectedHouOutware(outwareCode);
				mav.addObject("houOutwareList", houOutwareSelectedList);
			}
			if(processCode==null) {
				mav.addObject("proOutwareList", proOutwareList);
			}else {
				List  proOutwareSelectedList = systemmagService.viewSelectedProOutware(processCode);
				mav.addObject("proOutwareList", proOutwareSelectedList);
			}
			if(outsourcingCode==null) {
				mav.addObject("outOutwareList", outOutwareList);
			}else {
				List  outOutwareSelectedList = systemmagService.viewSelectedOutOutware(outsourcingCode);
				mav.addObject("outOutwareList", outOutwareSelectedList);
			}
			mav.addObject("houWorOutwareList", houWorOutwareList);
			mav.addObject("proWorOutwareList", proWorOutwareList);
			mav.addObject("outWorOutwareList", outWorOutwareList);
			return mav;
		}

		return mav;
	}
	// 李썲뜝�룞�삕/�뜝�룞�삕�뜝�룞�삕/�뜝�룞�삕�뜝�뙇怨ㅼ삕�뜝�룞�삕�뜝�룞�삕�솴-�뜝�떙�뼲�삕
	@Override
	@RequestMapping(value = "/member/outwarePopup1.do", method = RequestMethod.GET)
	public ModelAndView popupOutware1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List outwareView = systemmagService.viewAllHouOutware(); // select * �뜝�룞�삕�뜝�룞�삕�샇�뜝�룞�삕�뜝�떬�뙋�삕�뜝�룞�삕
		mav = new ModelAndView(viewName);
		mav.addObject("outwareView", outwareView); // �뜝�떙�뼲�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕

		return mav;
	}
	@Override
	@RequestMapping(value = "/member/outwarePopup2.do", method = RequestMethod.GET)
	public ModelAndView popupOutware2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List outwareView = systemmagService.viewAllProOutware(); // select * �뜝�룞�삕�뜝�룞�삕�샇�뜝�룞�삕�뜝�떬�뙋�삕�뜝�룞�삕
		mav = new ModelAndView(viewName);
		mav.addObject("outwareView", outwareView); // �뜝�떙�뼲�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕

		return mav;
	}
	@Override
	@RequestMapping(value = "/member/outwarePopup3.do", method = RequestMethod.GET)
	public ModelAndView popupOutware3(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List outwareView = systemmagService.viewAllOutOutware(); // select * �뜝�룞�삕�뜝�룞�삕�샇�뜝�룞�삕�뜝�떬�뙋�삕�뜝�룞�삕
		mav = new ModelAndView(viewName);
		mav.addObject("outwareView", outwareView); // �뜝�떙�뼲�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕

		return mav;
	}

	// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占�-�뜝�룞�삕�쉶
	@Override
	@RequestMapping(value = "/member/logistics_manage.do", method = RequestMethod.GET)
	public ModelAndView viewLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit"); // 泥ュ뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 泥댄겕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 , url�뜝�룞�삕 �뜝�떬�뼲�삕�뜝占�
		String code = (String) request.getParameter("com_code"); // 泥ュ뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 泥댄겕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 , url�뜝�룞�삕 �뜝�떬�뼲�삕�뜝占�
		String logisSearchBox = (String) request.getParameter("logisSearchBox"); // �뜝�룞�삕�뜝�듅占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� 泥댄겕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕, url�뜝�룞�삕 �뜝�떬�뼲�삕�뜝占�

		System.out.println("viewName:" + viewName);
		System.out.println("submit:" + submit);
		System.out.println("logisSearchBox:"+logisSearchBox);

		if (code == null && submit == null) { // 泥ュ뜝�룞�삕�뜝�룞�삕�뜝�떛�씛�삕�뜝占�?			
			if(logisSearchBox != null) {				
				System.out.println("3�뜝�룞�삕�뜝�떩源띿삕�뜝�룞�삕�뜝占�");
				System.out.println("logisSearchBox:"+logisSearchBox);
				List allLogisticsList = null;
				List logisticsSelectedView = null;
				allLogisticsList = systemmagService.viewSelectedLogistics(logisSearchBox);
				logisticsSelectedView = systemmagService.viewSelectedLogistics(logisSearchBox);
				
				System.out.println("alllogis:"+allLogisticsList.size());
				System.out.println("sellogis:"+logisticsSelectedView.size());
				mav = new ModelAndView(viewName);
				mav.addObject("logisticsView", allLogisticsList);	
				mav.addObject("logisticsSelectedView", logisticsSelectedView);
				return mav;
			}
			else {
				System.out.println("1�뜝�룞�삕�뜝�떩源띿삕�뜝�룞�삕�뜝占�");
				List logisticsView = systemmagService.viewAllLogistics(); // select all �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �샇�뜝�룞�삕�뜝�떬�뙋�삕
				mav = new ModelAndView(viewName);
				mav.addObject("logisticsView", logisticsView);
				return mav;
			}
		}

		else if (submit.equals("1")) { // �뜝�룞�삕�뜝�룞�삕�뜝占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕, �뜝�룞�삕 �뜝�룞�삕�쉶�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
			System.out.println("2�뜝�룞�삕�뜝�떩源띿삕�뜝�룞�삕�뜝占�");
			List logisticsView = systemmagService.viewAllLogistics(); // select�뜝�룞�삕�뜝�룞�삕
			List logisticsSelectedView = systemmagService.viewSelectedLogistics(code); // where�뜝�룞�삕�뜝�룞�삕 �뜝�뙥怨ㅼ삕�뜝�떬�뙋�삕
			mav = new ModelAndView(viewName);
			mav.addObject("logisticsView", logisticsView);
			mav.addObject("logisticsSelectedView", logisticsSelectedView);
		}

		return mav;
	}

	// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占�-�뜝�룞�삕�뜝占�
	@Override
	@RequestMapping(value = "/member/addLogistics_manage.do", method = RequestMethod.GET)
	public ModelAndView addLogistics(@ModelAttribute("logistics") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		System.out.println("url" + path);
		int result = 0;
		result = systemmagService.addLogistics(systemmagVO);
		ModelAndView mav = new ModelAndView("redirect:" + path);
		return mav;
	}

	// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占�-�뜝�룞�삕�뜝�룞�삕
	@Override
	@RequestMapping(value = "/member/deleteLogistics_manage.do", method = RequestMethod.GET)
	public ModelAndView deleteLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no"); // 泥댄겕�뜝�룞�삕�뜝�룞�삕 泥댄겕�뜝�뙓�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
		System.out.println("�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕");
		System.out.println("number:"+number);
		String viewName = getViewName(request);
		String[] numberary = number.split(","); // �뜝�룞�삕�몴�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�띁�뿴�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�떬�뙋�삕

		systemmagService.deleteLogistics(numberary);

		ModelAndView mav = new ModelAndView("redirect:/member/logistics_manage.do");
		return mav;
	}

	// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占�-�뜝�룞�삕�뜝�룞�삕
	@Override
	@RequestMapping(value = "/member/updateLogistics_manage.do", method = RequestMethod.GET)
	public ModelAndView updateLogistics(SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�듃�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕");
		request.setCharacterEncoding("utf-8");
		System.out.println("explanation:"+request.getParameter("explanation"));
		systemmagService.updateLogistics(systemmagVO);// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�듃�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�듃�뜝�뙃�눦�삕�뜝�룞�삕 �뜝�떊怨ㅼ삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 VO�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
		ModelAndView mav = new ModelAndView(
				"redirect:/member/logistics_manage.do?submit=1&&com_code=" + systemmagVO.getLogistics_In_Code());
		return mav;
	}
	

	// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占�-�뜝�떙�뼲�삕
	@Override
	@RequestMapping(value = "/member/logisticsPopup.do", method = RequestMethod.GET)
	public ModelAndView popupLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List logisticsView = systemmagService.viewAllLogistics(); // select * �뜝�룞�삕�뜝�룞�삕�샇�뜝�룞�삕�뜝�떬�뙋�삕�뜝�룞�삕
		mav = new ModelAndView(viewName);
		mav.addObject("logisticsView", logisticsView); // �뜝�떙�뼲�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕

		return mav;
	}
	
	//臾쇰쪟愿�由щ궡�뿭�벑濡�-----------------------------------
	@Override
	@RequestMapping(value = "/member/addInspection.do", method = RequestMethod.GET)
	public ModelAndView addInspection(@ModelAttribute("Ins") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = systemmagService.addInspection(systemmagVO);
		ModelAndView mav = new ModelAndView("redirect:/member/reginspection.do?submit=1&&com_code=" + systemmagVO.getInspection_Code());
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/reginspection.do", method = RequestMethod.GET)
	public ModelAndView viewInspection(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit"); // 泥ュ뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 泥댄겕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 , url�뜝�룞�삕 �뜝�떬�뼲�삕�뜝占�
		String com_code = (String) request.getParameter("com_code"); // �뜝�룞�삕�뜝�듅占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� 泥댄겕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕, url�뜝�룞�삕 �뜝�떬�뼲�삕�뜝占�

		System.out.println("viewName:" + viewName);
		System.out.println("submit:" + submit);
		System.out.println("comcode:"+com_code);

		if (com_code == null && submit == null) { // 泥ュ뜝�룞�삕�뜝�룞�삕�뜝�떛�씛�삕�뜝占�?
			List insView = systemmagService.viewAllInspection(); // select all �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �샇�뜝�룞�삕�뜝�떬�뙋�삕
			mav = new ModelAndView(viewName);
			mav.addObject("insView", insView);
			return mav;
		}

		else if (submit.equals("1")) { // �뜝�룞�삕�뜝�룞�삕�뜝占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕, �뜝�룞�삕 �뜝�룞�삕�쉶�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
			List insView = systemmagService.viewAllInspection(); // select�뜝�룞�삕�뜝�룞�삕
			List insins = systemmagService.viewInspection(com_code); // where�뜝�룞�삕�뜝�룞�삕 �뜝�뙥怨ㅼ삕�뜝�떬�뙋�삕
			mav = new ModelAndView(viewName);
			mav.addObject("insView", insView);
			mav.addObject("insins", insins);
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/deleteInspection.do", method = RequestMethod.GET)
	public ModelAndView deleteInspection(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no"); // 泥댄겕�뜝�룞�삕�뜝�룞�삕 泥댄겕�뜝�뙓�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
		String viewName = getViewName(request);
		String[] numberary = number.split(","); // �뜝�룞�삕�몴�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�띁�뿴�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�떬�뙋�삕

		systemmagService.delInspection(numberary);
		ModelAndView mav = new ModelAndView("redirect:/member/reginspection.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/updateInspection.do", method = RequestMethod.GET)
	public ModelAndView updateInspection(@ModelAttribute("") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		systemmagService.updInspection(systemmagVO);// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�듃�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�듃�뜝�뙃�눦�삕�뜝�룞�삕 �뜝�떊怨ㅼ삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 VO�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
		ModelAndView mav = new ModelAndView(
				"redirect:/member/reginspection.do?submit=1&&com_code=" + systemmagVO.getInspection_Code());
		return mav;
	}
	//SET援ъ꽦�뭹�벑濡�--------------------------------------------
	@Override
	@RequestMapping(value = "/member/addSetComponents.do", method = RequestMethod.GET)
	public ModelAndView addSetComponents(SystemmagVOMJ company, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = systemmagService.addSetComponents(systemmagVO);
		ModelAndView mav = new ModelAndView("redirect:/member/regsetcom.do?");
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/regsetcom.do", method = RequestMethod.GET)
	public ModelAndView viewSetComponents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit"); // 泥ュ뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 泥댄겕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 , url�뜝�룞�삕 �뜝�떬�뼲�삕�뜝占�
		String com_code = (String) request.getParameter("com_code"); // �뜝�룞�삕�뜝�듅占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� 泥댄겕�뜝�떦�뙋�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕, url�뜝�룞�삕 �뜝�떬�뼲�삕�뜝占�

		System.out.println("viewName:" + viewName);
		System.out.println("submit:" + submit);
		System.out.println("comcode:"+com_code);

		if (com_code == null && submit == null) { // 泥ュ뜝�룞�삕�뜝�룞�삕�뜝�떛�씛�삕�뜝占�?
			List setView = systemmagService.viewAllSetComponents(); // select all �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �샇�뜝�룞�삕�뜝�떬�뙋�삕
			mav = new ModelAndView(viewName);
			mav.addObject("setView", setView);
			return mav;
		}

		else if (submit.equals("1")) { // �뜝�룞�삕�뜝�룞�삕�뜝占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕, �뜝�룞�삕 �뜝�룞�삕�쉶�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
			List setView = systemmagService.viewAllSetComponents(); // select�뜝�룞�삕�뜝�룞�삕
			List compoView = systemmagService.viewSpecComponents(com_code); // where�뜝�룞�삕�뜝�룞�삕 �뜝�뙥怨ㅼ삕�뜝�떬�뙋�삕
			mav = new ModelAndView(viewName);
			mav.addObject("setView", setView);
			mav.addObject("compoView", compoView);
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/deleteSetComponents.do", method = RequestMethod.GET)
	public ModelAndView deleteSetComponents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no"); // 泥댄겕�뜝�룞�삕�뜝�룞�삕 泥댄겕�뜝�뙓�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
		String viewName = getViewName(request);
		String[] numberary = number.split(","); // �뜝�룞�삕�몴�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�띁�뿴�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�떬�뙋�삕

		systemmagService.delSetComponents(numberary);
		ModelAndView mav = new ModelAndView("redirect:/member/regsetcom.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/updateSetComponents.do", method = RequestMethod.GET)
	public ModelAndView updateSetComponents(SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		systemmagService.updSetComponents(systemmagVO);
		ModelAndView mav = new ModelAndView(
				"redirect:/member/regsetcom.do?submit=1&&com_code=" + systemmagVO.getSet_Code());
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/popupSetComponents.do", method = RequestMethod.GET)
	public ModelAndView popupSetComponents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List setView = systemmagService.viewAllSetComponents(); // select * �뜝�룞�삕�뜝�룞�삕�샇�뜝�룞�삕�뜝�떬�뙋�삕�뜝�룞�삕
		mav = new ModelAndView(viewName);
		mav.addObject("setView", setView); // �뜝�떙�뼲�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕

		return mav;
	}
	
	//AJAX CONTROLLER----------------------------------
	@ResponseBody//ajax�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�듃�뜝�떬琉꾩삕(�뜝�떊琉꾩삕泥섇뜝�뙓�벝�삕)
	@RequestMapping(value = "/member/searchPopCustomerName.do", method = RequestMethod.GET)
	public ModelAndView searchPopCustomerName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<SystemmagVOMJ> popName = null;
		popName = systemmagService.searchPopCustomerName(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

		return mav;
	}
	
	@ResponseBody//ajax�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�듃�뜝�떬琉꾩삕(�뜝�룞�삕�뜝�룞�삕�뜝�떕占�)
	@RequestMapping(value = "/member/searchPopZipCodeName.do", method = RequestMethod.GET)
	public ModelAndView searchPopZipCodeName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<SystemmagVOMJ> popName = null;
		popName = systemmagService.searchPopZipCodeName(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

		return mav;
	}
	
	@ResponseBody//ajax�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�듃�뜝�떬琉꾩삕(�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占�)
	@RequestMapping(value = "/member/searchPopLogisticsName.do", method = RequestMethod.GET)
	public ModelAndView searchPopLogisticsName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<SystemmagVOMJ> popName = null;
		popName = systemmagService.searchPopLogisticsName(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

		return mav;
	}
	// 筌뤿굞�젫占쎈뎁 占쎈솚占쎈씜 野껓옙占쎄퉳疫꿸퀡�뮟
	@ResponseBody
	@RequestMapping(value = "/member/searchPopOutwareName.do", method = RequestMethod.GET)
	public ModelAndView searchPopOutwareName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<SystemmagVOMJ> popName = null;
		popName = systemmagService.searchPopOutwareName(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

		return mav;
	}
	
	@ResponseBody//ajax�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�듃�뜝�떬琉꾩삕(�뜝�떊琉꾩삕泥섇뜝�뙓�벝�삕)
	@RequestMapping(value = "/member/searchPopSetName.do", method = RequestMethod.GET)
	public ModelAndView searchPopSetName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<SystemmagVOMJ> popName = null;
		popName = systemmagService.searchPopSetName(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

		return mav;
	}
	
	@ResponseBody//ajax�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�듃�뜝�떬琉꾩삕(�뜝�떊琉꾩삕泥섇뜝�뙓�벝�삕)
	@RequestMapping(value = "/member/searchPopComponentsName.do", method = RequestMethod.GET)
	public ModelAndView searchPopComponentsName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<SystemmagVOMJ> popName = null;
		popName = systemmagService.searchPopComponentsName(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

		return mav;
	}
}
