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

}
