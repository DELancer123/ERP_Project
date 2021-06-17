package com.myspring.systemmag.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.systemmag.vo.SystemmagVO;

@Repository("SystemmagDAO")
public class SystemmagDAOImpl implements SystemmagDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertNewCompany (SystemmagVO systemmagVO) throws DataAccessException{
		int result = sqlSession.insert("mappers.erp.insertNewCompany",systemmagVO);
		return result;
	}

	@Override
	public List viewCom() throws DataAccessException {
		List<SystemmagVO> comList = null;
		comList = sqlSession.selectList("mappers.erp.selectAllBasicList");
		System.out.println("comList: "+comList);
		return comList;
	}
	
	@Override
	public List allviewCom(String com_code) throws DataAccessException {
		List<SystemmagVO> comList = null;
		comList = sqlSession.selectList("mappers.erp.selectBasicList",com_code);
		System.out.println("comList12: "+com_code);
		return comList;
	}


	@Override
	public void deleteCom(String[] noary) throws DataAccessException {
		for(String obj: noary) {
			sqlSession.delete("mappers.erp.deleteBasicList", Integer.parseInt(obj));	
		}
		
	}

	@Override
	public void updateCom(SystemmagVO systemmagVO) throws DataAccessException {
		
		sqlSession.update("mapper.erp.updateBasicList", systemmagVO);
	}

//	@Override
//	public int updateCom(SystemmagVO systemmagVO) throws DataAccessException {
//		int result = 0; 
//
//		int idx = systemmagVO.getListVO().size()-1;
//		for(int i = 0; i<idx;i++) {
//			System.out.println("i"+i);
//		System.out.println("idx : "+idx);
//		result = sqlSession.update("mappers.erp.updateBasicList",systemmagVO.getListVO().get(i));		
//		System.out.println("DAOresult:"+result);
//		//bomList.add(bomVO);
//		//}
//		}
//		return result;
//	}
	
	
}
