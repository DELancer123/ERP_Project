package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagService {
	//회사등록
	public int addCompany(SystemmagVO systemmagVO) throws Exception;
	public List comView() throws DataAccessException;
	public List comcom(String com_code) throws DataAccessException;
	//사업장등록
	public List worView() throws DataAccessException;
	public List worcom(String wor_code) throws DataAccessException;
	//품목등록
	public List itemView() throws DataAccessException;
	public List comitem(String wor_code) throws DataAccessException;
}
