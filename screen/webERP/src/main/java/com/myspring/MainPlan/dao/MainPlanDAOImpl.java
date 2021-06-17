package com.myspring.MainPlan.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.MainPlan.MpsOS.vo.MpsOSVO;
import com.myspring.MainPlan.vo.MainPlanVO;

@Repository("mainplanDAO")
public class MainPlanDAOImpl implements MainPlanDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllMainPlanList() throws Exception{
		List<MainPlanVO>mainplanList = sqlSession.selectList("mappers.erp.selectAllMainPlanList");
		return mainplanList;
	}
	
	@Override
	public List selectAllMpsosList() throws Exception{
		List<MpsOSVO>mpsosList = sqlSession.selectList("mappers.erp.selectAllMpsosList");
		return mpsosList;
	}
	
	@Override
	public void delMps(String[] noary) throws DataAccessException{
		for(String obj: noary) {
			sqlSession.delete("mappers.erp.deleteMps", Integer.parseInt(obj));		
		}
	}
	
	@Override
	public MainPlanVO customer_detail(int Sequence) {
		return sqlSession.selectOne("mappers.erp.detail", Sequence);
	}

	@Override
	public void customer_update(MainPlanVO vo) {
		sqlSession.update("mappers.erp.update", vo);
	}

}