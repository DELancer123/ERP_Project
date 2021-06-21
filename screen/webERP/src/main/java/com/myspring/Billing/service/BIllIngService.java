package com.myspring.Billing.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.myspring.Billing.vo.BIllIngVO;
import com.myspring.Requiredamount.vo.RequiredamountVO;

public interface BIllIngService {

	List<BIllIngVO> selectAllcmList() throws Exception;

	List<RequiredamountVO> selectAllMrpaMount() throws Exception;

	void delbilling(String[] noary) throws DataAccessException;

	int updatebilling(BIllIngVO vo) throws DataAccessException;

	int addbilling(BIllIngVO vo) throws DataAccessException;

}
