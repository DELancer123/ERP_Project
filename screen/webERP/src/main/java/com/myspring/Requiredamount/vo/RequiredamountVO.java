package com.myspring.Requiredamount.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myspring.MainPlan.vo.MainPlanVO;

@Component("mrpVO")
public class RequiredamountVO {
private String item_Code;
private String item_Name;
private String standard;
private Date due_date;
private int sequence;
private Date expected_order;
private int expected_quantity;
private String inventory_unit;
private List<RequiredamountVO> ListVO;



@Override
public String toString() {return Arrays.toString(ListVO.toArray());}

public RequiredamountVO() {super();}

public List<RequiredamountVO> getListVO() {return ListVO;}
public void setListVO(List<RequiredamountVO> listVO) {ListVO = new ArrayList();}

public String getItem_Code() {return item_Code;}
public void setItem_Code(String item_Code) {this.item_Code=item_Code;}

public String getItem_Name() {return item_Name;}
public void setItem_Name(String item_Name) {this.item_Name=item_Name;}

public String getStandard() {return standard;}
public void setStandard(String standard) {this.standard=standard;}

public Date getDue_date() {return due_date;}
public void setDue_date(Date due_date) {this.due_date=due_date;}

public int getSequence() {return sequence;}
public void setSequence(int sequence) {this.sequence=sequence;}

public Date getExpected_order() {return expected_order;}
public void setExpected_order(Date expected_order) {this.expected_order=expected_order;}

public int getExpected_quantity() {return expected_quantity;}
public void setExpected_quantity(int expected_quantity) {this.expected_quantity=expected_quantity;}

public String getInventory_unit() {return inventory_unit;}
public void setInventory_unit(String inventory_unit) {this.inventory_unit=inventory_unit;}
}
