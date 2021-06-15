package com.myspring.MainPlan.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public int addMPS(MainPlanVO vo) throws DataAccessException {
		int idx = vo.getListVO().size()-1;
		int result = sqlSession.insert("mappers.erp.insertMPS",vo.getListVO().get(idx));
		return 0;
	}
	
	@Override
	public int updateMPS(MainPlanVO vo) throws DataAccessException {
		int result = 0; 

		int idx = vo.getListVO().size()-1;
		for(int i = 0; i<idx;i++) {
			System.out.println("i"+i);
		System.out.println("idx : "+idx);
		result = sqlSession.update("mappers.erp.updateMPS",vo.getListVO().get(i));		
		}
		return result;
	}

}