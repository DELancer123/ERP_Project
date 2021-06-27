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

//ȸ����
@Controller("SystemmagController")
public class SystemmagControllerMJImpl implements SystemmagControllerMJ {
	@Autowired
	private SystemmagServiceMJ systemmagService;
	@Autowired
	private SystemmagVOMJ systemmagVO;
	@Autowired
	private SystemmagDAOMJ systemmagDAO;

	// �Ϲݰŷ�ó���-���
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

	// �Ϲݰŷ�ó���-��ȸ
	@Override
	@RequestMapping(value = "/member/regbasicacc.do", method = RequestMethod.GET)
	public ModelAndView viewCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit"); // ù�������� üũ�ϴ� ������ , url�� �Ѿ��
		String com_code = (String) request.getParameter("com_code"); // ���° ������� üũ�ϴ� ������, url�� �Ѿ��
		String customerCode = (String) request.getParameter("customerCode");

		System.out.println("viewName:" + viewName);
		System.out.println("submit:" + submit);

		if (com_code == null || submit == null) { // ù�����̶��?
			if(customerCode != null) {				
				System.out.println("3���б����");
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
				System.out.println("1���б����");
				List comView = systemmagService.viewAllCustomer(); // select all ������ ȣ���Ѵ�
				mav = new ModelAndView(viewName);
				mav.addObject("comView", comView);
				return mav;
			}
		}

		else if (submit.equals("1")) { // ����� ����������, �� ��ȸ�� ������
			System.out.println("2���б����");
			List comView = systemmagService.viewAllCustomer(); // select����
			List comcom = systemmagService.viewCustomer(com_code); // where���� �߰��Ѵ�
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

	// �Ϲݰŷ�ó���-����
	@Override
	@RequestMapping(value = "/member/deleteBasicacc.do", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no"); // üũ���� üũ�ڽ��� ������ �������� ������
		String viewName = getViewName(request);
		String[] numberary = number.split(","); // ��ǥ�� �������� ������ �迭�� �����Ѵ�

		systemmagService.delCustomer(numberary);

		ModelAndView mav = new ModelAndView("redirect:/member/regbasicacc.do");

		return mav;

	}

	// �Ϲݰŷ�ó���-����
	@Override
	@RequestMapping(value = "/member/updateBasicacc.do", method = RequestMethod.GET)
	public ModelAndView updateCustomer(@ModelAttribute("") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		systemmagService.updCustomer(systemmagVO);// ������Ʈ�� ������Ʈ�Լ��� �Ű������� VO��������
		ModelAndView mav = new ModelAndView(
				"redirect:/member/regbasicacc.do?submit=1&&com_code=" + systemmagVO.getGeneral_Customer_Code());
		return mav;
	}

	// �Ϲݰŷ�ó���-�˾�
	@Override
	@RequestMapping(value = "/member/regbasicaccPopup.do", method = RequestMethod.GET)
	public ModelAndView popupCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List comView = systemmagService.viewAllCustomer(); // select * ����ȣ���Ѵ���
		mav = new ModelAndView(viewName);
		mav.addObject("comView", comView); // �˾����� ������

		return mav;
	}

	// �Ϲݰŷ�ó���-�����ȣ�˾�
	@Override
	@RequestMapping(value = "/member/regbasicaccZipPopup.do", method = RequestMethod.GET)
	public ModelAndView popupZipCustomer(@ModelAttribute("") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String com_code = request.getParameter("com_code");
		System.out.println("com_code=" + com_code);

		List ZipView = systemmagService.zipViewCustomer(); // select * ����ȣ���Ѵ���
		mav = new ModelAndView(viewName);
		mav.addObject("ZipView", ZipView); // �˾����� ������
		return mav;
	}

