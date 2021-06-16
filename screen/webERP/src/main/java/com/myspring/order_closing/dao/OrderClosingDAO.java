package com.myspring.order_closing.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.order_closing.vo.OrderClosingVO;

public interface OrderClosingDAO {

	List selectAllClosingList() throws Exception;

	int updateOrderClosing(OrderClosingVO vo) throws DataAccessException;

}
