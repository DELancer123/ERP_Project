package com.myspring.outsourcing_manage.RegOutsourcing.vo;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myspring.productionBaseInfo.BOM.vo.bomVO;

@Component("RegOutsourcingVO")
public class RegOutsourcingVO {
	private String workOrderNumber;
	private String materialForwardingStatus;
	private String workplaceCode;
	private Date instructionDate;
	private Date dueDate;
	private String itemCode;
	private String itemName;
	private String standard;
	private String inventoryUnit;
	private int indicatedQuantity;
	private int unitPrice;
	private int price;
	private String status;
	private String inspection;
	private String note;
	private String productionPlanCode;	
	private List<RegOutsourcingVO> ListVO;
	
	public RegOutsourcingVO() {
		super();
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}

	public String getMaterialForwardingStatus() {
		return materialForwardingStatus;
	}

	public void setMaterialForwardingStatus(String materialForwardingStatus) {
		this.materialForwardingStatus = materialForwardingStatus;
	}

	public String getWorkplaceCode() {
		return workplaceCode;
	}

	public void setWorkplaceCode(String workplaceCode) {
		this.workplaceCode = workplaceCode;
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

	public int getIndicatedQuantity() {
		return indicatedQuantity;
	}

	public void setIndicatedQuantity(int indicatedQuantity) {
		this.indicatedQuantity = indicatedQuantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public List<RegOutsourcingVO> getListVO() {
		return ListVO;
	}

	public void setListVO(List<RegOutsourcingVO> listVO) {
		ListVO = listVO;
	}

	
}

