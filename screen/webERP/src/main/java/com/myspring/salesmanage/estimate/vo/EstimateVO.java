package com.myspring.salesmanage.estimate.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EstimateVO {

	private String estCode;
	private String custCode;
	private String tax;
	private String item_code;
	private String item_name;
	private String stand;
	private String note;
	private String unit;
	private int orderQuant;
	private int price;
	private Date estDate;
	private Date dueDate;
	
	//cust
	private String custName;
	private String comNum;
	private String repName;
	private List<EstimateVO> ListEst;
	
	@Override
	public String toString() {
		return Arrays.toString(ListEst.toArray());
	}
	
	public EstimateVO() {
		super();
	}

	public String getEstCode() {
		return estCode;
	}

	public void setEstCode(String estCode) {
		this.estCode = estCode;
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

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getStand() {
		return stand;
	}

	public void setStand(String stand) {
		this.stand = stand;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getOrderQuant() {
		return orderQuant;
	}

	public void setOrderQuant(int orderQuant) {
		this.orderQuant = orderQuant;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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

	
	
}
