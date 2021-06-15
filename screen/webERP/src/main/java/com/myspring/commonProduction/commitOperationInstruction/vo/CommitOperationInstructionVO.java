
package com.myspring.commonProduction.commitOperationInstruction.vo;
 
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("CommitOperationInstructionVO") 
public class CommitOperationInstructionVO { 
	private int NO; 
	private String itemCode;
	private String itemName;
	private String standard;
	private String inventoryUnit;
	private int precisionquantity;
	private int dailyProduction;
	private Date startDate;
	private Date endDate;
	private String note;
	
	public CommitOperationInstructionVO() {
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getitemCode() {
		return itemCode;
	}

	public void setitemCode(String itemCode) {
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

	public int getPrecisionquantity() {
		return precisionquantity;
	}

	public void setPrecisionquantity(int precisionquantity) {
		this.precisionquantity = precisionquantity;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getDailyProduction() {
		return dailyProduction;
	}

	public void setDailyProduction(int dailyProduction) {
		this.dailyProduction = dailyProduction;
	}
 
	
	
 }