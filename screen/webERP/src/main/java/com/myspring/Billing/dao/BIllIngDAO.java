package com.myspring.Billing.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.Billing.List.vo.ListVO;

public interface BIllIngDAO {

	List selectAllcmList() throws Exception;

	List<ListVO> selectAllBottomList() throws Exception;

	List selectAllMrpaMount() throws Exception;

	void delbilling(String[] noary) throws DataAccessException;

}
