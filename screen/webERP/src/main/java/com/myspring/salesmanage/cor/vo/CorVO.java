package com.myspring.salesmanage.cor.vo;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("corVO")
public class CorVO {

	private String custCode;
	private String item_code;
	private String item_name;
	private String stand;
	private String unit;
	private int orderQuant;
	private int price;
	private Date dueDate;
	private Date expDate;
	private Date relDate;
	private String inspection;
	private String orderOX;
	
	/*
	 * 
	 * --테이블 생성
create table CSM_SM_COR_Reg(
--품번(공통)(FK)item_code
Item_Code varchar2(12) not null,
--품명(공통)(FK)item_name
Item_Name varchar2(50) not null,
--규격stand
standard varchar2(20) DEFAULT NULL,
--단위unit
Inventory_Unit varchar2(5) DEFAULT 'EA',
--납기일(견적, 수주, 출고의뢰)dueDate
dueDate date not null,
--주문 수량(공통)orderQuant
ordersQuantity Number(5) DEFAULT '0',
--단가(견적, 수주, 출고처리)price
productPrice Number(15) DEFAULT '0',
--출하예정일(수주)expDate
expectedDate DATE not null,
--출고예정일(의뢰)
releaseExpectedDate date not null,
--검사(의뢰, 수주)
inspection Varchar2(10) not null,
--출고구분(예외/주문)(출고처리)
orderOX varchar2(20) not null,
--모든 등록과 연결하기 위한 고객코드custCode
customerCode varchar2(12) not null,*/
	private List<CorVO> ListCor;
	
	@Override
	public String toString() {
		return Arrays.toString(ListCor.toArray());
	}
	
	public CorVO() {
		super();
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
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
	
}
