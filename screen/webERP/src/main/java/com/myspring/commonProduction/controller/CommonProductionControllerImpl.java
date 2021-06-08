
package com.myspring.commonProduction.controller;
  
import java.util.List;
  
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.servlet.ModelAndView;
  
import com.myspring.commonProduction.commitOperationInstruction.vo.CommitOperationInstructionVO; 
import com.myspring.commonProduction.operationRegist.vo.OperationRegistVO; 
import com.myspring.commonProduction.service.CommonProductionService;
 
  @Controller("CommonProductionController") 
  public class CommonProductionControllerImpl implements CommonProductionController{ 
	  private static final Logger logger = LoggerFactory.getLogger(CommonProductionControllerImpl.class);
	  @	Autowired private CommonProductionService productionService;
	  @Autowired private CommitOperationInstructionVO COIVO;
	  @Autowired private OperationRegistVO ORVO;
  
	  @Override
	  @RequestMapping(value="/member/proplanreg.do" ,method = RequestMethod.GET)
  		public ModelAndView listProductInfo(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		  String viewName = (String)request.getAttribute("viewName");
		  logger.debug("debug �젅諛� : viewName = " + viewName); 
		  List infoList = productionService.selectAllProductionPlanInfo();
		  ModelAndView mav = new ModelAndView(viewName); 
		  mav.addObject("infoList", infoList); 
		  return mav; 
	  	}
  
  @Override
  @RequestMapping(value="/member/regoperins.do" ,method = RequestMethod.GET)
  public ModelAndView listOpertaionInfo(HttpServletRequest request, HttpServletResponse response) throws Exception { 
	  String viewName = (String)request.getAttribute("viewName");
	  logger.debug("debug �젅諛� : viewName = " + viewName); 
	  List infoList = productionService.selectAllOperationInfo(); 
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
 