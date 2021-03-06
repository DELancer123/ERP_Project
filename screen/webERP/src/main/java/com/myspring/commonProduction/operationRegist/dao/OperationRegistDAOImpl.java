package com.myspring.commonProduction.operationRegist.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.commonProduction.commitOperationInstruction.vo.CommitOperationInstructionVO;
import com.myspring.commonProduction.operationRegist.vo.DepartmentViewVO;
import com.myspring.commonProduction.operationRegist.vo.FacilitySearchVO;
import com.myspring.commonProduction.operationRegist.vo.FactoryViewVO;
import com.myspring.commonProduction.operationRegist.vo.OperationDetailVO;
import com.myspring.commonProduction.operationRegist.vo.OperationRegistVO;
import com.myspring.productionBaseInfo.BOM.vo.bomVO;



@Repository("OperationRegistDAO")
public class OperationRegistDAOImpl implements OperationRegistDAO{
   @Autowired
   private SqlSession sqlSession;
   
   @Override
   public List selectAllOperationInfo(String startDate, String endDate) throws DataAccessException, ParseException {
      List<OperationRegistVO> infoList = null;
      
      if(startDate != null && startDate !=  "" && endDate != null && endDate != "") {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date start = new Date(sdf.parse(startDate).getTime());
      Date end = new Date(sdf.parse(endDate).getTime());
      CommitOperationInstructionVO COIvo = new CommitOperationInstructionVO();
      COIvo.setStartDate(start);
      COIvo.setEndDate(end);
      infoList = sqlSession.selectList("mappers.erp.selectAllOperationRegistInfoCondition", COIvo);
      } else {
         infoList = sqlSession.selectList("mappers.erp.selectAllOperationRegistInfo");
      }
      
      return infoList;
   }
   
   @Override
   public List viewPop() throws DataAccessException {
      List<FactoryViewVO> popList = null;
      popList = sqlSession.selectList("mappers.erp.selectFactoryList");
      return popList;
   }
   
   @Override
   public List departmentViewPop() throws DataAccessException {
      List<DepartmentViewVO> popList = null;
      popList = sqlSession.selectList("mappers.erp.selectDepartmentList");
      return popList;
   }
   
   @Override
   public List productionPlanPop(String startDate, String endDate) throws DataAccessException, ParseException {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date start = new Date(sdf.parse(startDate).getTime());
      Date end = new Date(sdf.parse(endDate).getTime());
      CommitOperationInstructionVO COIvo = new CommitOperationInstructionVO();
      COIvo.setStartDate(start);
      COIvo.setEndDate(end);
      List<CommitOperationInstructionVO> COIList = null;
      COIList = sqlSession.selectList("mappers.erp.selectProductionPlanList", COIvo);
      return COIList;
   }
   
   @Override
   public int addOperationInstruction(OperationRegistVO ORVO) throws DataAccessException {
      int idx = ORVO.getListVO().size()-1;
      int result = sqlSession.insert("mappers.erp.insertOperationInstruction",ORVO.getListVO().get(idx));
      return 0;
   }
   
   @Override
   public int updOperationInstruction(OperationRegistVO ORVO) throws DataAccessException {
      int result = 0; 

      int idx = ORVO.getListVO().size()-1;
      for(int i = 0; i<idx;i++) {
         System.out.println("i"+i);
      System.out.println("idx : "+idx);
      result = sqlSession.update("mappers.erp.updateOperationInstruction",ORVO.getListVO().get(i));      
      System.out.println("DAOresult:"+result);
      //bomList.add(bomVO);
      //}
      }
      return result;
   }
   
   @Override
   public void delOperationInstruction(String[] numberAry) throws DataAccessException{
      for(String obj: numberAry) {
         String check = sqlSession.selectOne("mappers.erp.checkConfirmDetail", obj);
         if(check.equals("??????")) {
        	 sqlSession.delete("mappers.erp.deleteOperationInstruction", obj);
         } else {
            System.out.println("??????,?????? ????????? ????????? ????????? ??? ????????????.");
            continue;
         }
      }
   }
   
   @Override
	public List facilityViewPop() throws DataAccessException {
		List<FacilitySearchVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.selectFacilitySearch");
		return popList;
	}
   
//   ?????????????????? ?????????
   @Override
   public List selectAllCommitOperationInfo(String startDate, String endDate) throws DataAccessException, ParseException {
      List<OperationRegistVO> infoList = null;
      
      if(startDate != null && startDate !=  "" && endDate != null && endDate != "") {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Date start = new Date(sdf.parse(startDate).getTime());
      Date end = new Date(sdf.parse(endDate).getTime());
      CommitOperationInstructionVO COIvo = new CommitOperationInstructionVO();
      COIvo.setStartDate(start);
      COIvo.setEndDate(end);
      infoList = sqlSession.selectList("mappers.erp.selectAllOperationRegistInfoCondition", COIvo);
      } else {
         infoList = sqlSession.selectList("mappers.erp.selectAllOperationRegistInfo");
      }
      
      return infoList;
   }
   
