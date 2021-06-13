package com.myspring.MainPlan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.MainPlan.vo.MainPlanVO;

public interface MainPlanController {

	ModelAndView listMainPlan(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView MpsOSList(HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView delMps(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
