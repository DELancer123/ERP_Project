package com.myspring.MainPlan.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface MainPlanDAO {

	List selectAllMainPlanList() throws Exception;

	List selectAllMpsosList() throws Exception;


}
