package com.myspring.productionBaseInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.myspring.productionBaseInfo.BOM.dao.bomViewDAO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;
@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)

public class BomViewServiceImpl implements BomViewService{
	@Autowired
	private bomViewDAO bomDAO;
	
	@Override
	public List bomView() throws DataAccessException {
		List bomList = null;
		bomList = bomDAO.viewBOM();
		return bomList;
	}

	@Override
	public List itemView() throws DataAccessException {
		List popList = null;
		popList = bomDAO.viewPop();
		return popList;
	}

	@Override
	public List setText(String itemNumber) throws DataAccessException {
		List searchList = null;
		searchList = bomDAO.setText(itemNumber);
		return searchList;
	}

	@Override
	public List SearchView(String itemNumber) throws DataAccessException {
		List searchList = null;
		searchList = bomDAO.SearchView(itemNumber);
		return searchList;
	}

	@Override
	public List itemSet() throws DataAccessException {
		List itemSet = null;
		/* itemSet = bomDAO.itemSet(); */
		return null;
	}

	@Override
	public int addBOM(bomVO bomVO) throws DataAccessException {
		return bomDAO.addBOM(bomVO);
	}
	
	@Override

	public void delBOM(String itemCode) throws DataAccessException{
		bomDAO.delBOM(itemCode);
	}


	public int updateBOM(bomVO bomVO) throws DataAccessException {
		return bomDAO.updateBOM(bomVO);
	}

}
