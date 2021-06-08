package com.myspring.invenBasicInfo.regItemUnitPrice.vo;

import org.springframework.stereotype.Component;

@Component("RegItemUnitPriceVO")
public class itemVO {
	private String Item_Code; //품번
	private String Item_Name; //품명
	private String Standard; //규격
	private String Inventory_Unit; //단위
	private String Kind; //종류(구매,판매)
	private String Purchase_Price; //구매 단가
	private String Sales_Price; //판매 단가, 구매단가 입력시 Null
	
	public itemVO() {
		super();
	}
	
}
