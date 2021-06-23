package com.myspring.commonProduction.registOperationPerformance.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("RegistOperationPerformanceVO") 
public class RegistOperationPerformanceVO {
	private String workOrderNumber;
	private String materialstatus;
	private String workplaceCode;
	private Date instructionDate;
	private Date dueDate;
	private String itemCode;
	private String itemName;
	private String standard;
	private String inventoryUnit;
	private int indicated;
	private int sumPerformanceQuantity;
	private int remainingPerformance;
	private String status;
	private String workSortation;
	private String inspection;
	private String note;
	private String productionPlanCode;
	private String productionFacility;
	private String taskTeam;
	private List<RegistOperationPerformanceVO> ListVO;
	
	@Override
	public String toString() {
		return Arrays.toString(ListVO.toArray());
	}
	
	
	public String getWorkOrderNumber() {
		return workOrderNumber;
	}
	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getInventoryUnit() {
		return inventoryUnit;
	}
	public void setInventoryUnit(String inventoryUnit) {
		this.inventoryUnit = inventoryUnit;
	}
	public int getIndicated() {
		return indicated;
	}
	public void setIndicated(int indicated) {
		this.indicated = indicated;
	}
	public int getSumPerformanceQuantity() {
		return sumPerformanceQuantity;
	}
	public void setSumPerformanceQuantity(int sumPerformanceQuantity) {
		this.sumPerformanceQuantity = sumPerformanceQuantity;
	}
	public int getRemainingPerformance() {
		return remainingPerformance;
	}
	public void setRemainingPerformance(int remainingPerformance) {
		this.remainingPerformance = remainingPerformance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getProductionPlanCode() {
		return productionPlanCode;
	}
	public void setProductionPlanCode(String productionPlanCode) {
		this.productionPlanCode = productionPlanCode;
	}

	public List<RegistOperationPerformanceVO> getListVO() {
		return ListVO;
	}


	public void setListVO(List<RegistOperationPerformanceVO> listVO) {
		ListVO = new ArrayList();
	}

	public String getWorkplaceCode() {
		return workplaceCode;
	}


	public void setWorkplaceCode(String workplaceCode) {
		this.workplaceCode = workplaceCode;
	}


	public String getMaterialstatus() {
		return materialstatus;
	}


	public void setMaterialstatus(String materialstatus) {
		this.materialstatus = materialstatus;
	}


	public String getWorkSortation() {
		return workSortation;
	}


	public void setWorkSortation(String workSortation) {
		this.workSortation = workSortation;
	}


	public String getProductionFacility() {
		return productionFacility;
	}


	public void setProductionFacility(String productionFacility) {
		this.productionFacility = productionFacility;
	}


	public String getTaskTeam() {
		return taskTeam;
	}


	public void setTaskTeam(String taskTeam) {
		this.taskTeam = taskTeam;
	}
	
	
}
