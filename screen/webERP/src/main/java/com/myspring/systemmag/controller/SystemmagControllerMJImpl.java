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

//회占쏙옙占쏙옙
@Controller("SystemmagControllerMJ")
public class SystemmagControllerMJImpl implements SystemmagControllerMJ {
	@Autowired
	private SystemmagServiceMJ systemmagService;
	@Autowired
	private SystemmagVOMJ systemmagVO;
	@Autowired
	private SystemmagDAOMJ systemmagDAO;

	// 占싹반거뤄옙처占쏙옙占�-占쏙옙占�
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

	// 占싹반거뤄옙처占쏙옙占�-占쏙옙회
	@Override
	@RequestMapping(value = "/member/regbasicacc.do", method = RequestMethod.GET)
	public ModelAndView viewCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit"); // 첫占쏙옙占쏙옙占쏙옙占쏙옙 체크占싹댐옙 占쏙옙占쏙옙占쏙옙 , url占쏙옙 占싼억옙占�
		String com_code = (String) request.getParameter("com_code"); // 占쏙옙占승� 占쏙옙占쏙옙占쏙옙占� 체크占싹댐옙 占쏙옙占쏙옙占쏙옙, url占쏙옙 占싼억옙占�
		String customerCode = (String) request.getParameter("customerCode");

		System.out.println("viewName:" + viewName);
		System.out.println("submit:" + submit);
		System.out.println("comcode:"+com_code);
		System.out.println("customercode:"+customerCode);

		if (com_code == null && submit == null) { // 첫占쏙옙占쏙옙占싱띰옙占�?
			if(customerCode != null) {				
				System.out.println("3占쏙옙占싻깍옙占쏙옙占�");
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
				System.out.println("1占쏙옙占싻깍옙占쏙옙占�");
				List comView = systemmagService.viewAllCustomer(); // select all 占쏙옙占쏙옙占쏙옙 호占쏙옙占싼댐옙
				mav = new ModelAndView(viewName);
				mav.addObject("comView", comView);
				return mav;
			}
		}

		else if (submit.equals("1")) { // 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙, 占쏙옙 占쏙옙회占쏙옙 占쏙옙占쏙옙占쏙옙
			System.out.println("2占쏙옙占싻깍옙占쏙옙占�");
			List comView = systemmagService.viewAllCustomer(); // select占쏙옙占쏙옙
			List comcom = systemmagService.viewCustomer(com_code); // where占쏙옙占쏙옙 占쌩곤옙占싼댐옙
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

	// 占싹반거뤄옙처占쏙옙占�-占쏙옙占쏙옙
	@Override
	@RequestMapping(value = "/member/deleteBasicacc.do", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no"); // 체크占쏙옙占쏙옙 체크占쌘쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
		String viewName = getViewName(request);
		String[] numberary = number.split(","); // 占쏙옙표占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占썼열占쏙옙 占쏙옙占쏙옙占싼댐옙

		systemmagService.delCustomer(numberary);

		ModelAndView mav = new ModelAndView("redirect:/member/regbasicacc.do");

		return mav;

	}

	// 占싹반거뤄옙처占쏙옙占�-占쏙옙占쏙옙
	@Override
	@RequestMapping(value = "/member/updateBasicacc.do", method = RequestMethod.GET)
	public ModelAndView updateCustomer(@ModelAttribute("") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		systemmagService.updCustomer(systemmagVO);// 占쏙옙占쏙옙占쏙옙트占쏙옙 占쏙옙占쏙옙占쏙옙트占쌉쇽옙占쏙옙 占신곤옙占쏙옙占쏙옙占쏙옙 VO占쏙옙占쏙옙占쏙옙占쏙옙
		ModelAndView mav = new ModelAndView(
				"redirect:/member/regbasicacc.do?submit=1&&com_code=" + systemmagVO.getGeneral_Customer_Code());
		return mav;
	}

	// 占싹반거뤄옙처占쏙옙占�-占싯억옙
	@Override
	@RequestMapping(value = "/member/regbasicaccPopup.do", method = RequestMethod.GET)
	public ModelAndView popupCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List comView = systemmagService.viewAllCustomer(); // select * 占쏙옙占쏙옙호占쏙옙占싼댐옙占쏙옙
		mav = new ModelAndView(viewName);
		mav.addObject("comView", comView); // 占싯억옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙

		return mav;
	}

