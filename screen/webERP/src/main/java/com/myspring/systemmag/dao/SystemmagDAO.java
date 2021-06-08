package com.myspring.systemmag.dao;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagDAO {
	public void insertNewCompany (SystemmagVO systemmagVO) throws DataAccessException;
}
