package com.myspring.salesmanage.forward.reg.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface ForwardRegDAO {

	//pop
	public List selectAllCustList() throws DataAccessException;	
	//super reg
	public List selectSupForwardList() throws DataAccessException;
	public List submitForwardCustSupReg(String custCode) throws DataAccessException;
	public void delSupForward(String[] noary) throws DataAccessException;
	
	public List selectForwardSubList() throws DataAccessException;
	public List submitSubForwardCustReg(String relCode) throws DataAccessException;
}
