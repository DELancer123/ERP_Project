package com.myspring.Requiredamount.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.Requiredamount.vo.RequiredamountVO;

public interface RequiredamountDAO {

	List selectAllMrpList() throws Exception;

	int updateMRP(RequiredamountVO vo) throws DataAccessException;

}
