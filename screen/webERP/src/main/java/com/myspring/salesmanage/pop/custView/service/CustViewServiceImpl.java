//package com.myspring.salesmanage.pop.custview.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//
//import com.myspring.salesmanage.pop.custview.dao.CustViewDAO;
//import com.myspring.salesmanage.pop.custview.vo.CustViewVO;
//
//@Service("custviewService")
//public class CustViewServiceImpl implements CustViewService{
//	@Autowired
//	private CustViewDAO custviewDAO;
//
//	@Override
//	public List listCusts() throws DataAccessException {
//		List allCustsList = null;
//		allCustsList = custviewDAO.selectAllCustList();
//		return allCustsList;
//	}
//
//	@Override
//	public int addCust(CustViewVO custview) throws DataAccessException {
//		return custviewDAO.insertCust(custview);
//	}
//
//	@Override
//	public int removeCust(String custCode) throws DataAccessException {
//		return custviewDAO.deleteCust(custCode);
//	}
//
//
//}
