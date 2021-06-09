package com.myspring.invenBasicInfo.regItemUnitPrice.vo;

//import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("IupVO")
public class IupVO {
	private String No; //PK�ɱ� ���� �ѹ��ڵ�(�����������)
	private String Item_Code; //ǰ��
	private String Item_Name; //ǰ��
	private String Standard; //�԰�
	private String Inventory_Unit; //����
	private String Kind; // ������(���Ŵܰ�,�ǸŴܰ�)
	private int Purchase_Price; //���� �ܰ�
	private int Sales_price; //�Ǹ� �ܰ�, ���Ŵܰ� �Է½� Null
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