	// 占싹반거뤄옙처占쏙옙占�-占쏙옙占쏙옙占싫ｏ옙鱇占�
	@Override
	@RequestMapping(value = "/member/regbasicaccZipPopup.do", method = RequestMethod.GET)
	public ModelAndView popupZipCustomer(@ModelAttribute("") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String com_code = request.getParameter("com_code");
		System.out.println("com_code=" + com_code);

		List ZipView = systemmagService.zipViewCustomer(); // select * 占쏙옙占쏙옙호占쏙옙占싼댐옙占쏙옙
		mav = new ModelAndView(viewName);
		mav.addObject("ZipView", ZipView); // 占싯억옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
		return mav;
	}

	// 창占쏙옙/占쏙옙占쏙옙/占쏙옙占쌍곤옙占쏙옙占쏙옙占�-占쏙옙회
	@Override
	@RequestMapping(value = "/member/outware.do", method = RequestMethod.GET)
	public ModelAndView viewOutware(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit"); // 첫占쏙옙占쏙옙占쏙옙占쏙옙 체크占싹댐옙 占쏙옙占쏙옙占쏙옙 , url占쏙옙 占싼억옙占�
		String code = (String) request.getParameter("com_code"); // 占쏙옙占승� 占쏙옙占쏙옙占쏙옙占� 체크占싹댐옙 占쏙옙占쏙옙占쏙옙, url占쏙옙 占싼억옙占�
		String outwareCode = (String) request.getParameter("outwareCode");
		String processCode = (String) request.getParameter("processCode");
		String outsourcingCode = (String) request.getParameter("outsourcingCode");
		System.out.println("outwareCode:"+outwareCode);
		System.out.println("processCode:"+processCode);
		System.out.println("outsourcingCode:"+outsourcingCode);
		if (code == null && submit == null) { // 첫占쏙옙占쏙옙占싱띰옙占�?
			System.out.println("1占쏙옙占싻깍옙占쏙옙占�");
			List houOutwareList = systemmagService.viewAllHouOutware(); // select all 占쏙옙占쏙옙占쏙옙 호占쏙옙占싼댐옙
			List proOutwareList = systemmagService.viewAllProOutware();
			List outOutwareList = systemmagService.viewAllOutOutware();

			List houWorOutwareList = systemmagService.viewAllHouWorOutware(); // select all 占쏙옙占쏙옙占쏙옙 호占쏙옙占싼댐옙
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
	// 창占쏙옙/占쏙옙占쏙옙/占쏙옙占쌍곤옙占쏙옙占쏙옙황-占싯억옙
	@Override
	@RequestMapping(value = "/member/outwarePopup1.do", method = RequestMethod.GET)
	public ModelAndView popupOutware1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List outwareView = systemmagService.viewAllHouOutware(); // select * 占쏙옙占쏙옙호占쏙옙占싼댐옙占쏙옙
		mav = new ModelAndView(viewName);
		mav.addObject("outwareView", outwareView); // 占싯억옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙

		return mav;
	}
	@Override
	@RequestMapping(value = "/member/outwarePopup2.do", method = RequestMethod.GET)
	public ModelAndView popupOutware2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List outwareView = systemmagService.viewAllProOutware(); // select * 占쏙옙占쏙옙호占쏙옙占싼댐옙占쏙옙
		mav = new ModelAndView(viewName);
		mav.addObject("outwareView", outwareView); // 占싯억옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙

		return mav;
	}
	@Override
	@RequestMapping(value = "/member/outwarePopup3.do", method = RequestMethod.GET)
	public ModelAndView popupOutware3(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List outwareView = systemmagService.viewAllOutOutware(); // select * 占쏙옙占쏙옙호占쏙옙占싼댐옙占쏙옙
		mav = new ModelAndView(viewName);
		mav.addObject("outwareView", outwareView); // 占싯억옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙

		return mav;
	}

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占�-占쏙옙회
	@Override
	@RequestMapping(value = "/member/logistics_manage.do", method = RequestMethod.GET)
	public ModelAndView viewLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit"); // 첫占쏙옙占쏙옙占쏙옙占쏙옙 체크占싹댐옙 占쏙옙占쏙옙占쏙옙 , url占쏙옙 占싼억옙占�
		String code = (String) request.getParameter("com_code"); // 첫占쏙옙占쏙옙占쏙옙占쏙옙 체크占싹댐옙 占쏙옙占쏙옙占쏙옙 , url占쏙옙 占싼억옙占�
		String logisSearchBox = (String) request.getParameter("logisSearchBox"); // 占쏙옙占승� 占쏙옙占쏙옙占쏙옙占� 체크占싹댐옙 占쏙옙占쏙옙占쏙옙, url占쏙옙 占싼억옙占�

