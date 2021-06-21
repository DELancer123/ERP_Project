package com.myspring.systemmag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;
import com.myspring.systemmag.dao.SystemmagDAO;
import com.myspring.systemmag.vo.DepartmentVO;
import com.myspring.systemmag.vo.ItemgVO;
import com.myspring.systemmag.vo.SystemmagVO;
import com.myspring.systemmag.vo.WorkplaceVO;
import com.myspring.systemmag.vo.itemVO;

@Service("SystemmagService")
@Transactional(propagation=Propagation.REQUIRED)
public class SystemmagServiceImpl implements SystemmagService {
	@Autowired
	private SystemmagDAO systemmagDAO;
	//회사등록
	@Override
	public int addCom(SystemmagVO systemmagVO) throws DataAccessException{
		return systemmagDAO.addCom(systemmagVO);
}
	//회사등록 조회
	@Override
	public List comView() throws DataAccessException {
		List comList = null;
		comList = systemmagDAO.viewCom();
		System.out.println("sercom :"+comList);
		return comList;
	}
	//회사등록(팝업)
	@Override
	public List zipView(String zipNumber) throws DataAccessException {
		List zipList = null;
		zipList = systemmagDAO.viewZip();
		return zipList;
	}
	@Override
	public List zipText(String zipNumber) throws DataAccessException {
		List searchList = null;
		searchList = systemmagDAO.zipText(zipNumber);
		return searchList;
	}
	@Override
	public List comcom(String com_code) throws DataAccessException {
		List comList = systemmagDAO.allviewCom(com_code);
		return comList;
	}
	//사업장등록
		@Override
		public int addWor(WorkplaceVO workplaceVO) throws DataAccessException{
			return systemmagDAO.addWor(workplaceVO);
	}
	//사업자등록(조회)
	@Override
	public List worView() throws DataAccessException {
		List worList = null;
		worList = systemmagDAO.viewWor();
		System.out.println("sercom= :"+worList);
		return worList;
	}
	@Override
	public List worcom(String wor_code) throws DataAccessException {
		List worList = systemmagDAO.allviewWor(wor_code);
		return worList;
	}
	//품목등록(조회)
	@Override
	public List itemView() throws DataAccessException {
		List itemList = null;
		itemList = systemmagDAO.viewItem();
		System.out.println("sercom= :"+itemList);
		return itemList;
	}
	@Override
	public List comitem(String item_code) throws DataAccessException {
		List itemList = systemmagDAO.allviewItem(item_code);
		return itemList;
	}
	//품목등록
		@Override
		public int addItem(itemVO itemVO) throws DataAccessException{
			return systemmagDAO.addItem(itemVO);
	}
	//품목군등록(조회)
	@Override
	public List itemgView() throws DataAccessException {
		List itemgList = null;
		itemgList = systemmagDAO.allviewItemg();
		System.out.println("sercom= :");
		return itemgList;
	}
	//부서등록
			@Override
			public int addItemg(ItemgVO itemgVO) throws DataAccessException{
				return systemmagDAO.addItemg(itemgVO);
		}
	//사원조회(조회)
	@Override
	public List employeeView() throws DataAccessException {
		List employeeList = null;
		employeeList = systemmagDAO.allviewemployee();
		System.out.println("sercom= :");
		return employeeList;
	}
	//부서등록(조회)
		@Override
		public List departmentView() throws DataAccessException {
			List departmentList = null;
			departmentList = systemmagDAO.allviewdepartment();
			System.out.println("sercom= :");
			return departmentList;
		}
	//부서등록
		@Override
		public int addDep(DepartmentVO departmentVO) throws DataAccessException{
			return systemmagDAO.addDep(departmentVO);
	}
}