	// â��/����/���ְ������-��ȸ
	@Override
	@RequestMapping(value = "/member/outware.do", method = RequestMethod.GET)
	public ModelAndView viewOutware(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit"); // ù�������� üũ�ϴ� ������ , url�� �Ѿ��
		String code = (String) request.getParameter("com_code"); // ���° ������� üũ�ϴ� ������, url�� �Ѿ��

		if (code == null || submit == null) { // ù�����̶��?
			System.out.println("1���б����");
			List houOutwareList = systemmagService.viewAllHouOutware(); // select all ������ ȣ���Ѵ�
			List proOutwareList = systemmagService.viewAllProOutware();
			List outOutwareList = systemmagService.viewAllOutOutware();

			List houWorOutwareList = systemmagService.viewAllHouWorOutware(); // select all ������ ȣ���Ѵ�
			List proWorOutwareList = systemmagService.viewAllProWorOutware();
			List outWorOutwareList = systemmagService.viewAllOutWorOutware();

			mav = new ModelAndView(viewName);
			mav.addObject("houOutwareList", houOutwareList);
			mav.addObject("proOutwareList", proOutwareList);
			mav.addObject("outOutwareList", outOutwareList);
			mav.addObject("houWorOutwareList", houWorOutwareList);
			mav.addObject("proWorOutwareList", proWorOutwareList);
			mav.addObject("outWorOutwareList", outWorOutwareList);
			return mav;
		}

		return mav;
	}

	// ���������������-��ȸ
	@Override
	@RequestMapping(value = "/member/logistics_manage.do", method = RequestMethod.GET)
	public ModelAndView viewLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String submit = (String) request.getParameter("submit"); // ù�������� üũ�ϴ� ������ , url�� �Ѿ��
		String code = (String) request.getParameter("com_code"); // ���° ������� üũ�ϴ� ������, url�� �Ѿ��

		System.out.println("viewName:" + viewName);
		System.out.println("submit:" + submit);

		if (code == null && submit == null) { // ù�����̶��?
			System.out.println("1���б����");
			List logisticsView = systemmagService.viewAllLogistics(); // select all ������ ȣ���Ѵ�
			mav = new ModelAndView(viewName);
			mav.addObject("logisticsView", logisticsView);
			return mav;
		}

		else if (submit.equals("1")) { // ����� ����������, �� ��ȸ�� ������
			System.out.println("2���б����");
			List logisticsView = systemmagService.viewAllLogistics(); // select����
			List logisticsSelectedView = systemmagService.viewSelectedLogistics(code); // where���� �߰��Ѵ�
			mav = new ModelAndView(viewName);
			mav.addObject("logisticsView", logisticsView);
			mav.addObject("logisticsSelectedView", logisticsSelectedView);
		}

		return mav;
	}

	// ���������������-���
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

	// ���������������-����
	@Override
	@RequestMapping(value = "/member/deleteLogistics_manage.do", method = RequestMethod.GET)
	public ModelAndView deleteLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no"); // üũ���� üũ�ڽ��� ������ �������� ������
		String viewName = getViewName(request);
		String[] numberary = number.split(","); // ��ǥ�� �������� ������ �迭�� �����Ѵ�

		systemmagService.deleteLogistics(numberary);

		ModelAndView mav = new ModelAndView("redirect:/member/logistics_manage.do");
		return mav;
	}

	// ���������������-����
	@Override
	@RequestMapping(value = "/member/updateLogistics_manage.do", method = RequestMethod.GET)
	public ModelAndView updateLogistics(@ModelAttribute("") SystemmagVOMJ systemmagVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		systemmagService.updateLogistics(systemmagVO);// ������Ʈ�� ������Ʈ�Լ��� �Ű������� VO��������
		ModelAndView mav = new ModelAndView(
				"redirect:/member/regbasicacc.do?submit=1&&com_code=" + systemmagVO.getLogistics_In_Code());
		return mav;
	}

	// ���������������-�˾�
	@Override
	@RequestMapping(value = "/member/logisticsPopup.do", method = RequestMethod.GET)
	public ModelAndView popupLogistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = null;
		String viewName = getViewName(request);

		List logisticsView = systemmagService.viewAllLogistics(); // select * ����ȣ���Ѵ���
		mav = new ModelAndView(viewName);
		mav.addObject("logisticsView", logisticsView); // �˾����� ������

		return mav;
	}

	@ResponseBody
	@RequestMapping(value = "/member/searchPopName.do", method = RequestMethod.GET)
	public ModelAndView searchPopName(@RequestParam("itemName") String itemName) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<SystemmagVOMJ> popName = null;
		popName = systemmagService.searchPopName(itemName);
		mav.addObject("popName", popName);
		mav.setViewName("jsonView");

		return mav;
	}

}
