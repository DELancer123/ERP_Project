
 package com.myspring.commonProduction.service;
 
 import java.text.ParseException;
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
  
  @Override public List<CommitOperationInstructionVO> selectAllProductionPlanInfo() throws DataAccessException {
	  List<CommitOperationInstructionVO> infolist = null; 
	  infolist = COIdao.selectAllProductionPlanInfo();
	  return infolist; 
  }
  
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
  }
 