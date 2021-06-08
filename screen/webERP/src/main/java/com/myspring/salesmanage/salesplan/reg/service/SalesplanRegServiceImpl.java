package com.myspring.salesmanage.salesplan.reg.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.salesmanage.salesplan.dao.SalesplanDAO;
import com.myspring.salesmanage.salesplan.vo.SalesplanVO;


@Service("salesplanRegService")
@Transactional(propagation = Propagation.REQUIRED)
public class SalesplanRegServiceImpl implements SalesplanRegService{

	@Autowired
	private SalesplanDAO salesplanDAO;

	@Override
	public List listSalesplans() throws DataAccessException {
		List salesplansList = null;
		salesplansList = salesplanDAO.selectAllSalesplanList();
		return salesplansList;
	}

	@Override
	public int addSalesplan(SalesplanVO salesplan) throws DataAccessException{
		return salesplanDAO.insertSalesplan(salesplan);
	}
	
	@Override
	public int addNewSalesplan(SalesplanVO salesplan) throws DataAccessException {
		return salesplanDAO.insertSalesplan(salesplan);

	}

	@Override
	public int removeSalesplan(String Item_Code) throws DataAccessException {
		return salesplanDAO.deleteSalesplan(Item_Code);
	}

	@Override
	public SalesplanVO searchCode(String Item_Code) throws Exception {
		return salesplanDAO.searchByItemCode(Item_Code);
	}

	@Override
	public SalesplanVO searchName(Date Plan_Date) throws Exception {
		return salesplanDAO.searchByPlanDate(Plan_Date);
	}

	@Override
	public SalesplanVO searchDate(String Item_Group_Code) throws Exception {
		return salesplanDAO.searchByItemGroup(Item_Group_Code);
	}



}
