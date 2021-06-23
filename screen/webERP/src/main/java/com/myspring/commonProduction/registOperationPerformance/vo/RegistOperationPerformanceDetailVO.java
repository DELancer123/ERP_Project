package com.myspring.commonProduction.registOperationPerformance.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("RegistOperationPerformanceDetailVO") 
public class RegistOperationPerformanceDetailVO {
	private String OPNumber;
	private String materialUseStatus;
	private Date performanceDate;
	private String processCode;
	private String workplaceCode;
	private int sortation;
	private int performanceQuantity;
	private String inspection;
	private String note;
	private String workOrderNumber;
	private List<RegistOperationPerformanceDetailVO> DetailVO;
	
	@Override
	public String toString() {
		return Arrays.toString(DetailVO.toArray());
	}
	
	public String getOPNumber() {
		return OPNumber;
	}
	public void setOPNumber(String oPNumber) {
		OPNumber = oPNumber;
	}

	public Date getPerformanceDate() {
		return performanceDate;
	}
	public void setPerformanceDate(Date performanceDate) {
		this.performanceDate = performanceDate;
	}

	public int getSortation() {
		return sortation;
	}
	public void setSortation(int sortation) {
		this.sortation = sortation;
	}

	public String getInspection() {
		return inspection;
	}
	public void setInspection(String inspection) {
		this.inspection = inspection;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getWorkOrderNumber() {
		return workOrderNumber;
	}
	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}
	public List<RegistOperationPerformanceDetailVO> getDetailVO() {
		return DetailVO;
	}
	public void setDetailVO(List<RegistOperationPerformanceDetailVO> detailVO) {
		DetailVO = new ArrayList();
	}

	public int getPerformanceQuantity() {
		return performanceQuantity;
	}

	public void setPerformanceQuantity(int performanceQuantity) {
		this.performanceQuantity = performanceQuantity;
	}


	public String getMaterialUseStatus() {
		return materialUseStatus;
	}

	public void setMaterialUseStatus(String materialUseStatus) {
		this.materialUseStatus = materialUseStatus;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getWorkplaceCode() {
		return workplaceCode;
	}

	public void setWorkplaceCode(String workplaceCode) {
		this.workplaceCode = workplaceCode;
	}
	
	
}
