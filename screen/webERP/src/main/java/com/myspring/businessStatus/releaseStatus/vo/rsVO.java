package com.myspring.businessStatus.releaseStatus.vo;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("rsVO")
public class rsVO {
	private String itemCode; //ǰ��
	private String itemName; //ǰ��
	private String standard; //�԰�
	private String inventoryUnit; //����
	private Date dueDate; //������
	private int orderQuantity; //�ֹ�����
	private int productPrice; //�ܰ�
	private Date expectedDate; //���Ͽ�����(����)
	private Date releaseExpectedDate; //�������(�Ƿ�)
	private String inspection; //�˻�(�Ƿ�,����)
	private String orderOX; //�����
	private String customerCode; //���ڵ�
	private List<rsVO> ListVO;
	
	@Override
	public String toString() {
		return Arrays.toString(ListVO.toArray());
	}
	
	public rsVO() {
		super();
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

	public String getInventoryUnit() {
		return inventoryUnit;
	}

	public void setInventoryUnit(String inventoryUnit) {
		this.inventoryUnit = inventoryUnit;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public Date getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	public Date getReleaseExpectedDate() {
		return releaseExpectedDate;
	}

	public void setReleaseExpectedDate(Date releaseExpectedDate) {
		this.releaseExpectedDate = releaseExpectedDate;
	}

	public String getInspection() {
		return inspection;
	}

	public void setInspection(String inspection) {
		this.inspection = inspection;
	}

	public String getOrderOX() {
		return orderOX;
	}

	public void setOrderOX(String orderOX) {
		this.orderOX = orderOX;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public List<rsVO> getListVO() {
		return ListVO;
	}

	public void setListVO(List<rsVO> listVO) {
		ListVO = listVO;
	}
	
	
}
