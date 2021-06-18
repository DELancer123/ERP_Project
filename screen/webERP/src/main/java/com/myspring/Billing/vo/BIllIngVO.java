package com.myspring.Billing.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myspring.MainPlan.vo.MainPlanVO;

@Component("billingVO")
public class BIllIngVO {
private int sequence;
private String claim_no;
private Date claim_date;
private String claim_division;
private String note;
private List<BIllIngVO> ListVO;


public BIllIngVO(int sequence,String claim_no,Date claim_date,String claim_division,String note)
{
	this.sequence=sequence;
	this.claim_no = claim_no;
	this.claim_date = claim_date;
	this.claim_division = claim_division;
	this.note = note;
}

@Override
public String toString() {return Arrays.toString(ListVO.toArray());}

public BIllIngVO() {super();}

public List<BIllIngVO> getListVO() {return ListVO;}
public void setListVO(List<BIllIngVO> listVO) {ListVO = new ArrayList();}

public String getClaim_no() {return claim_no;}
public void setClaim_no(String claim_no) {this.claim_no=claim_no;}

public Date getClaim_date() {return claim_date;}
public void setClaim_date(Date claim_date) {this.claim_date=claim_date;}

public String getClaim_division() {return claim_division;}
public void setClaim_division(String claim_division) {this.claim_division=claim_division;}

public String getNote() {return note;}
public void setNote(String note) {this.note=note;}

public int getSequence() {return sequence;}
public void setSequence(int sequence) {this.sequence=sequence;}

}
