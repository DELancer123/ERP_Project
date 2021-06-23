package com.myspring.businessStatus.releaseStatus.vo;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("rsVO")
public class rsVO {
	private String releaseNum ; //����ȣ
	private Date releaseDate ; //�������
	private String customerCode; //��
	
	private String Item_Code; //ǰ��
	private String Item_Name; //ǰ��
	private Date dueDate; //������
	private int productPrice; //�ܰ�
	private int totPrice; //���ް�
	private int vat; //�ΰ���
	private int totVatPrice; //���޴밡
	private String orderOX; //�����
	
	private Date startDate;
	private Date endDate;
	private List<rsVO> ListVO;
	
	@Override
	public String toString() {
		return Arrays.toString(ListVO.toArray());
	}
	
	public rsVO() {
		super();
	}

	public String getReleaseNum() {
		return releaseNum;
	}

	public void setReleaseNum(String releaseNum) {
		this.releaseNum = releaseNum;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(int totPrice) {
		this.totPrice = totPrice;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public int getTotVatPrice() {
		return totVatPrice;
	}

	public void setTotVatPrice(int totVatPrice) {
		this.totVatPrice = totVatPrice;
	}

	public String getOrderOX() {
		return orderOX;
	}

	public void setOrderOX(String orderOX) {
		this.orderOX = orderOX;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<rsVO> getListVO() {
		return ListVO;
	}

	public void setListVO(List<rsVO> listVO) {
		ListVO = listVO;
	}

	
}
