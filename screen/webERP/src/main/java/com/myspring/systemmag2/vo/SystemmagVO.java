package com.myspring.systemmag2.vo;

import org.springframework.stereotype.Component;

@Component("SystemmagVO")
public class SystemmagVO {
	private String Company_Code;
	private String Company_Name;
	private String Sortation;
	private String Fiscal_Year_Number;
	private String Fiscal_Year_Date;
	private String Company_Registration_Number; //사업자등록번호
	private String Corporate_Registration_Number;
	private String Representatives_Name; //대표자성명
	private String Resident_Registration_Number; //주민등록번호
	private String Main_Store_Postal_Code;
	private String Main_Store_Address;
	private String Main_Branch_Number;
	private String Main_Store_Tel;
	private String Upstate; //업태
	private String Industry; //종목
	private String Date_Of_Establishment;
	private String Whether_To_Use_Status;
	//-----------------------------systemmag2
	private String General_Customer_Code; //코드
	private String General_Customer_Name; //거래처명
	private String General_Customer_Division; //구분
	private String ZipCode; //우편번호
	private String Workplace_Address; //사업장주소
	
	
	
	
	
	public String getCompany_Code() {
		return Company_Code;
	}
	public void setCompany_Code(String company_Code) {
		Company_Code = company_Code;
	}
	public String getCompany_Name() {
		return Company_Name;
	}
	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}
	public String getSortation() {
		return Sortation;
	}
	public void setSortation(String sortation) {
		Sortation = sortation;
	}
	public String getFiscal_Year_Number() {
		return Fiscal_Year_Number;
	}
	public void setFiscal_Year_Number(String fiscal_Year_Number) {
		Fiscal_Year_Number = fiscal_Year_Number;
	}
	public String getFiscal_Year_Date() {
		return Fiscal_Year_Date;
	}
	public void setFiscal_Year_Date(String fiscal_Year_Date) {
		Fiscal_Year_Date = fiscal_Year_Date;
	}
	public String getCompany_Registration_Number() {
		return Company_Registration_Number;
	}
	public void setCompany_Registration_Number(String company_Registration_Number) {
		Company_Registration_Number = company_Registration_Number;
	}
	public String getCorporate_Registration_Number() {
		return Corporate_Registration_Number;
	}
	public void setCorporate_Registration_Number(String corporate_Registration_Number) {
		Corporate_Registration_Number = corporate_Registration_Number;
	}
	public String getRepresentatives_Name() {
		return Representatives_Name;
	}
	public void setRepresentatives_Name(String representatives_Name) {
		Representatives_Name = representatives_Name;
	}
	public String getResident_Registration_Number() {
		return Resident_Registration_Number;
	}
	public void setResident_Registration_Number(String resident_Registration_Number) {
		Resident_Registration_Number = resident_Registration_Number;
	}
	public String getMain_Store_Postal_Code() {
		return Main_Store_Postal_Code;
	}
	public void setMain_Store_Postal_Code(String main_Store_Postal_Code) {
		Main_Store_Postal_Code = main_Store_Postal_Code;
	}
	public String getMain_Store_Address() {
		return Main_Store_Address;
	}
	public void setMain_Store_Address(String main_Store_Address) {
		Main_Store_Address = main_Store_Address;
	}
	public String getMain_Branch_Number() {
		return Main_Branch_Number;
	}
	public void setMain_Branch_Number(String main_Branch_Number) {
		Main_Branch_Number = main_Branch_Number;
	}
	public String getMain_Store_Tel() {
		return Main_Store_Tel;
	}
	public void setMain_Store_Tel(String main_Store_Tel) {
		Main_Store_Tel = main_Store_Tel;
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
	public String getDate_Of_Establishment() {
		return Date_Of_Establishment;
	}
	public void setDate_Of_Establishment(String date_Of_Establishment) {
		Date_Of_Establishment = date_Of_Establishment;
	}
	public String getWhether_To_Use_Status() {
		return Whether_To_Use_Status;
	}
	public void setWhether_To_Use_Status(String whether_To_Use_Status) {
		Whether_To_Use_Status = whether_To_Use_Status;
	}
}
