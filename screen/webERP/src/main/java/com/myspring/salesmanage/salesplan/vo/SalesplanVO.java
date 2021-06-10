package com.myspring.salesmanage.salesplan.vo;

import java.sql.Date;

public class SalesplanVO {
	private String plan_code;
	private String item_code;		
	private String item_name;	
	private String item_unit;	
	private String item_group_code;
	private int plan_item_quantity;		
	private int plan_uint_price;		
	private int newplan_item_quabtity;	
	private int newplan_item_unit_price;
	private Date plan_date;


	public SalesplanVO() {
		
	}


	public SalesplanVO(String plan_code, String item_code, String item_name, String item_unit, String item_group_code,
			int plan_item_quantity, int plan_uint_price, int newplan_item_quabtity, int newplan_item_unit_price,
			Date plan_date) {
		super();
		this.plan_code = plan_code;
		this.item_code = item_code;
		this.item_name = item_name;
		this.item_unit = item_unit;
		this.item_group_code = item_group_code;
		this.plan_item_quantity = plan_item_quantity;
		this.plan_uint_price = plan_uint_price;
		this.newplan_item_quabtity = newplan_item_quabtity;
		this.newplan_item_unit_price = newplan_item_unit_price;
		this.plan_date = plan_date;
	}


	public String getPlan_code() {
		return plan_code;
	}


	public void setPlan_code(String plan_code) {
		this.plan_code = plan_code;
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


	public String getItem_unit() {
		return item_unit;
	}


	public void setItem_unit(String item_unit) {
		this.item_unit = item_unit;
	}


	public String getItem_group_code() {
		return item_group_code;
	}


	public void setItem_group_code(String item_group_code) {
		this.item_group_code = item_group_code;
	}


	public int getPlan_item_quantity() {
		return plan_item_quantity;
	}


	public void setPlan_item_quantity(int plan_item_quantity) {
		this.plan_item_quantity = plan_item_quantity;
	}


	public int getPlan_uint_price() {
		return plan_uint_price;
	}


	public void setPlan_uint_price(int plan_uint_price) {
		this.plan_uint_price = plan_uint_price;
	}


	public int getNewplan_item_quabtity() {
		return newplan_item_quabtity;
	}


	public void setNewplan_item_quabtity(int newplan_item_quabtity) {
		this.newplan_item_quabtity = newplan_item_quabtity;
	}


	public int getNewplan_item_unit_price() {
		return newplan_item_unit_price;
	}


	public void setNewplan_item_unit_price(int newplan_item_unit_price) {
		this.newplan_item_unit_price = newplan_item_unit_price;
	}


	public Date getPlan_date() {
		return plan_date;
	}


	public void setPlan_date(Date plan_date) {
		this.plan_date = plan_date;
	}

}
