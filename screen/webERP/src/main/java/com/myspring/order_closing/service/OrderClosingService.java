package com.myspring.order_closing.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.order_closing.vo.OrderClosingVO;

public interface OrderClosingService {

	int updateOrderClosing(OrderClosingVO vo) throws DataAccessException;

	List<OrderClosingVO> selectAllClosingList(String startDate, String endDate) throws Exception;

}
