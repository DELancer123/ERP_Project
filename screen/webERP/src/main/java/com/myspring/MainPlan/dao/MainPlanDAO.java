package com.myspring.MainPlan.dao;

import java.text.ParseException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import com.myspring.MainPlan.vo.MainPlanVO;

public interface MainPlanDAO {

	List selectAllMpsosList() throws Exception;

	void delMps(String[] noary) throws DataAccessException;

	int addMPS(MainPlanVO vo) throws DataAccessException;

	int updateMPS(MainPlanVO vo) throws DataAccessException;

	List selectAllMainPlanList(String startDate, String endDate) throws Exception;
}
