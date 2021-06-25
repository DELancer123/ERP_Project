package com.myspring.salesmanage.order.reg.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.order.vo.OrderVO;

public interface OrderRegDAO {
	
	//pop
	public List selectAllCustList() throws DataAccessException;	
	//super reg
	public List selectSupOrderList() throws DataAccessException;
	public List submitOrdCustSupReg(String custCode) throws DataAccessException;

	
//	public List RegOrderSubList() throws DataAccessException;
//	public List submitOrdSubReg(String ordCode) throws DataAccessException;
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	
//	//reg-delete
//	public int selOrdCode() throws DataAccessException;
//	public void delOrder(String[] noary) throws DataAccessException;
//	
//	//reg-insert
//	public int addOrder(OrderVO orderVO) throws DataAccessException;
//	public List selectLine(String custCode) throws DataAccessException;
//
////	public int updNewOrder(String custCode) throws DataAccessException;
//	
////	public List selectItemGroupList() throws DataAccessException;
////	public List addGroup(String groupcode) throws DataAccessException;
////	public List submitGroupView(String groupcode) throws DataAccessException;

}
