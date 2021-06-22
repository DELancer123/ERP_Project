package com.myspring.order_closing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.MainPlan.vo.MainPlanVO;
import com.myspring.order_closing.dao.OrderClosingDAO;
import com.myspring.order_closing.vo.OrderClosingVO;

@Service("orderclosingService")
@Transactional(propagation = Propagation.REQUIRED)
public class OrderClosingServiceImpl implements OrderClosingService{
	@Autowired
	private OrderClosingDAO orderclosingDAO;

	@Override
	public List<OrderClosingVO>selectAllClosingList(String startDate, String endDate) throws Exception{
		List<OrderClosingVO> ClosingList = orderclosingDAO.selectAllClosingList(startDate,endDate);
		return ClosingList;
	}
	
	@Override
	public void updateOrderClosing(String[] noary) throws DataAccessException {
		orderclosingDAO.updateOrderClosing(noary);
	}
	
	@Override
	public void delClosing(String[] noary) throws DataAccessException{
		orderclosingDAO.delClosing(noary);
	}

	@Override
	public int addClosing(OrderClosingVO vo) throws DataAccessException {
		return orderclosingDAO.addClosing(vo);
	}
}
