package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;
import com.myspring.systemmag.vo.WorkplaceVO;

public interface SystemmagService {
	//회사등록
	public int addCom(SystemmagVO systemmagVO) throws Exception;
	public List comView() throws DataAccessException;
	public List comcom(String com_code) throws DataAccessException;
	//사업장등록
	public int addWor(WorkplaceVO workplaceVO) throws Exception;
	public List worView() throws DataAccessException;
	public List worcom(String wor_code) throws DataAccessException;
	//품목등록
	public List itemView() throws DataAccessException;
	public List comitem(String item_code) throws DataAccessException;
	//품목군등록
	public List itemgView() throws DataAccessException;
	//사원조회
	public List employeeView() throws DataAccessException;
	//부서등록
	public List departmentView() throws DataAccessException;
}
