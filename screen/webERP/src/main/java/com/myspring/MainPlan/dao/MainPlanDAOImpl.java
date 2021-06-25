package com.myspring.MainPlan.dao;

import java.sql.Date;
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
	public List viewMPS() throws DataAccessException {
		List<MainPlanVO> MPSList = null;
		MPSList = sqlSession.selectList("mappers.erp.selectAllMainPlanList");
		return MPSList;
	}

	@Override
	public List selectAllMpsosList(String startDate, String endDate) throws Exception{
		List<MpsOSVO>mpsosList = null;
		if(startDate != null && startDate !=  "" && endDate != null && endDate != "") {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date start = new Date(sdf.parse(startDate).getTime());
			Date end = new Date(sdf.parse(endDate).getTime());
			System.out.println(start);
			MainPlanVO vo = new MainPlanVO();
			vo.setStartDate(start);
			vo.setEndDate(end);
			mpsosList = sqlSession.selectList("mappers.erp.selectAllMpsosList", vo);
		} else {
			mpsosList = sqlSession.selectList("mappers.erp.selectAllMpsosList");
		}
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
	
	@Override
	public List<MpsOSVO>searchMPSOS(String itemName) {
		List<MpsOSVO> popList = null;
		popList = sqlSession.selectList("mappers.erp.searchMPSOS",itemName);
		return popList;
	}
	@Override
	public List setText(String itemNumber) throws DataAccessException {
		List<MpsOSVO> textList = null;
		textList = sqlSession.selectList("mappers.erp.selectMRP",itemNumber);
		return textList;
	}

	@Override
	public List SearchView(String itemNumber) throws DataAccessException{
		List<MpsOSVO> searchList = null;
		searchList = sqlSession.selectList("mappers.erp.searchMRP",itemNumber);
		return searchList;
	}

	@Override
	public int selSeq() throws DataAccessException {
		return sqlSession.selectOne("mappers.erp.selectSeq");
	}
	
	@Override
	public List inputText(String itemCode) throws DataAccessException {
		List<MpsOSVO> textList = null;
		textList = sqlSession.selectList("mappers.erp.selectMRP",itemCode);
		return textList;
	}

}