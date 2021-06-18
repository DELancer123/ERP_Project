package com.myspring.salesmanage.salesplan.reg.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.salesmanage.itemview.vo.ItemViewVO;
import com.myspring.salesmanage.salesplan.service.SalesplanService;

@Controller("salesplanRegController")
//@EnavleAspectJAutoProxy
public class SalesplanRegControllerImpl implements SalesplanRegController {

	private static final Logger logger = LoggerFactory.getLogger(SalesplanRegControllerImpl.class);
	@Autowired
	private SalesplanService salesplanService;
	@Autowired
	private ItemViewVO itemviewVO;
	
	@Override
	@RequestMapping(value="/sales_manage/pop/popItemBySalesList.do" ,method = RequestMethod.GET)
	public ModelAndView listItemBySales(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		List allItemList = salesplanService.listItems();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allItemList", allItemList);
		return mav;
	}
	
	@RequestMapping(value="/sales_manage/pop/popItemBySalesReg.do" ,method = RequestMethod.GET)
	public ModelAndView AllItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		List allItemList = salesplanService.listItems();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("allItemList", allItemList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/regsalesplan.do" ,method = RequestMethod.GET)
	public ModelAndView submitItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String code = (String)request.getParameter("item_code");
		String submit = (String) request.getParameter("submit");
		int sum = 0;
		
		if(code == null || code.length() == 0|| submit.equals("0")) {
			mav = new ModelAndView(viewName);
			
			return mav;
		}else if(submit.equals("1")){
			
				List salesplan = salesplanService.submitItem(code);
				
				mav = new ModelAndView(viewName);
				mav.addObject("salesplan", salesplan);
			}else if(submit.equals("2")) {
				List salesplan = salesplanService.submitItem(code);
				
				mav = new ModelAndView(viewName);
				mav.addObject("salesplan", salesplan);
				int inputNo = salesplanService.inputNo();
				String inNo = Integer.toString(inputNo+1);
				System.out.println(inNo);
				request.setAttribute("inputNo", inNo);
			}

		return mav;
	}
	@RequestMapping(value="/member/reg.do" ,method = RequestMethod.GET)
	public ModelAndView insertItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String code = (String)request.getParameter("item_code");
		String submit = (String)request.getParameter("submit");
		int sum = 0;
		
