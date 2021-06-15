package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagService {
	//ȸ����
	public int addCompany(SystemmagVO systemmagVO) throws Exception;
	public List comView() throws DataAccessException;
	public List comcom(String com_code) throws DataAccessException;
	//�������
	public List worView() throws DataAccessException;
	public List worcom(String wor_code) throws DataAccessException;
	//ǰ����
	public List itemView() throws DataAccessException;
	public List comitem(String wor_code) throws DataAccessException;
}
