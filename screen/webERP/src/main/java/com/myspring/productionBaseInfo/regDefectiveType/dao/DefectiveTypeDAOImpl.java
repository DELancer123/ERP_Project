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
	@Override
	public int addoutprice(DefectiveTypeVO defVO) throws DataAccessException {
		int idx = defVO.getDefList().size()-1;
		int result = sqlSession.insert("mappers.erp.addDefType",defVO.getDefList().get(idx));
		return 0;
	}
	@Override
	public int updDefType(DefectiveTypeVO defVO) throws DataAccessException {
		int result = 0; 

		int idx = defVO.getDefList().size();
		for(int i = 0; i<idx;i++) {
		result = sqlSession.update("mappers.erp.updDefType",defVO.getDefList().get(i));		
		}
		return result;
	}
	@Override
	public List viewGroupList() throws DataAccessException {
		List<DefectiveTypeVO> defGroupList = null;
		defGroupList = sqlSession.selectList("mappers.erp.defGroupView");
		
		return defGroupList;
	}

}
