package com.myspring.systemmag.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.systemmag.vo.DepartmentVO;
import com.myspring.systemmag.vo.EmployeeVO;
import com.myspring.systemmag.vo.ItemgVO;
import com.myspring.systemmag.vo.SystemmagVO;
import com.myspring.systemmag.vo.WorkplaceVO;
import com.myspring.systemmag.vo.itemVO;

@Repository("SystemmagDAO")
public class SystemmagDAOImpl implements SystemmagDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertNewCompany (SystemmagVO systemmagVO) throws DataAccessException{
		int result = sqlSession.insert("mappers.erp.insertNewCompany",systemmagVO);
		return result;
	}
	//회사등록 조회
	@Override
	public List viewCom() throws DataAccessException {
		List<SystemmagVO> comList = null;
		comList = sqlSession.selectList("mappers.erp.selectcomList");
		System.out.println("comList: "+comList);
		return comList;
	}
	@Override
	public List allviewCom(String com_code) throws DataAccessException {
		List<SystemmagVO> comList = null;
		comList = sqlSession.selectList("mappers.erp.selectAllcomList",com_code);
		System.out.println("comList12: "+com_code);
		return comList;
	}
	
	
	//사업장등록 조회
	@Override
	public List viewWor() throws DataAccessException {
		List<WorkplaceVO> worList = null;
		worList = sqlSession.selectList("mappers.erp.selectworList");
		System.out.println("worList: "+worList);
		return worList;
	}
	@Override
	public List allviewWor(String wor_code) throws DataAccessException {
		List<WorkplaceVO> worList = null;
		worList = sqlSession.selectList("mappers.erp.selectAllworList",wor_code);
		System.out.println("worList12: "+wor_code);
		return worList;
	}
	//품목등록
	@Override
	public List viewItem() throws DataAccessException {
		List<itemVO> itemList = null;
		itemList = sqlSession.selectList("mappers.erp.selectitemList");
		System.out.println("worList: "+itemList);
		return itemList;
	}
	@Override
	public List allviewItem(String item_code) throws DataAccessException {
		List<itemVO> itemList = null;
		itemList = sqlSession.selectList("mappers.erp.selectAllitemList",item_code);
		System.out.println("itemList123: "+item_code);
		return itemList;
	}
	//품목군등록
	@Override
	public List allviewItemg() throws DataAccessException {
		List<ItemgVO> itemgList = null;
		itemgList = sqlSession.selectList("mappers.erp.selectAllitemgList");
		System.out.println("itemList123: ");
		return itemgList;
	}
	//사원조회
	@Override
	public List allviewemployee() throws DataAccessException {
		List<EmployeeVO> employeeList = null;
		employeeList = sqlSession.selectList("mappers.erp.selectAllemployeeList");
		System.out.println("employeeList123: ");
		return employeeList;
	}
	//부서등록
		@Override
		public List allviewdepartment() throws DataAccessException {
			List<DepartmentVO> departmentList = null;
			departmentList = sqlSession.selectList("mappers.erp.selectAlldepartmentList");
			System.out.println("departmentList123: ");
			return departmentList;
		}
}
