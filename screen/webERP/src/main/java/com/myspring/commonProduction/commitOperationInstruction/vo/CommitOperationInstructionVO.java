
package com.myspring.commonProduction.commitOperationInstruction.vo;
 
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("CommitOperationInstructionVO") 
public class CommitOperationInstructionVO { 
	private int NO; 
	private String parentItemCode;
	private String itemName;
	private String standard;
	private String inventoryUnit;
	private int precisionquantity;
	private Date date;
	private String note;
	
	public CommitOperationInstructionVO() {
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getParentItemCode() {
		return parentItemCode;
	}

	public void setParentItemCode(String parentItemCode) {
		this.parentItemCode = parentItemCode;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
 
	
	
 }