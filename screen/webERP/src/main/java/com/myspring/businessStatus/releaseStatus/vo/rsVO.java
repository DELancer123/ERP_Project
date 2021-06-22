package com.myspring.businessStatus.releaseStatus.vo;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("rsVO")
public class rsVO {
	private String itemCode; //품번
	private String itemName; //품명
	private String standard; //규격
	private String inventoryUnit; //단위
	private Date dueDate; //납기일
	private int orderQuantity; //주문수량
	private int productPrice; //단가
	private Date expectedDate; //출하예정일(수주)
	private Date releaseExpectedDate; //출고예정일(의뢰)
	private String inspection; //검사(의뢰,수주)
	private String orderOX; //출고구분
	private String customerCode; //고객코드
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
