package com.myspring.commonProduction.operationRegist.vo;

import java.sql.Date;

public class OperationDetailVO {
	private String OperationNumber;
	private String materialStatus;
	private Date performanceDate;
	private String processCode;
	private String workplaceCode;
	private String sortation;
	private String performanceQuantity;
	private String inspection;
	private String note;
	private String workOrderNumber;
	
	public OperationDetailVO() {
	}

	public String getOperationNumber() {
		return OperationNumber;
	}

	public void setOperationNumber(String operationNumber) {
		OperationNumber = operationNumber;
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
	
	
}
