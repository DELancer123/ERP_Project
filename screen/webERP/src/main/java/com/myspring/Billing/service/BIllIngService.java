package com.myspring.Billing.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.Billing.List.vo.ListVO;
import com.myspring.Billing.vo.BIllIngVO;
import com.myspring.Requiredamount.vo.RequiredamountVO;

public interface BIllIngService {

	List<BIllIngVO> selectAllcmList() throws Exception;

	List<ListVO> selectAllBottomList() throws Exception;

	List<RequiredamountVO> selectAllMrpaMount() throws Exception;

	void delbilling(String[] noary) throws DataAccessException;

}
