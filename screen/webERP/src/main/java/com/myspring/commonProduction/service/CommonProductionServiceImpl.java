
 package com.myspring.commonProduction.service;
 
 import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired; import
 org.springframework.dao.DataAccessException; import
  org.springframework.stereotype.Service; import
  org.springframework.transaction.annotation.Propagation; import
  org.springframework.transaction.annotation.Transactional;
  
  import com.myspring.commonProduction.commitOperationInstruction.dao.
  CommitOperationInstructionDAO; import
  com.myspring.commonProduction.commitOperationInstruction.vo.
  CommitOperationInstructionVO; import
  com.myspring.commonProduction.operationRegist.dao.OperationRegistDAO; import
  com.myspring.commonProduction.operationRegist.vo.OperationRegistVO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;
  
  
  @Service("CommonProductionService")
  
  @Transactional(propagation = Propagation.REQUIRED) 
  public class CommonProductionServiceImpl implements CommonProductionService {
  @Autowired private CommitOperationInstructionDAO COIdao;
  @Autowired private OperationRegistDAO ORdao;
  
  @Override public List selectAllProductionPlanInfo(String info,String startDate, String endDate) throws DataAccessException, ParseException {
	  List<CommitOperationInstructionVO> infolist = null; 
	  infolist = COIdao.selectAllProductionPlanInfo(info,startDate,endDate);
	  return infolist; 
  }
  
  @Override
  public List itemCodeSearch() throws DataAccessException {
	  List popList = null;
	  popList = COIdao.itemCodeViewPop();
	  return popList;
	}
  
//  생산계획 CUD
  @Override
 	public void delProductionPlan(String[] numberAry) throws DataAccessException{
 		COIdao.delProductionPlan(numberAry);
 	}
  
  @Override
 	public int updProductionPlan(CommitOperationInstructionVO COIVO) throws DataAccessException {
 		return COIdao.updProductionPlan(COIVO);
 	}
  
  @Override
 	public int addProductionPlan(CommitOperationInstructionVO COIVO) throws DataAccessException {
 		return COIdao.addProductionPlan(COIVO);
 	}
//  작업지시등록 CRUD
  @Override public List<OperationRegistVO> selectAllOperationInfo(String startDate, String endDate) throws DataAccessException, ParseException{ 
	  List<OperationRegistVO> infolist = null; 
	  infolist = ORdao.selectAllOperationInfo(startDate,endDate); 
	  return infolist; 
	  }

  @Override
  public List itemView() throws DataAccessException {
	  List popList = null;
	  popList = ORdao.viewPop();
	  return popList;
	}
  
  @Override
  public List departmentView() throws DataAccessException {
	  List popList = null;
	  popList = ORdao.departmentViewPop();
	  return popList;
	}
  
  @Override
  public List productionPlanView(String startDate, String endDate) throws DataAccessException, ParseException {
	  List popList = null;
	  popList = ORdao.productionPlanPop(startDate, endDate);
	  return popList;
  }
  
  @Override
	public int addOperationInstruction(OperationRegistVO ORVO) throws DataAccessException {
		return ORdao.addOperationInstruction(ORVO);
	}

  @Override
	public int updOperationInstruction(OperationRegistVO ORVO) throws DataAccessException {
		return ORdao.updOperationInstruction(ORVO);
	}

  
  @Override
	public void delOperationInstruction(String[] numberAry) throws DataAccessException{
		ORdao.delOperationInstruction(numberAry);
	}
  
//  작업지시확정 기능부
  @Override 
  public List<OperationRegistVO> selectAllCommitOperationInfo(String startDate, String endDate) throws DataAccessException, ParseException{ 
	  List<OperationRegistVO> infolist = null; 
	  infolist = ORdao.selectAllCommitOperationInfo(startDate,endDate); 
	  return infolist; 
	  }
  
  @Override 
  public List<OperationRegistVO> selectAllCommitOperationInfoDetail(String number) throws DataAccessException, ParseException{ 
	  List<OperationRegistVO> infolist = null; 
	  infolist = ORdao.selectAllCommitOperationInfoDetail(number); 
	  return infolist; 
	  }
  
  @Override
	public List<String> confirmDetail(String[] numberAry) throws DataAccessException{
	  List<String> message = new ArrayList(); 
	  message = ORdao.confirmDetail(numberAry);
	  return message;
	}
  }
 