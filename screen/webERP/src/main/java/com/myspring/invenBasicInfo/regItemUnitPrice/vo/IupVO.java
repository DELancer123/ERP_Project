package com.myspring.invenBasicInfo.regItemUnitPrice.vo;

//import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("IupVO")
public class IupVO {
	private String No; //PK걸기 위한 넘버코드(출력하진않음)
	private String Item_Code; //품번
	private String Item_Name; //품명
	private String Standard; //규격
	private String Inventory_Unit; //단위
	private String Kind; // 탭종류(구매단가,판매단가)
	private int Purchase_Price; //구매 단가
	private int Sales_price; //판매 단가, 구매단가 입력시 Null
	private List<IupVO> ListVO;
	
	@Override
	public String toString() {
		return Arrays.toString(ListVO.toArray());
	}
	
	public IupVO() {
		super();
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		No = no;
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

	public String getStandard() {
		return Standard;
	}

	public void setStandard(String standard) {
		Standard = standard;
	}

	public String getInventory_Unit() {
		return Inventory_Unit;
	}

	public void setInventory_Unit(String inventory_Unit) {
		Inventory_Unit = inventory_Unit;
	}

	public String getKind() {
		return Kind;
	}

	public void setKind(String kind) {
		Kind = kind;
	}

	public int getPurchase_Price() {
		return Purchase_Price;
	}

	public void setPurchase_Price(int purchase_Price) {
		Purchase_Price = purchase_Price;
	}

	public int getSales_price() {
		return Sales_price;
	}

	public void setSales_price(int sales_price) {
		Sales_price = sales_price;
	}

	public List<IupVO> getListVO() {
		return ListVO;
	}

	public void setListVO(List<IupVO> listVO) {
		ListVO = listVO;
	}
	
	
}
