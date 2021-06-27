package com.myspring.StockManage.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("StockManageVO")
public class StockManageVO {
	
	String 	moveNum;			//이동번호
	Date 	moveDate;			//이동일자
	String 	outputWarehouse;	//출고창고
	String 	outputPlace;		//출고장소
	String 	outputBusiness;		//출고장소
	String 	inputWarehouse;		//입고창고
	String 	inputPlace;			//입고장소
	String 	inputBusiness;			//입고장소
	String 	note;				//비고
	String 	no;					//넘버
	String 	itemCode;			//품번
	String 	itemName;			//품명
	String 	standard;			//규격
	String 	inventoryUnit;		//단위
	int 	moveQuantity;		//이동수량
	int 	movePrice;			//이동단가
	String 	modNum;				//조정번호
	Date 	modDate;			//조정일자
	String 	houseCode;			//창고
	String 	locationCode;		//장소
	String 	generalCustomerCode;//거래처
	String 	kind;				//조정종류
	int 	modQuantity;		//조정수량
	String 	setCode;			//set모품목품번
	String 	inputQuantity;		//입고조정수량
	String 	outputQuantity;		//출고조정수량
	String 	purchasePrice;		//구매단가
	String 	salesPrice;			//판매단가
	String 	type;			//판매단가
	String 	typeCode;			//판매단가
	String 	typeName;			//판매단가
	int quantity;	//재고수량
	
	
	
	String 	busCode;
	String 	busName;
	java.util.Date startDate, endDate;
	
	private List<StockManageVO> StoVO;
	private List<StockManageVO> subListStoVO;
	private List<StockManageVO> updateListStoVO;
	

	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public List<StockManageVO> getUpdateListStoVO() {
		return updateListStoVO;
	}
	public void setUpdateListStoVO(List<StockManageVO> updateListStoVO) {
		this.updateListStoVO = updateListStoVO;
	}
	public List<StockManageVO> getSubListStoVO() {
		return subListStoVO;
	}
	public void setSubListStoVO(List<StockManageVO> subListStoVO) {
		this.subListStoVO = subListStoVO;
	}
	public String getOutputBusiness() {
		return outputBusiness;
	}
	public void setOutputBusiness(String outputBusiness) {
		this.outputBusiness = outputBusiness;
	}
	public String getInputBusiness() {
		return inputBusiness;
	}
	public void setInputBusiness(String inputBusiness) {
		this.inputBusiness = inputBusiness;
	}
	public String getBusCode() {
		return busCode;
	}
	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	
	public List<StockManageVO> getStoVO() {
		return StoVO;
	}
	public void setStoVO(List<StockManageVO> stoVO) {
		StoVO = new ArrayList();
	}
	public String getMoveNum() {
		return moveNum;
	}
	public void setMoveNum(String moveNum) {
		this.moveNum = moveNum;
	}
	public Date getMoveDate() {
		return moveDate;
	}
	public void setMoveDate(Date moveDate) {
		this.moveDate = moveDate;
	}
	public String getOutputWarehouse() {
		return outputWarehouse;
	}
	public void setOutputWarehouse(String outputWarehouse) {
		this.outputWarehouse = outputWarehouse;
	}
	public String getOutputPlace() {
		return outputPlace;
	}
	public void setOutputPlace(String outputPlace) {
		this.outputPlace = outputPlace;
	}
	public String getInputWarehouse() {
		return inputWarehouse;
	}
	public void setInputWarehouse(String inputWarehouse) {
		this.inputWarehouse = inputWarehouse;
	}
	public String getInputPlace() {
		return inputPlace;
	}
	public void setInputPlace(String inputPlace) {
		this.inputPlace = inputPlace;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	public int getMoveQuantity() {
		return moveQuantity;
	}
	public void setMoveQuantity(int moveQuantity) {
		this.moveQuantity = moveQuantity;
	}
	public int getMovePrice() {
		return movePrice;
	}
	public void setMovePrice(int movePrice) {
		this.movePrice = movePrice;
	}
	public String getModNum() {
		return modNum;
	}
	public void setModNum(String modNum) {
		this.modNum = modNum;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getHouseCode() {
		return houseCode;
	}
	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getGeneralCustomerCode() {
		return generalCustomerCode;
	}
	public void setGeneralCustomerCode(String generalCustomerCode) {
		this.generalCustomerCode = generalCustomerCode;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getModQuantity() {
		return modQuantity;
	}
	public void setModQuantity(int modQuantity) {
		this.modQuantity = modQuantity;
	}
	public String getSetCode() {
		return setCode;
	}
	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}
	public String getInputQuantity() {
		return inputQuantity;
	}
	public void setInputQuantity(String inputQuantity) {
		this.inputQuantity = inputQuantity;
	}
	public String getOutputQuantity() {
		return outputQuantity;
	}
	public void setOutputQuantity(String outputQuantity) {
		this.outputQuantity = outputQuantity;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	public java.util.Date getStartDate() {
		return startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	public java.util.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		String valueStr = "moveNum : " + moveNum
				        + ", moveDate : " + moveDate
				        + ", outPutWare : " + outputWarehouse
				        + ", outPutPlace : " + outputPlace
				        + ", inputWare : " + inputWarehouse
				        + ", inputPlace : " + inputPlace
				        + ", note : " + note
				        + ", outputBusiness : " + outputBusiness
				        + ", inputBusiness : " + inputBusiness
				        + ", moveNum : " + moveNum
				        + ", itemCode : " + itemCode
				        + ", itemName : " + itemName
				        + ", standard : " + standard
				        + ", inventoryUnit : " + inventoryUnit
				        + ", moveQuantity : " + moveQuantity
				        ;
		return valueStr;
	}
	public String toString1() {
		// TODO Auto-generated method stub
		
		String valueStr = "moveNum : " + moveNum
		        + ", moveDate : " + moveDate
		        + ", itemCode : " + itemCode
		        + ", itemName : " + itemName
		        + ", standard : " + standard
		        + ", inventoryUnit : " + inventoryUnit
		        + ", moveQuantity : " + moveQuantity
		        
		        ;
return valueStr;
	}
	
	
	// 수주등록 파트
	String ordersNum;
	Date   ordersdate;
	String customerCode;
	String tax;
	String Note;


	public String getOrdersNum() {
		return ordersNum;
	}
	public void setOrdersNum(String ordersNum) {
		this.ordersNum = ordersNum;
	}
	public Date getOrdersdate() {
		return ordersdate;
	}
	public void setOrdersdate(Date ordersdate) {
		this.ordersdate = ordersdate;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	///////// 메뉴검색바
	
	String menu;
	String url;


	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	

	
}
