package com.myspring.Requiredamount.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.Requiredamount.vo.RequiredamountVO;

public interface RequiredamountService {

	List<RequiredamountVO> selectAllMrpList() throws Exception;

	int updateMRP(RequiredamountVO vo) throws DataAccessException;

}
