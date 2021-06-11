package com.myspring.salesmanage.pop.itemgroup.vo;


import org.springframework.stereotype.Component;

@Component("itemgroupVO")
public class ItemGroupVO {

	private String groupcode; //ǰ��
	private String groupname; //ǰ��

	public ItemGroupVO() {}

	public ItemGroupVO(String groupcode, String groupname) {
		super();
		this.groupcode = groupcode;
		this.groupname = groupname;
	}

	public String getGroupcode() {
		return groupcode;
	}

	public void setGroupcode(String groupcode) {
		this.groupcode = groupcode;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

}