   @Override
   public List selectAllCommitOperationInfoDetail(String number) throws DataAccessException, ParseException {
      List<OperationDetailVO> infoList = null;      
      infoList = sqlSession.selectList("mappers.erp.selectAllOperationRegistDetail", number);
      return infoList;
   }
   
   @Override
   public int delCommitOperation(OperationDetailVO ODVO) throws DataAccessException {
      int result = 0; 
      String workOrderNumber = sqlSession.selectOne("mappers.erp.selectWorkOrderNumber", ODVO.getDetailVO().get(0));

      int idx = ODVO.getDetailVO().size();
      for(int i = 0; i<idx;i++) {     
      result = sqlSession.update("mappers.erp.deleteCommitOperation",ODVO.getDetailVO().get(i));
      sqlSession.update("mappers.erp.deleteStockQuantity",ODVO.getDetailVO().get(i));
      }
      sqlSession.update("mappers.erp.materialSet", workOrderNumber);
      return result;
   }
   
//   ?????? ?????? ?????????
   @Override
   public List<String> confirmDetail(String[] numberAry) throws DataAccessException{
      List<String> message = new ArrayList();
      
      for(String number: numberAry) {
         
         String check = sqlSession.selectOne("mappers.erp.checkConfirmDetail", number);
         if(check.equals("??????")) {
            sqlSession.update("mappers.erp.updConfirmDetail", number);
            message.add("???????????? ??????!");
         } else {
            message.add("??????, ??????????????? ????????? ?????? ??? ??? ????????????!");
         }
      }
      return message;
   }
   
   @Override
   public List<String> revertDetail(String[] numberAry) throws DataAccessException{
      List<String> message = new ArrayList();
      
      for(String number: numberAry) {
         
         String check = sqlSession.selectOne("mappers.erp.checkConfirmDetail", number);
         System.out.println("?????? ?????? ??????" + check);
         if(check.equals("??????")) {
            message.add("?????? ?????????????????????!");
         } else if(check.equals("??????")) {
            message.add("????????? ????????? ????????? ??? ????????????!");
         } else {
            String count = sqlSession.selectOne("mappers.erp.countWorkOrderNumber",number);
            if(count.equals("0")) {
               sqlSession.update("mappers.erp.updRevertDetail", number);
               message.add("???????????? ??????!");
            } else {
               message.add("?????? ????????? ?????? ?????? ????????? ????????? ??? ????????????!");
            }
         }
      }
      return message;
   }
   
//   ?????????????????? ???????????? ?????????

   @Override
   public List selectRelease(String number) throws DataAccessException, ParseException {
      List<OperationRegistVO> infoList = null;
      
      infoList = sqlSession.selectList("mappers.erp.selectRelease", number);      
      return infoList;
   }
   
   @Override
   public List selectReleaseDetail(String number) throws DataAccessException, ParseException {
      List<OperationRegistVO> infoList = null;
      
      String count = sqlSession.selectOne("mappers.erp.countWorkOrderNumber",number);
      if(count.equals("0")) {
         infoList = sqlSession.selectList("mappers.erp.selectReleaseDetail",number);
      } else {
         System.out.println("?????? ????????? ?????? ???????????????!");
      }
      return infoList;
   }
   
   @Override
   public int addReleaseData(OperationDetailVO ORVO) throws DataAccessException {
      int idx = ORVO.getDetailVO().size();
      int result = 0;
      for(int i = 0; i<idx; i++) {         
      int forwarding = ORVO.getDetailVO().get(i).getPrecisionQuantity()+(ORVO.getDetailVO().get(i).getPrecisionQuantity() / 100 * ORVO.getDetailVO().get(i).getLoss());
      ORVO.getDetailVO().get(i).setForwardingQuantity(forwarding);
      result = sqlSession.insert("mappers.erp.insertReleaseData",ORVO.getDetailVO().get(i));
      int result2 = sqlSession.update("mappers.erp.updateStockQuantity",ORVO.getDetailVO().get(i));
      System.out.println("???????????? ??????"+result2);
      }
      if(result != 0) { 
    	  sqlSession.update("mappers.erp.updateMaterialUse",ORVO.getDetailVO().get(0));
      }
      return 0;
   }
}