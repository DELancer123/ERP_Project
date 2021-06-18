package com.myspring.Billing.List.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myspring.MainPlan.vo.MainPlanVO;

@Component("bottomVO")
public class BottomVO {
	private int sequence;
	private String item_Code;
	private String item_Name;
	private String standard;
	private Date requestdate;
	private String inventory_unit;
	private int inventory_qty;
	private String claim_unit;
	private int claim_quantity;
	private String buyer;
	private List<BottomVO> ListVO;

	public BottomVO(int sequence, String item_Code, String item_Name, String standard, Date requestdate,
			String inventory_unit, int inventory_qty, String claim_unit, int claim_quantity, String buyer) {
		this.sequence = sequence;
		this.item_Code = item_Code;
		this.item_Name = item_Name;
		this.standard = standard;
		this.requestdate = requestdate;
		this.inventory_unit = inventory_unit;
		this.inventory_qty = inventory_qty;
		this.claim_unit = claim_unit;
		this.claim_quantity=claim_quantity;
		this.buyer=buyer;
	}
	
	@Override
	public String toString() {return Arrays.toString(ListVO.toArray());}
	
	public BottomVO() {super();}
	
	public List<BottomVO> getListVO() {return ListVO;}
	public void setListVO(List<BottomVO> listVO) {ListVO = new ArrayList();}

	public int getSequence() {return sequence;}
	public void setSequence(int sequence) {this.sequence = sequence;}

	public String getItem_Code() {return item_Code;}
	public void setItem_Code(String item_Code) {this.item_Code = item_Code;}

	public String getItem_Name() {return item_Name;}
	public void setItem_Name(String item_Name) {this.item_Name = item_Name;}

	public String getStandard() {return standard;}
	public void setStandard(String standard) {this.standard = standard;}

	public Date getRequestdate() {return requestdate;}
	public void setRequestdate(Date requestdate) {this.requestdate = requestdate;}

	public String getInventory_unit() {return inventory_unit;}
	public void setInventory_unit(String inventory_unit) {this.inventory_unit = inventory_unit;}

	public int getInventory_qty() {return inventory_qty;}
	public void setInventory_qty(int inventory_qty) {this.inventory_qty = inventory_qty;}

	public String getClaim_unit() {return claim_unit;}
	public void setClaim_unit(String claim_unit) {this.claim_unit = claim_unit;}
	
	public int getClaim_quantity() {return claim_quantity;}
	public void setClaim_quantity(int claim_quantity) {this.claim_quantity = claim_quantity;}

	public String getBuyer() {return buyer;}
	public void setBuyer(String buyer) {this.buyer = buyer;}
}
