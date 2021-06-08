package com.myspring.Requiredamount.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("mrpVO")
public class RequiredamountVO {
private String item_Code;
private String item_Name;
private String standard;
private Date need_date;
private int sequence;
private Date expected_order;
private int expected_quantity;
private String unit;

public RequiredamountVO() {}

public RequiredamountVO(String item_Code,String item_Name,String standard,Date need_date,int sequence,Date expected_order,
		int expected_quantity,String unit)
{
	this.item_Code=item_Code;
	this.item_Name=item_Name;
	this.standard=standard;
	this.need_date=need_date;
	this.sequence=sequence;
	this.expected_order=expected_order;
	this.expected_quantity=expected_quantity;
	this.unit=unit;
}

public String getItem_Code() {return item_Code;}
public void setItem_Code(String item_Code) {this.item_Code=item_Code;}

public String getItem_Name() {return item_Name;}
public void setItem_Name(String item_Name) {this.item_Name=item_Name;}

public String getStandard() {return standard;}
public void setStandard(String standard) {this.standard=standard;}

public Date getNeed_date() {return need_date;}
public void setNeed_date(Date need_date) {this.need_date=need_date;}

public int getSequence() {return sequence;}
public void setSequence(int sequence) {this.sequence=sequence;}

public Date getExpected_order() {return expected_order;}
public void setExpected_order(Date expected_order) {this.expected_order=expected_order;}

public int getExpected_quantity() {return expected_quantity;}
public void setExpected_quantity(int expected_quantity) {this.expected_quantity=expected_quantity;}

public String getUnit() {return unit;}
public void setUnit(String unit) {this.unit=unit;}
}
