package com.myspring.MainPlan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.MainPlan.MpsOS.vo.MpsOSVO;
import com.myspring.MainPlan.dao.MainPlanDAO;
import com.myspring.MainPlan.vo.MainPlanVO;

@Service("mainplanService")
@Transactional(propagation = Propagation.REQUIRED)
public class MainPlanServiceImpl implements MainPlanService{
	@Autowired
	private MainPlanDAO mainplanDAO;
	
//	@Override
//	public List<MainPlanVO>selectAllMainPlanList(String startDate, String endDate) throws Exception{
//		List<MainPlanVO> mainplanList = mainplanDAO.selectAllMainPlanList(startDate,endDate);
//		return mainplanList;
//	}
	
	@Override
	public List viewMPS() throws DataAccessException {
		List MPSList = null;
		MPSList = mainplanDAO.viewMPS();
		return MPSList;
	}
	
	@Override
	public List<MpsOSVO>selectAllMpsosList(String startDate, String endDate)throws Exception{
		List<MpsOSVO>mpsosList = mainplanDAO.selectAllMpsosList(startDate,endDate);
		return mpsosList;
	}
	
	@Override
	public void delMps(String[] noary) throws DataAccessException{
		mainplanDAO.delMps(noary);
	}

	
	@Override
	public int addMPS(MainPlanVO vo) throws DataAccessException {
		return mainplanDAO.addMPS(vo);
	}
		  
	@Override
	public int updateMPS(MainPlanVO vo) throws DataAccessException {
		return mainplanDAO.updateMPS(vo);
	}
	
	@Override
	public List<MpsOSVO> searchMPSOS(String itemName) {
		return mainplanDAO.searchMPSOS(itemName);
	}

}
