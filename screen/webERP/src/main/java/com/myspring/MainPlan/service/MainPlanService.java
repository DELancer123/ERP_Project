package com.myspring.MainPlan.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.MainPlan.MpsOS.vo.MpsOSVO;
import com.myspring.MainPlan.vo.MainPlanVO;

public interface MainPlanService {
	List<MainPlanVO> selectAllMainPlanList() throws Exception;

	List<MpsOSVO> selectAllMpsosList() throws Exception;

	void delMps(String[] noary) throws DataAccessException;

	boolean updateMps(MainPlanVO vo);

	MainPlanVO viewDetail(int sequence);

	int addMPS(MainPlanVO vo) throws DataAccessException;

	List<MainPlanVO> selectAllMpsList(String startDate, String endDate) throws DataAccessException, ParseException;

}
