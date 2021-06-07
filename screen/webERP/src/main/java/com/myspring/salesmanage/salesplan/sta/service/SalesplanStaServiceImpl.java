//package com.myspring.salesmanage.salesplan.sta.service;
//
//import java.sql.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.myspring.salesmanage.salesplan.dao.SalesplanDAO;
//import com.myspring.salesmanage.salesplan.vo.SalesplanVO;
//
//
//@Service("salesplanStaService")
//@Transactional(propagation = Propagation.REQUIRED)
//public class SalesplanStaServiceImpl implements SalesplanStaService{
//
//	@Autowired
//	privte SalesplaanDAO salesplanDAO;
//
//	@Override
//	public List listSalesplans() throws DataAccessException {
//		List salesplansList = null;
//		salesplansList = salesplanDAO.selectAllSalesplanList();
//		return salesplansList;
//	}
//
//	@Override
//	public SalesplanVO searchCode(String Item_Code) throws Exception {
//		return salesplanDAO.searchByItemCode(Item_Code);
//	}
//
//	@Override
//	public SalesplanVO searchDate(Date Plan_Date) throws Exception {
//		return salesplanDAO.searchByPlanDate(Plan_Date);
//	}
//
//	@Override
//	public SalesplanVO searchGroup(String Item_Group_Code) throws Exception {
//		return salesplanDAO.searchByItemGroup(Item_Group_Code);
//	}
//
//	
//
//
//
//}
