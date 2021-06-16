package com.myspring.MainPlan.MpsOS.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("mpsosVO")
public class MpsOSVO {
	private String orderno;
	private int sequence;
	private Date orderdate;
	private Date okeydate;
	private String buyer;
	private String item_Code;
	private String item_Name;
	private String standard;
	private String inventory_unit;
	private int order_quantity;
	private int apply_quantity;
	private int order_Balance;
	private Date expected_Date;
	private String note;

public MpsOSVO() {}

public MpsOSVO(String orderno,int sequence,Date orderdate, Date okeydate,String buyer,String item_Code,
		String item_Name,String standard,String inventory_unit,int order_quantity,int apply_quantity,int order_Balance,Date expected_Date,String note) 
{
	this.orderno=orderno;
	this.sequence=sequence;
	this.orderdate=orderdate;
	this.okeydate=okeydate;
	this.buyer=buyer;
	this.item_Code=item_Code;
	this.item_Name=item_Name;
	this.standard=standard;
	this.inventory_unit=inventory_unit;
	this.order_quantity=order_quantity;
	this.apply_quantity=apply_quantity;
	this.order_Balance=order_Balance;
	this.expected_Date=expected_Date;
	this.note=note;
	
}

public String getOrderno() {return orderno;}
public void setOrderno(String orderno) {this.orderno=orderno;}

public int getSequence() {return sequence;}
public void setSequence(int sequence) {this.sequence=sequence;}

public Date getOrderdate() {return orderdate;}
public void setOrderdate(Date orderdate) {this.orderdate=orderdate;}

public Date getOkeydate() {return okeydate;}
public void setOkeydate(Date okeydate) {this.okeydate=okeydate;}

public String getBuyer() {return buyer;}
public void setBuyer(String buyer) {this.buyer=buyer;}

public String getItem_Code() {return item_Code;}
public void getItem_Code(String item_Code) {this.item_Code=item_Code;}

public String getItem_Name() {return item_Name;}
public void setItem_Name(String item_Name) {this.item_Name=item_Name;}

public String getStandard() {return standard;}
public void setStandard(String standard) {this.standard=standard;}

public String getInventory_unit() {return inventory_unit;}
public void setInventory_unit(String inventory_unit) {this.inventory_unit=inventory_unit;}

public int getApply_quantity() {return apply_quantity;}
public void setApply_quantity(int apply_quantity) {this.apply_quantity=apply_quantity;}

public int getOrder_Balance() {return order_Balance;}
public void setOrder_Balance(int order_Balance) {this.order_Balance=order_Balance;}

public int getOrder_quantity() {return order_quantity;}
public void setOrder_quantity(int order_quantity) {this.order_quantity=order_quantity;}

public Date getExpected_Date() {return expected_Date;}
public void setExpected_Date(Date expected_Date) {this.expected_Date=expected_Date;}

public String getNote() {return note;}
public void setNote(String note) {this.note=note;}

}
