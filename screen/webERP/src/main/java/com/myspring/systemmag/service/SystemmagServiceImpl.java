package com.myspring.systemmag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.systemmag.dao.SystemmagDAO;
import com.myspring.systemmag.vo.SystemmagVO;

@Service("systemmagService")
@Transactional(propagation=Propagation.REQUIRED)
public class SystemmagServiceImpl implements SystemmagService {
	@Autowired
	private SystemmagDAO systemmagDAO;
	
	@Override
	public void addCompany (SystemmagVO systemmagVO) throws Exception{
		systemmagDAO.insertNewCompany(systemmagVO);
}
}