package com.myspring.systemmag.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.systemmag.vo.SystemmagVO;

public interface SystemmagDAO {
	public int insertNewCompany (SystemmagVO systemmagVO) throws DataAccessException;

	public List viewCom() throws DataAccessException;
	
	public List allviewCom(String com_code) throws DataAccessException;
}
