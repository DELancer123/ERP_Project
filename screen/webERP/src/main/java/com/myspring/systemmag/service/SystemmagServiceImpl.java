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
	//회사등록 조회
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
	//사업자등록 조회
	@Override
	public List worView() throws DataAccessException {
		List worList = null;
		worList = systemmagDAO.viewWor();
		System.out.println("sercom= :"+worList);
		return worList;
	}

	@Override
	public List worcom(String wor_code) throws DataAccessException {
		List worList = systemmagDAO.allviewWor(wor_code);
		return worList;
	}
	//품목등록
	@Override
	public List itemView() throws DataAccessException {
		List itemList = null;
		itemList = systemmagDAO.viewItem();
		System.out.println("sercom= :"+itemList);
		return itemList;
	}

	@Override
	public List comitem(String item_code) throws DataAccessException {
		List itemList = systemmagDAO.allviewItem(item_code);
		return itemList;
	}
}