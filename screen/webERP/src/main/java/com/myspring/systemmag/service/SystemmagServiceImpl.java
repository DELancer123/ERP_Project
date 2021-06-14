package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.systemmag.dao.SystemmagDAO;
import com.myspring.systemmag.vo.SystemmagVO;

@Service("SystemmagService")
@Transactional(propagation=Propagation.REQUIRED)
public class SystemmagServiceImpl implements SystemmagService {
	@Autowired
	private SystemmagDAO systemmagDAO;
	
	@Override
	public int addCompany (SystemmagVO systemmagVO) throws Exception{
		int result = systemmagDAO.insertNewCompany(systemmagVO);
		return result;
}

	@Override
	public List comView() throws DataAccessException {
		List comList = null;
		comList = systemmagDAO.viewCom();
		System.out.println("sercom :"+comList);
		return comList;
	}
	
	@Override
	public List comcom(String com_code) throws DataAccessException {
		List comList = systemmagDAO.allviewCom(com_code);
		return comList;
	}

	@Override
	public List delcom(String com_code) throws DataAccessException {
		List comList = systemmagDAO.deleteCom(com_code);
		return comList;
	}
	
	
}