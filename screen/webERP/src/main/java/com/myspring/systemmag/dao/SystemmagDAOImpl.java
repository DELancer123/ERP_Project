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
	
	
	//ȸ����
	@Override
	public int addCom(SystemmagVO systemmagVO) throws DataAccessException{
		int result = sqlSession.insert("mappers.erp.insertCom",systemmagVO);
		return 0;
	}
	
	//ȸ���� ��ȸ
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
	//ȸ����
		@Override
		public int addWor(WorkplaceVO workplaceVO) throws DataAccessException{
			int result = sqlSession.insert("mappers.erp.insertWor",workplaceVO);
			return 0;
		}
	
	//������� ��ȸ
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
	//ǰ����
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
	//ǰ�񱺵��
	@Override
	public List allviewItemg() throws DataAccessException {
		List<ItemgVO> itemgList = null;
		itemgList = sqlSession.selectList("mappers.erp.selectAllitemgList");
		System.out.println("itemList123: ");
		return itemgList;
	}
	//�����ȸ
	@Override
	public List allviewemployee() throws DataAccessException {
		List<EmployeeVO> employeeList = null;
		employeeList = sqlSession.selectList("mappers.erp.selectAllemployeeList");
		System.out.println("employeeList123: ");
		return employeeList;
	}
	//�μ���� (��ȸ)
		@Override
		public List allviewdepartment() throws DataAccessException {
			List<DepartmentVO> departmentList = null;
			departmentList = sqlSession.selectList("mappers.erp.selectAlldepartmentList");
			System.out.println("departmentList123: ");
			return departmentList;
		}
	//�μ����
		@Override
		public int addDep(DepartmentVO departmentVO) throws DataAccessException{
			int idx = departmentVO.getListVO().size()-1;
			int result = sqlSession.insert("mappers.erp.insertDep",departmentVO.getListVO().get(idx));
			return 0;
		}
}
