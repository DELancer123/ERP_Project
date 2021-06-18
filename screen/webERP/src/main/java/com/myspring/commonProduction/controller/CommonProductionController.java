package com.myspring.commonProduction.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.commonProduction.commitOperationInstruction.vo.CommitOperationInstructionVO;
import com.myspring.commonProduction.operationRegist.vo.OperationRegistVO;

public interface CommonProductionController {

	public ModelAndView listProductInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listOpertaionInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView codeHelper(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView departmentSearch(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView productionPlanSearch(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView productionPlanResposne(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addOperationInstruction(OperationRegistVO ORVO, HttpServletRequest request,	HttpServletResponse response) throws Exception;
	public ModelAndView delOperationInstruction(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updOperationInstruction(OperationRegistVO ORVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView itemCodeSearch(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView delProductionPlan(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addProductionPlan(CommitOperationInstructionVO COIVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updProductionPlan(CommitOperationInstructionVO COIVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView listCommitOpertaionInfo(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
