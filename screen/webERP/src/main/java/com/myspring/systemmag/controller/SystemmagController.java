package com.myspring.systemmag.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;
import com.myspring.systemmag.vo.SystemmagVO;
//ȸ����
public interface SystemmagController {
	public ModelAndView addCompany (@ModelAttribute("company") SystemmagVO company,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewCompany(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView delCompany(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView adressZip(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//�������
	public ModelAndView addWorkplace(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewWorkplace(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updWorkplace(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView delWorkplace(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//�μ����
	public ModelAndView addDepartment(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//ǰ����
	public ModelAndView viewItem(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//ǰ�񱺵��
	public ModelAndView viewItemg(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//�����ȸ
	public ModelAndView viewemployee(HttpServletRequest request, HttpServletResponse response) throws Exception;
	//�μ����
	public ModelAndView viewdepartment(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
