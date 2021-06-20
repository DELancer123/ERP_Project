package com.myspring.commonProduction.operationRegist.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperationDetailVO {
	private String operationNumber;
	private String materialStatus;
	private Date performanceDate;
	private String processCode;
	private String workplaceCode;
	private String sortation;
	private String performanceQuantity;
	private String inspection;
	private String note;
	private String workOrderNumber;
	private List<OperationDetailVO> DetailVO;
	
	public OperationDetailVO() {
	}

	@Override
	public String toString() {
		return Arrays.toString(DetailVO.toArray());
	}
	
	public String getOperationNumber() {
		return operationNumber;
	}

	public void setOperationNumber(String operationNumber) {
		this.operationNumber = operationNumber;
	}

	public String getMaterialStatus() {
		return materialStatus;
	}

	public void setMaterialStatus(String materialStatus) {
		this.materialStatus = materialStatus;
	}

	public Date getPerformanceDate() {
		return performanceDate;
	}

	public void setPerformanceDate(Date performanceDate) {
		this.performanceDate = performanceDate;
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

	public String getSortation() {
		return sortation;
	}

	public void setSortation(String sortation) {
		this.sortation = sortation;
	}

	public String getPerformanceQuantity() {
		return performanceQuantity;
	}

	public void setPerformanceQuantity(String performanceQuantity) {
		this.performanceQuantity = performanceQuantity;
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

	public List<OperationDetailVO> getDetailVO() {
		return DetailVO;
	}

	public void setDetailVO(List<OperationDetailVO> detailVO) {
		DetailVO = new ArrayList();
	}
	
	
}
