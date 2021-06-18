package com.myspring.salesmanage.estimate.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myspring.salesmanage.cor.vo.CorVO;

@Component("estimateVO")
public class EstimateVO {

	private String estCode;
	private Date estDate;
	private String custCode;
	private String tax;
	private String note;
	
	//cust
	private String custName;
	private String comNum;
	private String repName;
	private List<EstimateVO> ListEst;
	private CorVO corVO;
	
//	private List<CorVO> corVO;
	
	@Override
	public String toString() {
		return Arrays.toString(ListEst.toArray());
	}
	
//	@Override
//	public String toStringCorVO() {
//		return Arrays.toString(CorVO.toArray());
//	}
	
	public EstimateVO() {
		super();
	}

	public String getEstCode() {
		return estCode;
	}

	public void setEstCode(String estCode) {
		this.estCode = estCode;
	}

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getComNum() {
		return comNum;
	}

	public void setComNum(String comNum) {
		this.comNum = comNum;
	}

	public String getRepName() {
		return repName;
	}

	public void setRepName(String repName) {
		this.repName = repName;
	}

	public List<EstimateVO> getListEst() {
		return ListEst;
	}

	public void setListEst(List<EstimateVO> listEst) {
		ListEst = listEst;
	}

	public CorVO getCorVO() {
		return corVO;
	}

	public void setCorVO(CorVO corVO) {
		this.corVO = corVO;
	}

}
