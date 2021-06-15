package com.myspring.salesmanage.pop.itemview.vo;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myspring.salesmanage.salesplan.vo.SalesplanVO;

@Component("itemviewVO")
public class ItemViewVO {

	private String item_code; //ǰ��
	private String item_name; //ǰ��
	private String groupcode;
	private String standard; //�԰�
	private String inventory_unit; //����
	private String inspection_status; //�˻翩��
	private List<SalesplanVO> List;

	@Override
	public String toString() {
		return Arrays.toString(List.toArray());
	}
	
	public ItemViewVO() {
		super();
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
