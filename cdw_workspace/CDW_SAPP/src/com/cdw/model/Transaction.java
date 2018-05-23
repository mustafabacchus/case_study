package com.cdw.model;

public class Transaction {
	
	private String creditNo, tranType;
	private int tranID, day, month, year, ssn, branchCode, count;
	private double tranVal;
	
	
	//GETTERS AND SETTERS
	public String getCreditNo() {
		return creditNo;
	}
	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public int getTranID() {
		return tranID;
	}
	public void setTranID(int tranID) {
		this.tranID = tranID;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public double getTranVal() {
		return tranVal;
	}
	public void setTranVal(double tranVal) {
		this.tranVal = tranVal;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	

	
}