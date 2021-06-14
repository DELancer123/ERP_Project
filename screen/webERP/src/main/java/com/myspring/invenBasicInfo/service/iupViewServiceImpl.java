package com.myspring.invenBasicInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.myspring.invenBasicInfo.regItemUnitPrice.dao.iupViewDAO;
import com.myspring.invenBasicInfo.regItemUnitPrice.vo.iupVO;

@Service("iupService")
@Transactional(propagation = Propagation.REQUIRED)
public class iupViewServiceImpl implements iupViewService{
	@Autowired
	private iupViewDAO iupDAO;
	
	@Override
	public List iupView() throws DataAccessException{
		List iupList = null;
		iupList = iupDAO.viewIup();
		return iupList;
	}
	
	@Override
	public List itemView() throws DataAccessException{
		List popList = null;
		popList = iupDAO.viewPop();
		return popList;
	}
	
	@Override
	public List setText(String itemCode) throws DataAccessException{
		List searchList = null;
		searchList = iupDAO.setText(itemCode);
		return searchList;
	}
	
	@Override
	public List searchView(String itemCode) throws DataAccessException{
		List searchList = null;
		searchList = iupDAO.searchView(itemCode);
		return searchList;
	}
	
	@Override
	public List itemSet() throws DataAccessException{
		List itemSet = null;
		/* itemSet=iupDAO.itemSet(); */
		return null;
	}
	
	@Override
	public int addIup(iupVO iupVO) throws DataAccessException{
		return iupDAO.addIup(iupVO);
	}
	
	@Override
	public void delIup(String[] noary) throws DataAccessException{
		iupDAO.delIup(noary);
	}
	
	@Override
	public int updateIup(iupVO iupVO) throws DataAccessException{
		return iupDAO.updateIup(iupVO);
	}
	
	@Override
	public int inputNo() throws DataAccessException{
		return iupDAO.selNo();
	}
}
