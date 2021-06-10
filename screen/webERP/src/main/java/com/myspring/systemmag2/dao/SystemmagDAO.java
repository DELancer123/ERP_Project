package com.myspring.systemmag2.dao;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagDAO {
	public int insertNewCompany (SystemmagVO systemmagVO) throws DataAccessException;
}
