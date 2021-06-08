package com.myspring.salesmanage.salesplan.vo;

import java.sql.Date;

public class SalesplanVO {
	private String Item_Code;		
	private String Item_Name;	
	private String Item_Unit;	
	private String Item_Group_Code;
	private int Plan_Item_Quantity;		
	private int Plan_Uint_Price;		
	private int Newplan_Item_Quabtity;	
	private int Newplan_Item_Unit_Price;
	private Date Plan_Date;


	public SalesplanVO() {
		
	}
//	public SalesplanVO(String Plan_Item_Code, String Plan_Item_Name, String Plan_Item_Unit, int Plan_Item_Quantity,
//	int Plan_Uint_Price) {
//		this.Plan_Item_Code =  Plan_Item_Code;
//		this.Plan_Item_Name = Plan_Item_Name;
//		this.Plan_Item_Unit = Plan_Item_Unit;
//		this.Plan_Item_Quantity =  Plan_Item_Quantity;
//		this.Plan_Uint_Price = Plan_Uint_Price;
//	}
	public SalesplanVO(String Plan_Item_Code, String Plan_Item_Name, String Plan_Item_Unit, int Plan_Item_Quantity,
			 String Item_Group_Code,
	int Plan_Uint_Price,int Newplan_Item_Quabtity,int Newplan_Item_Unit_Price, Date Plan_Date) {
		this.Item_Code =  Plan_Item_Code;
		this.Item_Name = Plan_Item_Name;
		this.Item_Unit = Plan_Item_Unit;
		this.Item_Group_Code = Item_Group_Code;
		this.Plan_Item_Quantity =  Plan_Item_Quantity;
		this.Plan_Uint_Price = Plan_Uint_Price;
		this.Newplan_Item_Quabtity = Newplan_Item_Quabtity;
		this.Newplan_Item_Unit_Price = Newplan_Item_Unit_Price;
		this.Plan_Date = Plan_Date;

	}
	public String getItem_Code() {
		return Item_Code;
	}
	public void setItem_Code(String item_Code) {
		Item_Code = item_Code;
	}
	public String getItem_Name() {
		return Item_Name;
	}
	public void setItem_Name(String item_Name) {
		Item_Name = item_Name;
	}
	public String getItem_Unit() {
		return Item_Unit;
	}
	public void setItem_Unit(String item_Unit) {
		Item_Unit = item_Unit;
	}
	public String getItem_Group_Code() {
		return Item_Group_Code;
	}
	public void setItem_Group_Code(String item_Group_Code) {
		Item_Group_Code = item_Group_Code;
	}
	public int getPlan_Item_Quantity() {
		return Plan_Item_Quantity;
	}

	public void setPlan_Item_Quantity(int plan_Item_Quantity) {
		Plan_Item_Quantity = plan_Item_Quantity;
	}

	public int getPlan_Uint_Price() {
		return Plan_Uint_Price;
	}

	public void setPlan_Uint_Price(int plan_Uint_Price) {
		Plan_Uint_Price = plan_Uint_Price;
	}

	public int getNewplan_Item_Quabtity() {
		return Newplan_Item_Quabtity;
	}

	public void setNewplan_Item_Quabtity(int newplan_Item_Quabtity) {
		Newplan_Item_Quabtity = newplan_Item_Quabtity;
	}

	public int getNewplan_Item_Unit_Price() {
		return Newplan_Item_Unit_Price;
	}

	public void setNewplan_Item_Unit_Price(int newplan_Item_Unit_Price) {
		Newplan_Item_Unit_Price = newplan_Item_Unit_Price;
	}
	public Date getPlan_Date() {
		return Plan_Date;
	}
	public void setPlan_Date(Date plan_Date) {
		Plan_Date = plan_Date;
	}

}