		System.out.println("viewName:" + viewName);
		System.out.println("submit:" + submit);
		System.out.println("logisSearchBox:"+logisSearchBox);

		if (code == null && submit == null) { // 첫占쏙옙占쏙옙占싱띰옙占�?			
			if(logisSearchBox != null) {				
				System.out.println("3占쏙옙占싻깍옙占쏙옙占�");
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
				System.out.println("1占쏙옙占싻깍옙占쏙옙占�");
				List logisticsView = systemmagService.viewAllLogistics(); // select all 占쏙옙占쏙옙占쏙옙 호占쏙옙占싼댐옙
				mav = new ModelAndView(viewName);
				mav.addObject("logisticsView", logisticsView);
				return mav;
			}
		}

		else if (submit.equals("1")) { // 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙, 占쏙옙 占쏙옙회占쏙옙 占쏙옙占쏙옙占쏙옙
			System.out.println("2占쏙옙占싻깍옙占쏙옙占�");
			List logisticsView = systemmagService.viewAllLogistics(); // select占쏙옙占쏙옙
			List logisticsSelectedView = systemmagService.viewSelectedLogistics(code); // where占쏙옙占쏙옙 占쌩곤옙占싼댐옙
			mav = new ModelAndView(viewName);
			mav.addObject("logisticsView", logisticsView);
			mav.addObject("logisticsSelectedView", logisticsSelectedView);
		}

