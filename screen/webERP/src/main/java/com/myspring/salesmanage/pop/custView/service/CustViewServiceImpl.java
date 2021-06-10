package com.myspring.salesmanage.pop.custView.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.pop.custView.dao.CustViewDAO;
import com.myspring.salesmanage.pop.custView.vo.CustViewVO;

public class CustViewServiceImpl implements CustViewService{
	@Autowired
	private CustViewDAO custviewDAO;

	@Override
	public List listCusts() throws DataAccessException {
		List allCustsList = null;
		allCustsList = custviewDAO.selectAllCustList();
		return allCustsList;
	}

	@Override
	public int addCust(CustViewVO custview) throws DataAccessException {
		return custviewDAO.insertCust(custview);
	}

	@Override
	public int removeCust(String custCode) throws DataAccessException {
		return custviewDAO.deleteCust(custCode);
	}


}
