package com.myspring.systemmag.vo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("SystemmagVO")
public class SystemmagVO {
//	private String company_Code;
//	private String company_Name;
//	private String sortation;
//	private String fiscal_Year_Number;
//	private String fiscal_Year_Dates;
//	private String fiscal_Year_Datee;
//	private String company_Registration_Number;
//	private String corporate_Registration_Number;
//	private String representatives_Name;
//	private String resident_Registration_Number;
//	private String main_Store_Postal_Code;
//	private String main_Store_Address;
//	private String main_Branch_Number;
//	private String main_Store_Tel;
//	private String upstate;
//	private String industry;
//	private String date_Of_Establishment;
//	private String whether_To_Use_Status;
//	private List<SystemmagVO> ListVO;
	
	//일반거래처등록
	//SM_BIM_GEN_CUS_REG
	private String general_Customer_Code;
	private String general_Customer_Name;
	private String general_Customer_Division;
	private String company_Registration_Number;
	private String resident_Registration_Number;
	private String representativs_Name;
	private String upstate;
	private String industry;
	private String zipCode;
	private String workplace_Address;
	private String generalCustomer_Tel;
	private String wholesale_Retail_Business_Code;
	
	private String road_Address;
	private String lot_Address;
	
	private List<SystemmagVO> ListVO;
	
