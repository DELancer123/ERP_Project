package com.myspring.salesmanage.forward.reg.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.cor.vo.CorVO;
import com.myspring.salesmanage.forward.vo.ForwardVO;
import com.myspring.salesmanage.salesplan.vo.spVO;

public interface ForwardRegDAO {

	//pop
	public List selectAllCustList() throws DataAccessException;
	public List selectCustsList() throws DataAccessException;
	//super reg
	public List selectSupForwardList() throws DataAccessException;
	public List submitForwardCustSupReg(String custCode) throws DataAccessException;
	
	//super reg by cust insert
	public List submitForwardReg(String custCode) throws DataAccessException;
	public void delSupForward(String[] forwardCodeary) throws DataAccessException;
	public int addForward(ForwardVO forwardVO) throws DataAccessException;
	public int updForward(ForwardVO forwardVO) throws DataAccessException;
	//subReg-body3
	public List<ForwardVO> submitSubReg(String relCode) throws DataAccessException;
//	public void delItemForward(String[] ItemCodeary) throws DataAccessException;
//	public int addItemForward(ForwardVO forwardVO) throws DataAccessException;
//	public int updItemForward(ForwardVO forwardVO) throws DataAccessException;

}