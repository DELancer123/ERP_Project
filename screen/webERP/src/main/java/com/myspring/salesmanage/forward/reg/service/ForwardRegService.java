package com.myspring.salesmanage.forward.reg.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.forward.vo.ForwardVO;

public interface ForwardRegService {

	//pop1 cust
	public List listCusts() throws DataAccessException;
	//pop2
	public List listCust() throws DataAccessException;
	//list by forward regstration
	public List submitCust(String custCode) throws DataAccessException;
	public List listSupForward() throws DataAccessException;
	//list by forward regstration
	public List submitCustByInsert(String custCode) throws DataAccessException;
	//add by forward
	public int addForward(ForwardVO forwardVO) throws DataAccessException;
	//delete by forward
	public void removeForward(String[] noary) throws DataAccessException;
	
	public void submitItemInfo(String[] noary) throws DataAccessException;
	
}