	public String getGeneral_Customer_Code() {
		return general_Customer_Code;
	}
	public void setGeneral_Customer_Code(String general_Customer_Code) {
		this.general_Customer_Code = general_Customer_Code;
	}
	public String getGeneral_Customer_Name() {
		return general_Customer_Name;
	}
	public void setGeneral_Customer_Name(String general_Customer_Name) {
		this.general_Customer_Name = general_Customer_Name;
	}
	public String getGeneral_Customer_Division() {
		return general_Customer_Division;
	}
	public void setGeneral_Customer_Division(String general_Customer_Division) {
		this.general_Customer_Division = general_Customer_Division;
	}
	public String getCompany_Registration_Number() {
		return company_Registration_Number;
	}
	public void setCompany_Registration_Number(String company_Registration_Number) {
		this.company_Registration_Number = company_Registration_Number;
	}
	public String getResident_Registration_Number() {
		return resident_Registration_Number;
	}
	public void setResident_Registration_Number(String resident_Registration_Number) {
		this.resident_Registration_Number = resident_Registration_Number;
	}
	public String getRepresentativs_Name() {
		return representativs_Name;
	}
	public void setRepresentativs_Name(String representativs_Name) {
		this.representativs_Name = representativs_Name;
	}
	public String getUpstate() {
		return upstate;
	}
	public void setUpstate(String upstate) {
		this.upstate = upstate;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getWorkplace_Address() {
		return workplace_Address;
	}
	public void setWorkplace_Address(String workplace_Address) {
		this.workplace_Address = workplace_Address;
	}
	public String getGeneralCustomer_Tel() {
		return generalCustomer_Tel;
	}
	public void setGeneralCustomer_Tel(String generalCustomer_Tel) {
		this.generalCustomer_Tel = generalCustomer_Tel;
	}
	public String getWholesale_Retail_Business_Code() {
		return wholesale_Retail_Business_Code;
	}
	public void setWholesale_Retail_Business_Code(String wholesale_Retail_Business_Code) {
		this.wholesale_Retail_Business_Code = wholesale_Retail_Business_Code;
	}
	public List<SystemmagVO> getListVO() {
		return ListVO;
	}
	public void setListVO(List<SystemmagVO> listVO) {
		ListVO = listVO;
	}
	public String getRoad_Address() {
		return road_Address;
	}
	public void setRoad_Address(String road_Address) {
		this.road_Address = road_Address;
	}
	public String getLot_Address() {
		return lot_Address;
	}
	public void setLot_Address(String lot_Address) {
		this.lot_Address = lot_Address;
	}
	
	//창고/공정/외주공정등록--
	//SM_BIM_HOU_REG => 창고/장소 탭에서 사용함
	private String house_Code;
	private String house_Name;
	private String house_Location_In;
	private String house_Location_Out;
	private String house_Explanation;
	private String house_Status;
	
	public String getHouse_Code() {
		return house_Code;
	}
	public void setHouse_Code(String house_Code) {
		this.house_Code = house_Code;
	}
	public String getHouse_Name() {
		return house_Name;
	}
	public void setHouse_Name(String house_Name) {
		this.house_Name = house_Name;
	}
	public String getHouse_Location_In() {
		return house_Location_In;
	}
	public void setHouse_Location_In(String house_Location_In) {
		this.house_Location_In = house_Location_In;
	}
	public String getHouse_Location_Out() {
		return house_Location_Out;
	}
	public void setHouse_Location_Out(String house_Location_Out) {
		this.house_Location_Out = house_Location_Out;
	}
	public String getHouse_Explanation() {
		return house_Explanation;
	}
	public void setHouse_Explanation(String house_Explanation) {
		this.house_Explanation = house_Explanation;
	}
	public String getHouse_Status() {
		return house_Status;
	}
	public void setHouse_Status(String house_Status) {
		this.house_Status = house_Status;
	}

	//SM_BIM_PRO_REG => 생산공정/작업장 탭에서 사용함
	private String process_Code;
	private String process_Name;
	private String process_Location_In;
	private String process_Location_Out;
	private String process_Explanation;
	private String process_Status;
	
	public String getProcess_Code() {
		return process_Code;
	}
	public void setProcess_Code(String process_Code) {
		this.process_Code = process_Code;
	}
	public String getProcess_Name() {
		return process_Name;
	}
	public void setProcess_Name(String process_Name) {
		this.process_Name = process_Name;
	}
	public String getProcess_Location_In() {
		return process_Location_In;
	}
	public void setProcess_Location_In(String process_Location_In) {
		this.process_Location_In = process_Location_In;
	}
	public String getProcess_Location_Out() {
		return process_Location_Out;
	}
	public void setProcess_Location_Out(String process_Location_Out) {
		this.process_Location_Out = process_Location_Out;
	}
	public String getProcess_Explanation() {
		return process_Explanation;
	}
	public void setProcess_Explanation(String process_Explanation) {
		this.process_Explanation = process_Explanation;
	}
	public String getProcess_Status() {
		return process_Status;
	}
	public void setProcess_Status(String process_Status) {
		this.process_Status = process_Status;
	}

	//SM_BIM_OUT_REG => 외주공정/작업장 탭에서 사용함
	private String outsourcing_Code; 
	private String outsourcing_Name;
	private String outsourcing_Location_In;
	private String outsourcing_Location_Out;
	private String outsourcing_Explanation;
	private String outsourcing_Status;

	public String getOutsourcing_Code() {
		return outsourcing_Code;
	}
	public void setOutsourcing_Code(String outsourcing_Code) {
		this.outsourcing_Code = outsourcing_Code;
	}
	public String getOutsourcing_Name() {
		return outsourcing_Name;
	}
	public void setOutsourcing_Name(String outsourcing_Name) {
		this.outsourcing_Name = outsourcing_Name;
	}
	public String getOutsourcing_Location_In() {
		return outsourcing_Location_In;
	}
	public void setOutsourcing_Location_In(String outsourcing_Location_In) {
		this.outsourcing_Location_In = outsourcing_Location_In;
	}
	public String getOutsourcing_Location_Out() {
		return outsourcing_Location_Out;
	}
	public void setOutsourcing_Location_Out(String outsourcing_Location_Out) {
		this.outsourcing_Location_Out = outsourcing_Location_Out;
	}
	public String getOutsourcing_Explanation() {
		return outsourcing_Explanation;
	}
	public void setOutsourcing_Explanation(String outsourcing_Explanation) {
		this.outsourcing_Explanation = outsourcing_Explanation;
	}
	public String getOutsourcing_Status() {
		return outsourcing_Status;
	}
	public void setOutsourcing_Status(String outsourcing_Status) {
		this.outsourcing_Status = outsourcing_Status;
	}
	
	//SM_BIM_WOR_REG => 창고/장소 하위테이블
	private String location_Code;
	private String location_Name;
	private String location_Explanation;
	private String release_Code;
	private String release_Customer;
	private String suitability;
	private String availability;
	private String status;

	public String getLocation_Code() {
		return location_Code;
	}
	public void setLocation_Code(String location_Code) {
		this.location_Code = location_Code;
	}
	public String getLocation_Name() {
		return location_Name;
	}
	public void setLocation_Name(String location_Name) {
		this.location_Name = location_Name;
	}
	public String getLocation_Explanation() {
		return location_Explanation;
	}
	public void setLocation_Explanation(String location_Explanation) {
		this.location_Explanation = location_Explanation;
	}
	public String getRelease_Code() {
		return release_Code;
	}
	public void setRelease_Code(String release_Code) {
		this.release_Code = release_Code;
	}
	public String getRelease_Customer() {
		return release_Customer;
	}
	public void setRelease_Customer(String release_Customer) {
		this.release_Customer = release_Customer;
	}
	public String getSuitability() {
		return suitability;
	}
	public void setSuitability(String suitability) {
		this.suitability = suitability;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	//SM_BIM_PRO_WOR_REG => 생산공정/작업장 하위테이블
	private String workplace_Code;
	private String workplace_Name; 
	private String workplace_Explanation;
	
	public String getWorkplace_Code() {
		return workplace_Code;
	}
	public void setWorkplace_Code(String workplace_Code) {
		this.workplace_Code = workplace_Code;
	}
	public String getWorkplace_Name() {
		return workplace_Name;
	}
	public void setWorkplace_Name(String workplace_Name) {
		this.workplace_Name = workplace_Name;
	}
	public String getWorkplace_Explanation() {
		return workplace_Explanation;
	}
	public void setWorkplace_Explanation(String workplace_Explanation) {
		this.workplace_Explanation = workplace_Explanation;
	}

	//SM_BIM_OUT_WOR_REG => 외주공정/작업장 하위테이블
	private String outcustomer;
	private String outcustomer_Name;

	public String getOutcustomer() {
		return outcustomer;
	}
	public void setOutcustomer(String outcustomer) {
		this.outcustomer = outcustomer;
	}
	public String getOutcustomer_Name() {
		return outcustomer_Name;
	}
	public void setOutcustomer_Name(String outcustomer_Name) {
		this.outcustomer_Name = outcustomer_Name;
	}
	
	//물류관리내역등록
	//SM_BIM_LOG_MAN
	private String logistics_In_Code;
	private String logistics_In_Name;
	private String explanation;
	private String remarks;

	public String getLogistics_In_Code() {
		return logistics_In_Code;
	}
	public void setLogistics_In_Code(String logistics_In_Code) {
		this.logistics_In_Code = logistics_In_Code;
	}
	public String getLogistics_In_Name() {
		return logistics_In_Name;
	}
	public void setLogistics_In_Name(String logistics_In_Name) {
		this.logistics_In_Name = logistics_In_Name;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

	
//	public String getCompany_Code() {
//		return company_Code;
//	}
//	public void setCompany_Code(String company_Code) {
//		this.company_Code = company_Code;
//	}
//	public String getCompany_Name() {
//		return company_Name;
//	}
//	public void setCompany_Name(String company_Name) {
//		this.company_Name = company_Name;
//	}
//	public String getSortation() {
//		return sortation;
//	}
//	public void setSortation(String sortation) {
//		this.sortation = sortation;
//	}
//	public String getFiscal_Year_Number() {
//		return fiscal_Year_Number;
//	}
//	public void setFiscal_Year_Number(String fiscal_Year_Number) {
//		this.fiscal_Year_Number = fiscal_Year_Number;
//	}
//	public String getFiscal_Year_Dates() {
//		return fiscal_Year_Dates;
//	}
//	public void setFiscal_Year_Dates(String fiscal_Year_Dates) {
//		this.fiscal_Year_Dates = fiscal_Year_Dates;
//	}
//	public String getFiscal_Year_Datee() {
//		return fiscal_Year_Datee;
//	}
//	public void setFiscal_Year_Datee(String fiscal_Year_Datee) {
//		this.fiscal_Year_Datee = fiscal_Year_Datee;
//	}
//	public String getCompany_Registration_Number() {
//		return company_Registration_Number;
//	}
//	public void setCompany_Registration_Number(String company_Registration_Number) {
//		this.company_Registration_Number = company_Registration_Number;
//	}
//	public String getCorporate_Registration_Number() {
//		return corporate_Registration_Number;
//	}
//	public void setCorporate_Registration_Number(String corporate_Registration_Number) {
//		this.corporate_Registration_Number = corporate_Registration_Number;
//	}
//	public String getRepresentatives_Name() {
//		return representatives_Name;
//	}
//	public void setRepresentatives_Name(String representatives_Name) {
//		this.representatives_Name = representatives_Name;
//	}
//	public String getResident_Registration_Number() {
//		return resident_Registration_Number;
//	}
//	public void setResident_Registration_Number(String resident_Registration_Number) {
//		this.resident_Registration_Number = resident_Registration_Number;
//	}
//	public String getMain_Store_Postal_Code() {
//		return main_Store_Postal_Code;
//	}
//	public void setMain_Store_Postal_Code(String main_Store_Postal_Code) {
//		this.main_Store_Postal_Code = main_Store_Postal_Code;
//	}
//	public String getMain_Store_Address() {
//		return main_Store_Address;
//	}
//	public void setMain_Store_Address(String main_Store_Address) {
//		this.main_Store_Address = main_Store_Address;
//	}
//	public String getMain_Branch_Number() {
//		return main_Branch_Number;
//	}
//	public void setMain_Branch_Number(String main_Branch_Number) {
//		this.main_Branch_Number = main_Branch_Number;
//	}
//	public String getMain_Store_Tel() {
//		return main_Store_Tel;
//	}
//	public void setMain_Store_Tel(String main_Store_Tel) {
//		this.main_Store_Tel = main_Store_Tel;
//	}
//	public String getUpstate() {
//		return upstate;
//	}
//	public void setUpstate(String upstate) {
//		this.upstate = upstate;
//	}
//	public String getIndustry() {
//		return industry;
//	}
//	public void setIndustry(String industry) {
//		this.industry = industry;
//	}
//	public String getDate_Of_Establishment() {
//		return date_Of_Establishment;
//	}
//	public void setDate_Of_Establishment(String date_Of_Establishment) {
//		this.date_Of_Establishment = date_Of_Establishment;
//	}
//	public String getWhether_To_Use_Status() {
//		return whether_To_Use_Status;
//	}
//	public void setWhether_To_Use_Status(String whether_To_Use_Status) {
//		this.whether_To_Use_Status = whether_To_Use_Status;
//	}
//	public List<SystemmagVO> getListVO() {
//		return ListVO;
//	}
//	public void setListVO(List<SystemmagVO> listVO) {
//		ListVO = listVO;
//	}
	
	
}

	