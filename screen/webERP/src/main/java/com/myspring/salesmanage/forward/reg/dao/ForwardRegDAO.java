package com.myspring.salesmanage.forward.reg.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.cor.vo.CorVO;
import com.myspring.salesmanage.forward.vo.ForwardVO;
import com.myspring.salesmanage.salesplan.vo.spVO;

public interface ForwardRegDAO {

	//pop
	public List selectAllCustList() throws DataAccessException;	
	//super reg
	public List submitForwardCustSupReg(String custCode) throws DataAccessException;
	public List selectSupForwardList() throws DataAccessException;
	public void delSupForward(String[] forwardCodeary) throws DataAccessException;
	public int addForwarding(ForwardVO forwardVO) throws DataAccessException;
	public int updForward(ForwardVO forwardVO) throws DataAccessException;
	public List ChildView() throws DataAccessException;
	
//	public List submitSubForwardCustReg(String relCode) throws DataAccessException;
//	public List selectForwardSubList() throws DataAccessException;
//	public int addForwardItem(CorVO forwardItemVO) throws DataAccessException;
//	public void delForwardItem(String[] itemCodeary) throws DataAccessException;
//	public List forwardChildView() throws DataAccessException;
}
