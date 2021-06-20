package com.myspring.productionBaseInfo.regDefectiveType.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;
import com.myspring.productionBaseInfo.regDefectiveType.vo.DefectiveTypeVO;

@Repository("defDAO")
public class DefectiveTypeDAOImpl implements DefectiveTypeDAO{

	@Autowired
	private SqlSession sqlSession;
	@Override
	public List viewDefective() throws DataAccessException {
		List<DefectiveTypeVO> defList = null;
		defList = sqlSession.selectList("mappers.erp.defectiveView");
		
		return defList;
	}

}
