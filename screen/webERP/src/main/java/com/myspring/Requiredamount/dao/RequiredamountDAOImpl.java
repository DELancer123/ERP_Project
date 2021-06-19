package com.myspring.Requiredamount.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.Requiredamount.vo.RequiredamountVO;

@Repository("mrpDAO")
public class RequiredamountDAOImpl implements RequiredamountDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllMrpList() throws Exception{
		List<RequiredamountVO>mrpList = sqlSession.selectList("mappers.erp.selectAllMrpList");
		return mrpList;
}
	@Override
	public int updateMRP(RequiredamountVO vo) throws DataAccessException {
		int result = 0; 

		int idx = vo.getListVO().size()-1;
		for(int i = 0; i<idx;i++) {
			System.out.println("i"+i);
		System.out.println("idx : "+idx);
		result = sqlSession.update("mappers.erp.updateMRP",vo.getListVO().get(i).getExpected_order());
		}
		return result;
	}
}