		return mav;
	}

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占�-占쏙옙占�
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

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占�-占쏙옙占쏙옙
	@Override
	@RequestMapping(value = "/member/deleteLogistics_manage.do", method = RequestMethod.GET)
	public ModelAndView deleteLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no"); // 체크占쏙옙占쏙옙 체크占쌘쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
		System.out.println("占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙");
		System.out.println("number:"+number);
		String viewName = getViewName(request);
		String[] numberary = number.split(","); // 占쏙옙표占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占썼열占쏙옙 占쏙옙占쏙옙占싼댐옙

		systemmagService.deleteLogistics(numberary);

		ModelAndView mav = new ModelAndView("redirect:/member/logistics_manage.do");
		return mav;
	}

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占�-占쏙옙占쏙옙
	@Override
	@RequestMapping(value = "/member/updateLogistics_manage.do", method = RequestMethod.GET)
	public ModelAndView updateLogistics(SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("占쏙옙占쏙옙占쏙옙트占쏙옙占쏙옙占쏙옙");
		request.setCharacterEncoding("utf-8");
		System.out.println("explanation:"+request.getParameter("explanation"));
		systemmagService.updateLogistics(systemmagVO);// 占쏙옙占쏙옙占쏙옙트占쏙옙 占쏙옙占쏙옙占쏙옙트占쌉쇽옙占쏙옙 占신곤옙占쏙옙占쏙옙占쏙옙 VO占쏙옙占쏙옙占쏙옙占쏙옙
		ModelAndView mav = new ModelAndView(
				"redirect:/member/logistics_manage.do?submit=1&&com_code=" + systemmagVO.getLogistics_In_Code());
		return mav;
	}
	

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占�-占싯억옙
	@Override
	@RequestMapping(value = "/member/logisticsPopup.do", method = RequestMethod.GET)
	public ModelAndView popupLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List logisticsView = systemmagService.viewAllLogistics(); // select * 占쏙옙占쏙옙호占쏙옙占싼댐옙占쏙옙
		mav = new ModelAndView(viewName);
		mav.addObject("logisticsView", logisticsView); // 占싯억옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙

		return mav;
	}
	//----------------------------------
	@ResponseBody//ajax占쏙옙占쏙옙 占쏙옙트占싼뤄옙(占신뤄옙처占쌘듸옙)
	@RequestMapping(value = "/member/searchPopCustomerName.do", method = RequestMethod.GET)
	public ModelAndView searchPopCustomerName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<SystemmagVOMJ> popName = null;
		popName = systemmagService.searchPopCustomerName(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

		return mav;
	}
	
	@ResponseBody//ajax占쏙옙占쏙옙 占쏙옙트占싼뤄옙(占쏙옙占쏙옙占싫�)
	@RequestMapping(value = "/member/searchPopZipCodeName.do", method = RequestMethod.GET)
	public ModelAndView searchPopZipCodeName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<SystemmagVOMJ> popName = null;
		popName = systemmagService.searchPopZipCodeName(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

		return mav;
	}
	
	@ResponseBody//ajax占쏙옙占쏙옙 占쏙옙트占싼뤄옙(占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占�)
	@RequestMapping(value = "/member/searchPopLogisticsName.do", method = RequestMethod.GET)
	public ModelAndView searchPopLogisticsName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<SystemmagVOMJ> popName = null;
		popName = systemmagService.searchPopLogisticsName(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

		return mav;
	}
	// 紐낆젣�뵪 �뙘�뾽 寃��깋湲곕뒫
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
		String submit = (String) request.getParameter("submit"); // 첫占쏙옙占쏙옙占쏙옙占쏙옙 체크占싹댐옙 占쏙옙占쏙옙占쏙옙 , url占쏙옙 占싼억옙占�
		String com_code = (String) request.getParameter("com_code"); // 占쏙옙占승� 占쏙옙占쏙옙占쏙옙占� 체크占싹댐옙 占쏙옙占쏙옙占쏙옙, url占쏙옙 占싼억옙占�

		System.out.println("viewName:" + viewName);
		System.out.println("submit:" + submit);
		System.out.println("comcode:"+com_code);

		if (com_code == null && submit == null) { // 첫占쏙옙占쏙옙占싱띰옙占�?
			List insView = systemmagService.viewAllInspection(); // select all 占쏙옙占쏙옙占쏙옙 호占쏙옙占싼댐옙
			mav = new ModelAndView(viewName);
			mav.addObject("insView", insView);
			return mav;
		}

		else if (submit.equals("1")) { // 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙, 占쏙옙 占쏙옙회占쏙옙 占쏙옙占쏙옙占쏙옙
			List insView = systemmagService.viewAllInspection(); // select占쏙옙占쏙옙
			List insins = systemmagService.viewInspection(com_code); // where占쏙옙占쏙옙 占쌩곤옙占싼댐옙
			mav = new ModelAndView(viewName);
			mav.addObject("insView", insView);
			mav.addObject("insins", insins);
		}
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/deleteInspection.do", method = RequestMethod.GET)
	public ModelAndView deleteInspection(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no"); // 체크占쏙옙占쏙옙 체크占쌘쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
		String viewName = getViewName(request);
		String[] numberary = number.split(","); // 占쏙옙표占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占썼열占쏙옙 占쏙옙占쏙옙占싼댐옙

		systemmagService.delInspection(numberary);
		ModelAndView mav = new ModelAndView("redirect:/member/reginspection.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value = "/member/updateInspection.do", method = RequestMethod.GET)
	public ModelAndView updateInspection(@ModelAttribute("") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		systemmagService.updInspection(systemmagVO);// 占쏙옙占쏙옙占쏙옙트占쏙옙 占쏙옙占쏙옙占쏙옙트占쌉쇽옙占쏙옙 占신곤옙占쏙옙占쏙옙占쏙옙 VO占쏙옙占쏙옙占쏙옙占쏙옙
		ModelAndView mav = new ModelAndView(
				"redirect:/member/reginspection.do?submit=1&&com_code=" + systemmagVO.getInspection_Code());
		return mav;
	}
}
