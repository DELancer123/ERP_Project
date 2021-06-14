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
	
	private String General_Customer_Code;
	private String General_Customer_Name;
	private String General_Customer_Division;
	private String Company_Registration_Number;
	private String Resident_Registration_Number;
	private String Representativs_Name;
	private String Upstate;
	private String Industry;
	private String ZipCode;
	private String Workplace_Address;
	private String GeneralCustomer_Tel;
	private String Wholesale_Retail_Business_Code;
	
	
	public String getGeneral_Customer_Code() {
		return General_Customer_Code;
	}
	public void setGeneral_Customer_Code(String general_Customer_Code) {
		this.General_Customer_Code = general_Customer_Code;
	}
	public String getGeneral_Customer_Name() {
		return General_Customer_Name;
	}
	public void setGeneral_Customer_Name(String general_Customer_Name) {
		this.General_Customer_Name = general_Customer_Name;
	}
	public String getGeneral_Customer_Division() {
		return General_Customer_Division;
	}
	public void setGeneral_Customer_Division(String general_Customer_Division) {
		this.General_Customer_Division = general_Customer_Division;
	}
	public String getCompany_Registration_Number() {
		return Company_Registration_Number;
	}
	public void setCompany_Registration_Number(String company_Registration_Number) {
		Company_Registration_Number = company_Registration_Number;
	}
	public String getResident_Registration_Number() {
		return Resident_Registration_Number;
	}
	public void setResident_Registration_Number(String resident_Registration_Number) {
		Resident_Registration_Number = resident_Registration_Number;
	}
	public String getRepresentativs_Name() {
		return Representativs_Name;
	}
	public void setRepresentativs_Name(String representativs_Name) {
		Representativs_Name = representativs_Name;
	}
	public String getUpstate() {
		return Upstate;
	}
	public void setUpstate(String upstate) {
		Upstate = upstate;
	}
	public String getIndustry() {
		return Industry;
	}
	public void setIndustry(String industry) {
		Industry = industry;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	public String getWorkplace_Address() {
		return Workplace_Address;
	}
	public void setWorkplace_Address(String workplace_Address) {
		Workplace_Address = workplace_Address;
	}
	public String getGeneralCustomer_Tel() {
		return GeneralCustomer_Tel;
	}
	public void setGeneralCustomer_Tel(String generalCustomer_Tel) {
		GeneralCustomer_Tel = generalCustomer_Tel;
	}
	public String getWholesale_Retail_Business_Code() {
		return Wholesale_Retail_Business_Code;
	}
	public void setWholesale_Retail_Business_Code(String wholesale_Retail_Business_Code) {
		Wholesale_Retail_Business_Code = wholesale_Retail_Business_Code;
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

	