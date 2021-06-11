package com.myspring.salesmanage.pop.itemview.vo;


import org.springframework.stereotype.Component;

@Component("itemviewVO")
public class ItemViewVO {

	private String item_code; //ǰ��
	private String item_name; //ǰ��
	private String groupcode;
	private String standard; //�԰�
	private String inventory_unit; //����
	private String inspection_status; //�˻翩��
	
	public ItemViewVO() {}

	public ItemViewVO(String item_code, String item_name, String groupcode, String standard, String inventory_unit,
			String inspection_status) {
		super();
		this.item_code = item_code;
		this.item_name = item_name;
		this.groupcode = groupcode;
		this.standard = standard;
		this.inventory_unit = inventory_unit;
		this.inspection_status = inspection_status;
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

	public String getGroupcode() {
		return groupcode;
	}

	public void setGroupcode(String groupcode) {
		this.groupcode = groupcode;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getInventory_unit() {
		return inventory_unit;
	}

	public void setInventory_unit(String inventory_unit) {
		this.inventory_unit = inventory_unit;
	}

	public String getInspection_status() {
		return inspection_status;
	}

	public void setInspection_status(String inspection_status) {
		this.inspection_status = inspection_status;
	}
	
	
	
}
