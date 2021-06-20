package com.myspring.productionBaseInfo.controller;

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

import com.myspring.productionBaseInfo.service.*;
import com.myspring.productionBaseInfo.BOM.vo.*;
import com.myspring.productionBaseInfo.regDefectiveType.vo.DefectiveTypeVO;



@Controller("memberController")
//@EnableAspectJAutoProxy
public class BomViewControllerImpl implements BomViewController {
	private static final Logger logger = LoggerFactory.getLogger(BomViewControllerImpl.class);
	@Autowired
	private BomViewService viewService;
	@Autowired
	private bomVO bomVO ;
	
	@Override
	@RequestMapping(value="/member/regbom.do" ,method = RequestMethod.GET)
	public ModelAndView viewBOM(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String number = (String) request.getParameter("itemNumber");
		String submit = (String) request.getParameter("submit");
		String itemNumber = (String) request.getParameter("itemCode");
		int sum = 0;
		if(number == null || number.length() == 0 || submit.equals("0")) {
			mav = new ModelAndView(viewName);
			return mav;
		}
		else if(submit.equals("1")){
			List bomView = viewService.SearchView(number);
			
			mav = new ModelAndView(viewName);
			
			mav.addObject("bomView", bomView);
		}
		else if(submit.equals("2")) {
			List bomView = viewService.SearchView(number);
			List bomInsert = viewService.setText(itemNumber);
			mav = new ModelAndView(viewName);
			mav.addObject("bomView", bomView);
			mav.addObject("bomInsert",bomInsert);
			int inputNo = viewService.inputNo();
			String inNo = Integer.toString(inputNo+1);
			System.out.println(inNo);
			request.setAttribute("inputNo", inNo);
		}
		
		 
			
		return mav;
	}
	
	@RequestMapping(value="/member/codehelper.do" ,method = RequestMethod.GET)
	public ModelAndView codeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List itemView = viewService.itemView1();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemView", itemView);
		return mav;
	}
	@RequestMapping(value="/member/bomcodehelper.do" ,method = RequestMethod.GET)
	public ModelAndView BOMcodeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		String itemNumber = (String) request.getParameter("itemCode");
		List itemView = viewService.itemView2();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemView", itemView);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/addBOM.do" ,method = RequestMethod.GET)
	public ModelAndView addMember(@ModelAttribute("bom") bomVO bomVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		System.out.println("url" + path);
		int result = 0;
		result = viewService.addBOM(bomVO);
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/delBOM.do" ,method = RequestMethod.GET)
	public ModelAndView delMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("no");
		String viewName = getViewName(request);
		String[] numberary = number.split(",");
		viewService.delBOM(numberary);
		ModelAndView mav = new ModelAndView("redirect:/member/regbom.do");
		return mav;
		}
	
	@Override
	@RequestMapping(value="/member/updateBOM.do" ,method = RequestMethod.GET)
	public ModelAndView updateMember(@ModelAttribute("bom") bomVO bomVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = viewService.updateBOM(bomVO);
		System.out.println("result "+result);
		ModelAndView mav = new ModelAndView("redirect:/member/regbom.do");
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
	@RequestMapping(value="/member/rightbom.do" ,method = RequestMethod.GET)
	public ModelAndView rightbom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String number = (String) request.getParameter("itemNumber");
		String submit = (String) request.getParameter("submit");
		String childCode = (String) request.getParameter("childCode");
		int sum = 0;
		if(number == null || number.length() == 0 || submit.equals("0")) {
			mav = new ModelAndView(viewName);
			return mav;
		}
		else if(submit.equals("1")){
			List bomView = viewService.SearchView(number);
			
			mav = new ModelAndView(viewName);
			
			mav.addObject("bomView", bomView);
		}
		else if(submit.equals("2")) {
			List bomView = viewService.SearchView(number);
			List childView = viewService.ChildView(number,childCode);
			mav = new ModelAndView(viewName);
			mav.addObject("bomView", bomView);
			mav.addObject("childView",childView);
		}
		return mav;
	}

	@Override
	@RequestMapping(value="/member/outprice.do" ,method = RequestMethod.GET)
	public ModelAndView regoutsourcing(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String itemNumber = request.getParameter("itemNumber");
		String submit = request.getParameter("submit");
		String itemCode = request.getParameter("itemCode");
		String placeCode = request.getParameter("placeCode");
		mav = new ModelAndView(viewName);
		if(itemNumber == null || submit == null || submit.equals("0")) {
			return mav;
		}
		else if(submit.equals("1")) {
			List outpriceView = viewService.getoutprice(itemNumber,placeCode);
			mav.addObject("outpriceView",outpriceView);
		}
		else if(submit.equals("2")) {
			List outpriceView = viewService.getoutprice(itemNumber,placeCode);
			List outpriceText = viewService.inputText(itemCode);
			mav.addObject("outpriceView",outpriceView);
			mav.addObject("setText",outpriceText);
		}
		return mav;
	}
	@RequestMapping(value="/member/outsourcingPop.do" ,method = RequestMethod.GET)
	public ModelAndView outsourcingPop(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String div = request.getParameter("div");
		String viewName = getViewName(request);
		String itemNumber = request.getParameter("itemNumber");
		
		mav = new ModelAndView(viewName);
		if(itemNumber == null || div.equals("1")) {
			List outView = viewService.SearchOutView();
			mav.addObject("outView",outView);
		}
		else if(div.equals("2")) {
			List outView = viewService.SearchOutView1(itemNumber);
			
			mav.addObject("outView",outView);
		}

		return mav;
	}
	@RequestMapping(value="/member/outpricehelper.do" ,method = RequestMethod.GET)
	public ModelAndView outpriceHelper(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List bomList = viewService.bomView();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("bomlist",bomList);
		return mav;
	}
	@Override
	@RequestMapping(value="/member/addoutprice.do" ,method = RequestMethod.GET)
	public ModelAndView addoutprice(@ModelAttribute("out") RegOutSourcingPriceVO outVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		int result = 0;
		result = viewService.addoutprice(outVO);
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/updoutprice.do" ,method = RequestMethod.GET)
	public ModelAndView updoutprice(@ModelAttribute("out") RegOutSourcingPriceVO outVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		int result = 0;
		result = viewService.updoutprice(outVO);
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/deleteoutprice.do" ,method = RequestMethod.GET)
	public ModelAndView deleteoutprice(RegOutSourcingPriceVO outVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		int result = 0;
		/* result = viewService.doutprice(outVO); */
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/deftype.do" ,method = RequestMethod.GET)
	public ModelAndView viewDefectiveType(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		mav = new ModelAndView(viewName);
		String submit = (String) request.getParameter("submit");
		int sum = 0;
		if(submit == null || submit.equals("0")) {
			mav = new ModelAndView(viewName);
			return mav;
		}
		else if(submit.equals("1")){
			List defectiveList = null;
			defectiveList =  viewService.viewDefective();
			mav.addObject("defectiveList",defectiveList);
		}
		return mav;
	}

	@Override
	@RequestMapping(value="/member/adddefType.do" ,method = RequestMethod.GET)
	public ModelAndView adddefType(DefectiveTypeVO defVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		int result = 0;
		result = viewService.addDefType(defVO);
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/upddefType.do" ,method = RequestMethod.GET)
	public ModelAndView updoutprice(DefectiveTypeVO defVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		int result = 0;
		result = viewService.updDefType(defVO);
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}
}
