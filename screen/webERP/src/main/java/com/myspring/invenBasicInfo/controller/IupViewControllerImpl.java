package com.myspring.invenBasicInfo.controller;

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

import com.myspring.invenBasicInfo.regItemUnitPrice.vo.IupVO;

@Controller("memberController")
//@EnableAspectAutoProxy
public class IupViewControllerImpl implements IupViewController{
	private static final Logger logger = LoggerFactory.getLogger(IupViewControllerImpl.class);
	@Autowired
	private IupViewService viewService;
	@Autowired
	private IupVO iupVO;
	
	@Override
	@RequestMapping(value="/member/itemunitprice.do",method=RequestMethod.GET);
	public ModelAndView viewIup(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = null;
		String viewName = getViewName(request);
		String number = (String)request.getParameter("Item_Code");
		String submit = (String)request.getParameter("submit");
	}
	
}
