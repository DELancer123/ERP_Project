package com.myspring.salesmanage.cor.vo;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("corVO")
public class CorVO {

	private String relCode;
	private String ordCode;
	private String item_code;
	private String item_name;
	private String stand;
	private String unit;
	private int orderQuant;
	private int price;
	private Date dueDate;
	private Date expDate;
	private String inspection;
	private String orderOX;
	
	private List<CorVO> ListCor;
	
	@Override
	public String toString() {
		return Arrays.toString(ListCor.toArray());
	}
	
	public CorVO() {
		super();
	}

	public String getCustCode() {
		return ordCode;
	}

	public void setCustCode(String ordCode) {
		this.ordCode = ordCode;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<CorVO> getListCor() {
		return ListCor;
	}

	public void setListCor(List<CorVO> listCor) {
		ListCor = listCor;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getInspection() {
		return inspection;
	}

	public void setInspection(String inspection) {
		this.inspection = inspection;
	}

	public String getOrderOX() {
		return orderOX;
	}

	public void setOrderOX(String orderOX) {
		this.orderOX = orderOX;
	}

	public String getRelCode() {
		return relCode;
	}

	public void setRelCode(String relCode) {
		this.relCode = relCode;
	}
	
}
