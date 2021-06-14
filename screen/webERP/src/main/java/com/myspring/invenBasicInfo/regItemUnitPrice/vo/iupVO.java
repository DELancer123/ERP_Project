package com.myspring.invenBasicInfo.regItemUnitPrice.vo;

//import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("iupVO")
public class iupVO {
	private String no; //PK�ɱ� ���� �ѹ��ڵ�
	private String itemCode; //ǰ��
	private String itemName; //ǰ��
	private String standard; //�԰�
	private String inventory_Unit; //����
	private String kind; // ������(���Ŵܰ�,�ǸŴܰ�)
	private int purchasePrice; //���� �ܰ�
	private int salesPrice; //�Ǹ� �ܰ�, ���Ŵܰ� �Է½� Null
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
		no = no;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
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
		return inventory_Unit;
	}

	public void setInventory_Unit(String inventory_Unit) {
		this.inventory_Unit = inventory_Unit;
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
