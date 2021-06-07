package com.myspring.weberp.salesmanage.salesplan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.weberp.salesmanage.salesplan.dao.SalesplanDAO;
import com.myspring.weberp.salesmanage.salesplan.vo.SalesplanVO;


@Service("salesplanService")
@Transactional(propagation = Propagation.REQUIRED)
public class SalesplanServiceImpl implements SalesplanService{

	@Autowired
	private SalesplanDAO salesplanDAO;

	@Override
	public List listSalesplans() throws DataAccessException {
		// ������ ���� ��ȹ
		List salesplansList = null;
		salesplansList = salesplanDAO.selectAllSalesplanList();
		return salesplansList;
	}//mapper.salesplan.
	


	@Override
	public int addSalesplan(SalesplanVO salesplan) throws DataAccessException {
		// �ǸŰ�ȹ ���
		return salesplanDAO.insertSalesplan(salesplan);
	}
	
	@Override
	public int addNewSalesplan(SalesplanVO salesplan) throws DataAccessException {
		// �ǸŰ�ȹ ������ ���
		return salesplanDAO.insertNewSalesplan(salesplan);
	}


	@Override
	public int removeSalesplan(String Plan_Item_Code) throws DataAccessException {
		
		return salesplanDAO.deleteSalesplan(Plan_Item_Code);
	}



	@Override
	public SalesplanVO searchCode(SalesplanVO salesplanVO) throws Exception {
		// �ڵ�� �˻�
		return salesplanDAO.searchByItemCode(salesplanVO);
	}



	@Override
	public SalesplanVO searchName(SalesplanVO salesplanVO) throws Exception {
		// �̸����� �˻�
		return salesplanDAO.searchByItemName(salesplanVO);
	}



	@Override
	public SalesplanVO searchDate(SalesplanVO salesplanVO) throws Exception {
		// ��¥�� �˻�
		return salesplanDAO.searchByPlanDate(salesplanVO);
	}

}
