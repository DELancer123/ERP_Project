package com.myspring.invenBasicInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.myspring.invenBasicInfo.regItemUnitPrice.dao.IupViewDAO;
import com.myspring.invenBasicInfo.regItemUnitPrice.vo.IupVO;

@Service("iupService")
@Transactional(propagation = Propagation.REQUIRED)
public class IupViewServiceImpl implements IupViewService{
	@Autowired
	private IupViewDAO iupDAO;
	
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
	public List setText(String Item_Code) throws DataAccessException{
		List searchList = null;
		searchList = iupDAO.setText(Item_Code);
		return searchList;
	}
	
	@Override
	public List searchView(String Item_Code) throws DataAccessException{
		List searchList = null;
		searchList = iupDAO.searchView(Item_Code);
		return searchList;
	}
	
	@Override
	public List itemSet() throws DataAccessException{
		List itemSet = null;
		/* itemSet=iupDAO.itemSet(); */
		return null;
	}
	
	@Override
	public int addIup(IupVO iupVO) throws DataAccessException{
		return iupDAO.addIup(iupVO);
	}
	
	@Override
	public void delIup(String[] noary) throws DataAccessException{
		iupDAO.delIup(noary);
	}
	
	@Override
	public int updateIup(IupVO iupVO) throws DataAccessException{
		return iupDAO.updateIup(iupVO);
	}
	
	@Override
	public int inputNo() throws DataAccessException{
		return iupDAO.selNo();
	}
}
