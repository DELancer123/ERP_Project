package com.myspring.salesmanage.pop.custView.vo;

import org.springframework.stereotype.Component;

@Component("custViewVO")
public class CustViewVO {

	private String General_Customer_Code; //ê±°ë˜ì²? ì½”ë“œ
	private String General_Customer_Name;  //ê±°ë˜ì²˜ëª…
	private String Company_Registration_Number; //?‚¬?—…? ë²ˆí˜¸
	private String Representativs_Name; //???‘œ?´ë¦?
	
	public CustViewVO() {
		
	}
	
	public CustViewVO( String General_Customer_Code, String General_Customer_Name, 
			String Company_Registration_Number, String Representativs_Name) {
		this.General_Customer_Code =  General_Customer_Code;
		this.General_Customer_Name =  General_Customer_Name;
		this.Company_Registration_Number = Company_Registration_Number; 
		this.Representativs_Name = Representativs_Name; 
		
	}
	
	public String getGeneral_Customer_Code() {
		return General_Customer_Code;
	}
	public void setGeneral_Customer_Code(String general_Customer_Code) {
		General_Customer_Code = general_Customer_Code;
	}
	public String getGeneral_Customer_Name() {
		return General_Customer_Name;
	}
	public void setGeneral_Customer_Name(String general_Customer_Name) {
		General_Customer_Name = general_Customer_Name;
	}
	public String getCompany_Registration_Number() {
		return Company_Registration_Number;
	}
	public void setCompany_Registration_Number(String company_Registration_Number) {
		Company_Registration_Number = company_Registration_Number;
	}
	public String getRepresentativs_Name() {
		return Representativs_Name;
	}
	public void setRepresentativs_Name(String representativs_Name) {
		Representativs_Name = representativs_Name;
	}

}
