package com.myspring.salesmanage.forward.reg.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface ForwardRegService {

	//cust
	public List listCusts() throws DataAccessException;
	
	//list by forward regstration
	public List submitCust(String custCode) throws DataAccessException;
	public List listRegForward() throws DataAccessException;
	
	
	//cust by insert
	public List listCust() throws DataAccessException;
		
	//list by forward regstration
	public List submitCustByInsert(String custCode) throws DataAccessException;
	public List listForwardCust() throws DataAccessException;
	//delete by forward
	public int inputNo() throws DataAccessException;
	public void removeForward(String[] noary) throws DataAccessException;
	
}
