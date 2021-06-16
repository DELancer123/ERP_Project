
package com.myspring.commonProduction.controller;
  
import java.sql.Date;
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
import org.springframework.web.servlet.ModelAndView;
  
import com.myspring.commonProduction.commitOperationInstruction.vo.CommitOperationInstructionVO; 
import com.myspring.commonProduction.operationRegist.vo.OperationRegistVO; 
import com.myspring.commonProduction.service.CommonProductionService;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;
 
  @Controller("CommonProductionController") 
  public class CommonProductionControllerImpl implements CommonProductionController{ 
	  private static final Logger logger = LoggerFactory.getLogger(CommonProductionControllerImpl.class);
	  @	Autowired private CommonProductionService productionService;
	  @Autowired private CommitOperationInstructionVO COIVO;
	  @Autowired private OperationRegistVO ORVO;
  
	  @Override
	  @RequestMapping(value="/member/proplanreg.do" ,method = RequestMethod.GET)
  		public ModelAndView listProductInfo(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		  ModelAndView mav = null;
			String viewName = getViewName(request);
			String submit = (String) request.getParameter("submit");
			String itemCode = (String) request.getParameter("itemCode");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");			
			int sum = 0;
			if(itemCode == null || itemCode.length() == 0 || submit.equals("0")) {
				mav = new ModelAndView(viewName);
				return mav;
			}
			else if(submit.equals("1")){
				List infoList = productionService.selectAllProductionPlanInfo(itemCode,startDate,endDate);
				mav = new ModelAndView(viewName);				
				mav.addObject("infoList", infoList);
			}				
			return mav;
	  	}
  
	  @Override
	  @RequestMapping(value="/member/itemCodePop.do" ,method = RequestMethod.GET)
		public ModelAndView itemCodeSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String viewName = getViewName(request);
			List itemView = productionService.itemCodeSearch();
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("itemView", itemView);
			return mav;
		}
//	생산계획 등록 CRUD
	  	@Override
		@RequestMapping(value="/member/delProductionPlan.do" ,method = RequestMethod.GET)
		public ModelAndView delProductionPlan(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String number = (String) request.getParameter("productionPlanCode");
			String viewName = getViewName(request);
			String[] codeArary = number.split(",");
			productionService.delProductionPlan(codeArary);
			ModelAndView mav = new ModelAndView("redirect:/member/proplanreg.do");
			return mav;
			}
	  
	  	@Override
		@RequestMapping(value="/member/addProductionPlan.do" ,method = RequestMethod.GET)
		public ModelAndView addProductionPlan(@ModelAttribute("info") CommitOperationInstructionVO COIVO, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
			String path = request.getParameter("path");
			path = path.replace("/webERP", "");
			System.out.println("url" + path);
			int result = 0;
			result = productionService.addProductionPlan(COIVO);
			ModelAndView mav = new ModelAndView("redirect:"+path);
			return mav;
		}
//	작업지시등록 기능 부
  @Override
  @RequestMapping(value="/member/regoperins.do" ,method = RequestMethod.GET)
  public ModelAndView listOpertaionInfo(HttpServletRequest request, HttpServletResponse response) throws Exception { 
	  String startDate = request.getParameter("startDate");
	  String endDate = request.getParameter("endDate");
	  String viewName = (String)request.getAttribute("viewName");
	  logger.debug("debug �젅諛� : viewName = " + viewName); 
	  List infoList = productionService.selectAllOperationInfo(startDate, endDate); 
	  ModelAndView mav = new ModelAndView(viewName); 
	  mav.addObject("infoList", infoList); 
	  return mav; 
  	}
  
  @Override
  @RequestMapping(value="/member/factorySearch.do" ,method = RequestMethod.GET)
	public ModelAndView codeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List itemView = productionService.itemView();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("itemView", itemView);
		return mav;
	}
  
  @Override
  @RequestMapping(value="/member/departmentSearch.do" ,method = RequestMethod.GET)
	public ModelAndView departmentSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List departmentView = productionService.departmentView();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("departmentView", departmentView);
		return mav;
	}
  
  @Override
  @RequestMapping(value="/member/productionPlanSearch.do",method = RequestMethod.GET)
  	public ModelAndView productionPlanSearch(HttpServletRequest request, HttpServletResponse response) throws Exception{
	  String viewName = getViewName(request);
	  ModelAndView mav = new ModelAndView(viewName);
	  return mav;
  }
  
  @Override
  @RequestMapping(value="/member/productionPlanResponse.do",method = RequestMethod.GET)
  	public ModelAndView productionPlanResposne(HttpServletRequest request, HttpServletResponse response) throws Exception{
	  String startDate = request.getParameter("dateStart");
	  String endDate = request.getParameter("dateEnd");
	  String viewName = getViewName(request);
	  List productionPlanView = productionService.productionPlanView(startDate, endDate);
	  ModelAndView mav = new ModelAndView(viewName);
	  mav.addObject("productionPlanView", productionPlanView);
	  return mav;
  }
  
  	@Override
	@RequestMapping(value="/member/addOperationInstruction.do" ,method = RequestMethod.GET)
	public ModelAndView addOperationInstruction(@ModelAttribute("info") OperationRegistVO ORVO, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String path = request.getParameter("path");
		path = path.replace("/webERP", "");
		System.out.println("url" + path);
		int result = 0;
		result = productionService.addOperationInstruction(ORVO);
		ModelAndView mav = new ModelAndView("redirect:"+path);
		return mav;
	}
  
  	@Override
  	@RequestMapping(value="/member/updateOperationInstruction.do" ,method = RequestMethod.GET)
  	public ModelAndView updOperationInstruction(@ModelAttribute("info") OperationRegistVO ORVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
	  		request.setCharacterEncoding("utf-8");
	  		int result = 0;
	  		result = productionService.updOperationInstruction(ORVO);
	  		System.out.println("result "+result);
	  		ModelAndView mav = new ModelAndView("redirect:/member/regoperins.do");
	  		return mav;
  		}
  	
  	@Override
	@RequestMapping(value="/member/delOperationInstruction.do" ,method = RequestMethod.GET)
	public ModelAndView delOperationInstruction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String number = (String) request.getParameter("workOrderNumber");
		String viewName = getViewName(request);
		String[] numberary = number.split(",");
		productionService.delOperationInstruction(numberary);
		ModelAndView mav = new ModelAndView("redirect:/member/regoperins.do");
		return mav;
		}
  
  private String getViewName(HttpServletRequest request) throws Exception {
	  String contextPath = request.getContextPath(); 
	  String uri = (String) request.getAttribute("javax.servlet.include.request_uri"); 
	  if (uri == null || uri.trim().equals("")) { uri = request.getRequestURI(); 
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
  		viewName = viewName.substring(viewName.lastIndexOf("/",1), viewName.length()); 
  		} 
  	return viewName; 
  	} 
 }
 