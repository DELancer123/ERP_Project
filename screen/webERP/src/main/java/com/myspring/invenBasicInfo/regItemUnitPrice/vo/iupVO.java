package com.myspring.invenBasicInfo.regItemUnitPrice.vo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("iupVO")
public class iupVO {
	private String no; //PK걸기 위한 넘버코드
	private String itemNumber; //품번
	private String itemName; //품명
	private String standard; //규격
	private String inventoryUnit; //단위
	private String kind; // 탭종류(구매단가,판매단가)
	private int purchasePrice; //구매 단가
	private int salesPrice; //판매 단가, 구매단가 입력시 Null
	private List<iupVO> ListVO;
	
	@Override
	public String toString() {
		return Arrays.toString(ListVO.toArray());
	}
	
	public iupVO() {
		super();
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getInventory_Unit() {
		return inventoryUnit;
	}

	public void setInventory_Unit(String inventory_Unit) {
		this.inventoryUnit = inventoryUnit;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}

	public List<iupVO> getListVO() {
		return ListVO;
	}

	public void setListVO(List<iupVO> listVO) {
		ListVO = listVO;
	}

}
