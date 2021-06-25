package com.myspring.salesmanage.forward.vo;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myspring.salesmanage.cor.vo.CorVO;


@Component("forwardVO")
public class ForwardVO {

	private String relCode;
	private Date relDate;
	private String custCode;
	private String releaseOX;
	private String deadLine;
	private String note;

	//cust
	private String custName;
	private String comNum;
	private String repName;
	private List<ForwardVO> ListFor;
	private CorVO corVO;
	
	
	@Override
	public String toString() {
		return Arrays.toString(ListFor.toArray());
	}	

	public ForwardVO() {
		super();
	}

	public String getRelCode() {
		return relCode;
	}

	public void setRelCode(String relCode) {
		this.relCode = relCode;
	}

	public Date getRelDate() {
		return relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getReleaseOX() {
		return releaseOX;
	}

	public void setReleaseOX(String releaseOX) {
		this.releaseOX = releaseOX;
	}

	public String getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
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

	public List<ForwardVO> getListOrd() {
		return ListFor;
	}

	public void setListOrd(List<ForwardVO> listFor) {
		ListFor = listFor;
	}

	public CorVO getCorVO() {
		return corVO;
	}

	public void setCorVO(CorVO corVO) {
		this.corVO = corVO;
	}
}
