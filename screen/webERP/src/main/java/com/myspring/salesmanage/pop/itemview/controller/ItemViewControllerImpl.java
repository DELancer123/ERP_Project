package com.myspring.salesmanage.pop.itemview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.salesmanage.pop.itemview.service.ItemViewService;
import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;

@Controller("itemviewController")
public class ItemViewControllerImpl implements ItemViewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemViewControllerImpl.class);
	
	@Autowired
	private ItemViewService itemviewService;
	
	@Autowired
	private ItemViewVO itemviewVO;

	@Override
	@RequestMapping(value="/salesmanage/regplanitem.do" ,method = RequestMethod.GET)
	public ModelAndView submitItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String code = (String)request.getParameter("item_code");
		String name = (String)request.getParameter("item_name");
		String stan = (String)request.getParameter("standard");
		String unit = (String)request.getParameter("inventory_unit");
		String inspect = (String)request.getParameter("inspection_status");
		String submit = (String)request.getParameter("submit");
		
		if(code == null || code.length() == 0 || submit.equals("0")) {
			mav = new ModelAndView(viewName);
			return mav;
		}
		else if(submit.equals("1")){
			List submitItem = itemviewService.submitItem(code);
			
			mav = new ModelAndView(viewName);
			mav.addObject("bomView", bomView);
		}
		else if(submit.equals("2")) {
			List submitItem = itemviewService.submitItem(code);
			List bomInsert = itemviewService.setText(itemNumber);
			mav = new ModelAndView(viewName);
			mav.addObject("bomView", bomView);
			mav.addObject("bomInsert",bomInsert);
		}
		
		return mav;
	}
	@Override
	@RequestMapping(value="/sales_manage/popItem.do" ,method = RequestMethod.GET)
	public ModelAndView listAllItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
//		String viewName = (String)request.getAttribute("viewName");
		//System.out.println("viewName: " +viewName);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		List allItemsList = itemviewService.listItems();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allItemsList", allItemsList);
		return mav;
	}

	@Override
	@RequestMapping(value="/itemview/addItem.do" ,method = RequestMethod.POST)
	public ModelAndView addItem(@ModelAttribute("info") ItemViewVO itemview,HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = itemviewService.addItem(itemview);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	

	@Override
	@RequestMapping(value="/itemview/removeItem.do" ,method = RequestMethod.GET)
	public ModelAndView removeItem(String item_code, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setCharacterEncoding("utf-8");
		itemviewService.removeItem(item_code);
			ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
			return mav;
		}

	
	
	private String getViewName(HttpServletRequest request) throws Exception {
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

////	@Override
////	@RequestMapping(value="/member/regplanitem.do" ,method = RequestMethod.GET)
////	public ModelAndView viewPlanItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
////		ModelAndView mav = null;
////		String viewName = getViewName(request);
////		String code = (String) request.getParameter("Item_Code");
////		if(code == null || code.length() == 0) {
////			mav = new ModelAndView(viewName);
////			return mav;
////		}
////		else {
////			List planItemView = itemViewService.viewSearch(code);
////			mav = new ModelAndView(viewName);
////			mav.addObject("planItemView", planItemView);
////		}
////			
////		System.out.println("���Ͷ��" + code);
////		return mav;
////	}
////
////	@RequestMapping(value="/member/codehelperbyplan.do" ,method = RequestMethod.GET)
////	public ModelAndView codeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception {
////		String viewName = getViewName(request);
////		List itemSearch = itemViewService.itemSearch();
////		ModelAndView mav = new ModelAndView(viewName);
////		mav.addObject("itemSearch", itemSearch);
////		return mav;
////	}
//}
