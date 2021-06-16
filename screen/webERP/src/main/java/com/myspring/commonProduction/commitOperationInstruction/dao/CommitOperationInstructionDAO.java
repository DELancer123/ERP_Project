package com.myspring.commonProduction.commitOperationInstruction.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.commonProduction.commitOperationInstruction.vo.CommitOperationInstructionVO;

public interface CommitOperationInstructionDAO {
	
	public List selectAllProductionPlanInfo(String itemNumber) throws DataAccessException;
	public List itemCodeViewPop() throws DataAccessException;

}
