package com.myspring.salesmanage.order.sta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.myspring.salesmanage.order.dao.OrderDAO;

@Service("orderStaService")
public class OrderStaServiceImpl implements OrderStaService {

	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public List listOrder() throws DataAccessException {
		List orderList = null;
		orderList = orderDAO.selectOrderCorList();
		return orderList;
	}//COR"."GENERAL_CUSTOMER_CODE"

	@Override
	public List listCusts() throws DataAccessException {
		List orderCustList = null;
		orderCustList = orderDAO.selectAllCustList();
		return orderCustList;
	}

	@Override
	public List submitCust(String custCode) throws DataAccessException {
		List submitOrderCust = null;
		submitOrderCust = orderDAO.submitOrderCust(custCode);
		return submitOrderCust;
	}

}
