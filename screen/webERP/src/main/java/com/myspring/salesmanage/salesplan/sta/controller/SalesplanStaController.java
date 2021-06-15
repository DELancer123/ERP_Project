package com.myspring.salesmanage.salesplan.sta.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.salesmanage.pop.itemgroup.vo.ItemGroupVO;
import com.myspring.salesmanage.pop.itemview.vo.ItemViewVO;
import com.myspring.salesmanage.salesplan.vo.SalesplanVO;

public interface SalesplanStaController {

	public ModelAndView submitItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listAllItem(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
