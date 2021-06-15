package com.myspring.salesmanage.estimate.vo;

import java.sql.Date;

public class EstimateVO {
	private String estCode;
	private String custCode;
	private String tax;
	private String item_code;
	private Date estDate;
	
//	--테이블 생성
//	create table CSM_SM_Est_Reg(
//	--견적 번호(PK)estCode
//	estimateNum varchar2(12) PRIMARY KEY,
//	--견적 일자(uk)estDate
//	estimateDate date,
//	--고객코드(FK)custCode
//	customerCode varchar2(12) not null,
//	--부가세 구분
//	tax varchar2(20) not null,
//	--비고
//	note varchar2(1000),
//	--테이블 생성
//	create table CSM_SM_COR_Reg(
//	--품번(공통)(FK)
//	Item_Code varchar2(12) not null,
//	--품명(공통)(FK)
//	Item_Name varchar2(50) not null,
//	--규격
//	standard varchar2(20) DEFAULT NULL,
//	--단위
//	Inventory_Unit varchar2(5) DEFAULT 'EA',
//	--납기일(견적, 수주, 출고의뢰)
//	dueDate date not null,
//	--주문 수량(공통)
//	ordersQuantity Number(5) DEFAULT '0',
//	--단가(견적, 수주, 출고처리)
//	productPrice Number(15) DEFAULT '0',
//	--출하예정일(수주)
//	expectedDate DATE not null,
//	--출고예정일(의뢰)
//	releaseExpectedDate date not null,
//	--검사(의뢰, 수주)
//	inspection Varchar2(10) not null,
//	--출고구분(예외/주문)(출고처리)
//	orderOX varchar2(20) not null,
//	--모든 등록과 연결하기 위한 고객코드
//	customerCode varchar2(12) not null,

	

}
