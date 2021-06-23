package com.myspring.commonProduction.registOperationPerformance.vo;

import java.sql.Date;
import java.util.List;


public class RegistOperationPerformanceDetailVO {
	private String OPNumber;
	private String MaterialUseStatus;
	private Date performanceDate;
	private String processCode;
	private String workplaceCode;
	private int sortation;
	private int sumPerformanceQuantity;
	private String inspection;
	private String note;
	private String workOrderNumber;
	private List<RegistOperationPerformanceDetailVO> DetailVO;
	public String getOPNumber() {
		return OPNumber;
	}
	public void setOPNumber(String oPNumber) {
		OPNumber = oPNumber;
	}
	public String getMaterialUseStatus() {
		return MaterialUseStatus;
	}
	public void setMaterialUseStatus(String materialUseStatus) {
		MaterialUseStatus = materialUseStatus;
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
	public int getSortation() {
		return sortation;
	}
	public void setSortation(int sortation) {
		this.sortation = sortation;
	}
	public int getSumPerformanceQuantity() {
		return sumPerformanceQuantity;
	}
	public void setSumPerformanceQuantity(int sumPerformanceQuantity) {
		this.sumPerformanceQuantity = sumPerformanceQuantity;
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
		DetailVO = detailVO;
	}
	
	
}
