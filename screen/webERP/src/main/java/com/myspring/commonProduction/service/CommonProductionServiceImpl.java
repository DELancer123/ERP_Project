
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
  CommitOperationInstructionVO;
import com.myspring.commonProduction.operationInsClosing.dao.operationInsClosingDAO;
import com.myspring.commonProduction.operationInsClosing.vo.OperationInsClosingVO;
import
  com.myspring.commonProduction.operationRegist.dao.OperationRegistDAO;
import com.myspring.commonProduction.operationRegist.vo.OperationDetailVO;
import
  com.myspring.commonProduction.operationRegist.vo.OperationRegistVO;
import com.myspring.commonProduction.registOperationPerformance.dao.RegistOperationPerformanceDAO;
import com.myspring.commonProduction.registOperationPerformance.vo.RegistOperationPerformanceDetailVO;
import com.myspring.commonProduction.registOperationPerformance.vo.RegistOperationPerformanceVO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;
  
  
  @Service("CommonProductionService")
  
  @Transactional(propagation = Propagation.REQUIRED) 
  public class CommonProductionServiceImpl implements CommonProductionService {
  @Autowired private CommitOperationInstructionDAO COIdao;
  @Autowired private OperationRegistDAO ORdao;
  @Autowired private RegistOperationPerformanceDAO ROPdao;
  @Autowired private operationInsClosingDAO OCdao;
  
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
  public List<OperationDetailVO> selectAllCommitOperationInfoDetail(String number) throws DataAccessException, ParseException{ 
	  List<OperationDetailVO> infolist = null; 
	  infolist = ORdao.selectAllCommitOperationInfoDetail(number); 
	  return infolist; 
	  }
  
  @Override
	public List<String> confirmDetail(String[] numberAry) throws DataAccessException{
	  List<String> message = new ArrayList(); 
	  message = ORdao.confirmDetail(numberAry);
	  return message;
	}
  
  @Override
	public List<String> revertDetail(String[] numberAry) throws DataAccessException{
	  List<String> message = new ArrayList(); 
	  message = ORdao.revertDetail(numberAry);
	  return message;
	}
  
  @Override
  public List<OperationRegistVO> selectRelease(String number) throws DataAccessException, ParseException{ 
	  List<OperationRegistVO> infolist = null; 
	  infolist = ORdao.selectRelease(number); 
	  return infolist; 
	  }
  
  @Override
  public List<OperationRegistVO> selectReleaseDetail(String number) throws DataAccessException, ParseException{ 
	  List<OperationRegistVO> infolist = null; 
	  infolist = ORdao.selectReleaseDetail(number); 
	  return infolist; 
	  }
  

//작업실적등록 기능부
	@Override
	public List<RegistOperationPerformanceVO> selectAllRegistOperationPerformanceInfo(String startDate, String endDate) throws DataAccessException, ParseException{ 
		  List<RegistOperationPerformanceVO> infolist = null; 
		  infolist = ROPdao.selectAllRegistOperationPerformanceInfo(startDate,endDate);
		  return infolist; 
		  }
	
	@Override
	public List<RegistOperationPerformanceVO> selectAllRegistOperationPerformanceInfoDetail(String number) throws DataAccessException, ParseException{ 
		  List<RegistOperationPerformanceVO> infolist = null; 
		  infolist = ROPdao.selectAllRegistOperationPerformanceInfoDetail(number);
		  return infolist; 
		  }
	
	 @Override
	 public int addRegistOperationPerformanceInfoDetail(RegistOperationPerformanceDetailVO ROPDVO) throws DataAccessException {
			return ROPdao.addRegistOperationPerformanceInfoDetail(ROPDVO);
		}

	@Override
		public List<String> MaterialUse(String[] numberAry) throws DataAccessException{
		  List<String> message = new ArrayList(); 
		  ROPdao.MaterialUse(numberAry);
		  return message;
		}
  
//작업지시마감처리 기능부
	@Override 
	public List<OperationInsClosingVO> selectAllOperationInsClosingInfo(String startDate, String endDate) throws DataAccessException, ParseException{ 
		  List<OperationInsClosingVO> infolist = null; 
		  infolist = OCdao.selectAllOperationInsClosingInfo(startDate,endDate);
		  return infolist; 
		  }
	
	@Override
	public List<OperationInsClosingVO> selectAllOperationInsClosingInfoDetail(String number) throws DataAccessException, ParseException{ 
		  List<OperationInsClosingVO> infolist = null; 
		  infolist = OCdao.selectAllOperationInsClosingInfoDetail(number);
		  return infolist; 
		  }

	@Override
		public List<String> closingDetail(String[] numberAry) throws DataAccessException{
		  List<String> message = new ArrayList(); 
		  OCdao.closingDetail(numberAry);
		  return message;
		}
	
	@Override
	public List<String> closingCancleDetail(String[] numberAry) throws DataAccessException{
		List<String> message = new ArrayList(); 
		OCdao.closingCancleDetail(numberAry);
		return message;
	}
	
	
	
	
  }
 