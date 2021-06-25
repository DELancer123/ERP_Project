package com.myspring.MainPlan.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.MainPlan.MpsOS.vo.MpsOSVO;
import com.myspring.MainPlan.vo.MainPlanVO;

public interface MainPlanService {

	void delMps(String[] noary) throws DataAccessException;

	int addMPS(MainPlanVO vo) throws DataAccessException;

	int updateMPS(MainPlanVO vo) throws DataAccessException;

	//List<MainPlanVO> selectAllMainPlanList(String startDate, String endDate) throws Exception;

	List<MpsOSVO> selectAllMpsosList(String startDate, String endDate) throws Exception;

	List<MpsOSVO> searchMPSOS(String itemName);

	List viewMPS() throws DataAccessException;

	int inputSeq() throws DataAccessException;

	List setText(String itemNumber) throws DataAccessException;

	List SearchView(String itemNumber) throws DataAccessException;


}
