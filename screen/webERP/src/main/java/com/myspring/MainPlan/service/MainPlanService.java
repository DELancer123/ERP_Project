package com.myspring.MainPlan.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.MainPlan.MpsOS.vo.MpsOSVO;
import com.myspring.MainPlan.vo.MainPlanVO;

public interface MainPlanService {
	List<MainPlanVO> selectAllMainPlanList() throws Exception;

	List<MpsOSVO> selectAllMpsosList() throws Exception;

	void delMps(String[] noary) throws DataAccessException;

	MainPlanVO customer_detail(int Sequence);

	void customer_update(MainPlanVO vo);

}
