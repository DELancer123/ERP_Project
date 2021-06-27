package com.myspring.salesmanage.forward.reg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.salesmanage.forward.reg.dao.ForwardRegDAO;

@Service("forwardRegService")
public class ForwardRegServiceImpl implements ForwardRegService {
	
	@Autowired
	private ForwardRegDAO forwardDAO;
	@Override
	public List listCusts() throws DataAccessException {
		List forwardCustList = null;
		forwardCustList = forwardDAO.selectAllCustList();
		return forwardCustList;
	}

	@Override
	public List submitCust(String custCode) throws DataAccessException {
		List submitCustList = null;
		submitCustList = forwardDAO.submitForwardCustSupReg(custCode);
		return submitCustList;
	}

	@Override
	public List listRegForward() throws DataAccessException {
		List supForwardList = null;
		supForwardList = forwardDAO.selectSupForwardList();
		return supForwardList;
	}	


	@Override
	public List listCust() throws DataAccessException {
		List custList = null;
		custList = forwardDAO.selectCustsList();
		return custList;
//		
//		List itemList = null;
//		itemList = forwardDAO.selectCustList();
//		return itemList;
	}//selectAllCustList

	@Override
	public List submitCustByInsert(String custCode) throws DataAccessException {
		List submitCustList = null;
		submitCustList = forwardDAO.submitForwardCustReg(custCode);
		return submitCustList;
	}

	@Override
	public List listForwardCust() throws DataAccessException {
		List supForwardInsert = null;
		supForwardInsert = forwardDAO.selectCustInsert();
		return supForwardInsert;
	}


	@Override
	public int inputNo() throws DataAccessException {
		return forwardDAO.selRelCode();
	}
	@Override
	public void removeForward(String[] noary) throws DataAccessException {
		forwardDAO.delSupForward(noary);
		
	}

}
