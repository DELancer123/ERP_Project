
 package com.myspring.commonProduction.service;
  
  import java.text.ParseException;
import java.util.List;
  
  import org.springframework.dao.DataAccessException;
  
  import com.myspring.commonProduction.commitOperationInstruction.vo.
  CommitOperationInstructionVO; import
  com.myspring.commonProduction.operationRegist.vo.OperationRegistVO;
  
  public interface CommonProductionService {
  
  public List selectAllProductionPlanInfo(String itemNumber, String startDate, String endDate) throws DataAccessException, ParseException; 
  public List<OperationRegistVO> selectAllOperationInfo(String startDate, String endDate) throws DataAccessException, ParseException;
  public List itemView() throws DataAccessException;
  public List departmentView() throws DataAccessException;
  public List productionPlanView(String startDate, String endDate) throws DataAccessException, ParseException;
  public int addOperationInstruction(OperationRegistVO ORVO) throws DataAccessException;
  public void delOperationInstruction(String[] numberAry) throws DataAccessException;
  public int updOperationInstruction(OperationRegistVO ORVO) throws DataAccessException;
  public List itemCodeSearch() throws DataAccessException;
  public void delProductionPlan(String[] numberAry) throws DataAccessException;
  public int addProductionPlan(CommitOperationInstructionVO COIVO) throws DataAccessException;
  public int updProductionPlan(CommitOperationInstructionVO COIVO) throws DataAccessException;
  public List<OperationRegistVO> selectAllCommitOperationInfo(String startDate, String endDate)	throws DataAccessException, ParseException;  
  }
 