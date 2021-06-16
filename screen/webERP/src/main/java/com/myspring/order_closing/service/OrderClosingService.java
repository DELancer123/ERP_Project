package com.myspring.order_closing.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.order_closing.vo.OrderClosingVO;

public interface OrderClosingService {

	List<OrderClosingVO> selectAllClosingList() throws Exception;

	int updateOrderClosing(OrderClosingVO vo) throws DataAccessException;

}