		if(code == null || code.length() == 0||submit.equals("0")) {
			mav = new ModelAndView(viewName);
			return mav;
		}else if(submit.equals("1")) {
			
			List salesplan = salesplanService.submitItem(code);			
			mav = new ModelAndView(viewName);
			mav.addObject("salesplan", salesplan);//SM_BIM_Sal_Pla_Reg
		}else if(submit.equals("2")) {

			List salesplan = salesplanService.submitItem(code);
//			List addSalesplanList = salesplanService.itemText(code);//text관련 수정
			mav = new ModelAndView(viewName);
			mav.addObject("salesplan", salesplan);//SM_BIM_Sal_Pla_Reg->list
//			mav.addObject("addSalesplanList", addSalesplanList);//SM_BIM_Sal_Pla_Reg->insert
			
//			int inputNo = salesplanService.inputNO();
//			String inNo = Integer.toString(inputNo+1);
//			System.out.println(inNo);
//			request.setAttribute("inputNo", inNo);
		}

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




//	@Override
//	@RequestMapping(value="/member/regsalesplan.do", method= RequestMethod.GET)//jsp���� �޾ƿ� ���ΰ�
//	public ModelAndView listSalesplans(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String viewName = getViewName(request);
//		System.out.println("viewName: " +viewName);
//		logger.info("viewName:" +viewName);
//		logger.debug("viewName: "+viewName);
//		List salesplansList = salesplanService.listSalesplans();
//		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("salesplansList",salesplansList);
//		return mav;
//	}//mapper.salesplan.
//
//
//
//
//	@Override
//	@RequestMapping(value="/member/addsalesplan.do", method=RequestMethod.POST)
//	public ModelAndView addSalesplan(@ModelAttribute("info")SalesplanVO salesplan,HttpServletRequest request, HttpServletResponse response) throws Exception{
//		
//		request.setCharacterEncoding("utf-8");
//		int result =0;
//		result = salesplanService.addSalesplan(salesplan);
//		ModelAndView mav = new ModelAndView("redirect:/salesplan/listSalesplans.do");
//		return mav;
//	}
//
//
//	@Override
//	public ModelAndView addNewSalesplan(SalesplanVO salesplan, HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		request.setCharacterEncoding("utf-8");
//		int result =0;
//		result = salesplanService.addNewSalesplan(salesplan);
//		ModelAndView mav = new ModelAndView("redirect:/salesplan/listSalesplans.do");
//		return mav;
//	}
//	
//	@RequestMapping(value="/salesplan/removeSalesplan.do", method=RequestMethod.GET)
//	public ModelAndView removeSalesplan(@RequestParam("Plan_Item_Code")String Plan_Item_Code,
//			HttpServletRequest request, HttpServletResponse response) throws Exception{
//		request.setCharacterEncoding("utf-8");
//		salesplanService.removeSalesplan(Plan_Item_Code);
//		ModelAndView mav = new ModelAndView("redirect:/salesplan/listSalesplans.do");
//		return mav;
//	}
//
//	
//	@RequestMapping(value = "/salesplan/*Form.do", method =  RequestMethod.GET)
//	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
//						       HttpServletRequest request, 
//						       HttpServletResponse response) throws Exception {
//		//String viewName = getViewName(request);
//		String viewName = (String)request.getAttribute("viewName");
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("result",result);
//		mav.setViewName(viewName);
//		return mav;
//	}
//
//
//
//
//
////	@Override
////	@RequestMapping(value="/member/searchcode.do", method=RequestMethod.GET)
////	public ModelAndView searchCode(@ModelAttribute("salesplan") SalesplanVO salesplan,
//////            RedirectAttributes rAttr,
////            HttpServletRequest request, HttpServletResponse response) throws Exception{
////		
//////		List myOrderList=new ArrayList<OrderVO>();
//////		myOrderList.add(orderVO);
//////
//////		MemberVO memberInfo=(MemberVO)session.getAttribute("memberInfo");
//////		
//////		session.setAttribute("myOrderList", myOrderList);
//////		session.setAttribute("orderer", memberInfo);
////		//		return mav;
////		
////		
//////		// TODO Auto-generated method stub
////		ModelAndView mav = new ModelAndView();
////		salesplanVO = salesplanService.searchCode(salesplan);
////		if(salesplanVO !=null) {
////			HttpSession session = request.getSession();
////			session.setAttribute("salesplan", salesplanVO);
////			session.setAttribute("isLogOn", true);
////			String action = (String) session.getAttribute("action");
////			session.removeAttribute("action");
////			if(action!= null) {
////				mav.setViewName("redirect:"+action);
////			}else {
////				mav.setViewName("redirect:/member/regsalesplan.do");//�����ؾ���
////			}
////			
////		}else {
////			rAttr.addAttribute("result", "nothing");
//////			   mav.setViewName("redirect:/member/loginForm.do");
////		}
////		return mav;
////	}
////
////
////
////
////	@Override
////	@RequestMapping(value="/member/searchname.do", method=RequestMethod.GET)
////	public ModelAndView searchName(SalesplanVO salesplan, RedirectAttributes rAttr, HttpServletRequest request,
////			HttpServletResponse response) throws Exception {
////		// TODO Auto-generated method stub
////		return null;
////	}
////
////
////
////
////	@Override
////	@RequestMapping(value="/member/searchdate.do", method=RequestMethod.GET)
////	public ModelAndView searchDate(SalesplanVO salesplan, RedirectAttributes rAttr, HttpServletRequest request,
////			HttpServletResponse response) throws Exception {
////		// TODO Auto-generated method stub
////		return null;
////	}

}
