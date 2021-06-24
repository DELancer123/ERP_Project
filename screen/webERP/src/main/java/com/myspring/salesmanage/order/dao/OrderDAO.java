package com.myspring.salesmanage.order.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.salesmanage.order.vo.OrderVO;

public interface OrderDAO {
	
	//sta, reg
	public List selectAllOrderList() throws DataAccessException;
	public List selectAllCustList() throws DataAccessException;
	public List submitOrderCust(String custCode) throws DataAccessException;
	
	
	//reg-insert
	public int addOrder(OrderVO orderVO) throws DataAccessException;
	public List selectLine(String custCode) throws DataAccessException;
	
	//reg
	public int selOrdCode() throws DataAccessException;
//	public String selOrdCode() throws DataAccessException;
	public void delOrder(String[] noary) throws DataAccessException;		
//	public int updNewOrder(String custCode) throws DataAccessException;
	
//	public List selectItemGroupList() throws DataAccessException;
//	public List addGroup(String groupcode) throws DataAccessException;
//	public List submitGroupView(String groupcode) throws DataAccessException;

}
