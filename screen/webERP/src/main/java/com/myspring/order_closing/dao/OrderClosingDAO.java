package com.myspring.order_closing.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.order_closing.vo.OrderClosingVO;

public interface OrderClosingDAO {

	int updateOrderClosing(OrderClosingVO vo) throws DataAccessException;

	List selectAllClosingList(String startDate, String endDate) throws Exception;

}
