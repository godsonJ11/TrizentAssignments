package com.Employeejdbc.demo;
public class EmployeeDetails {
	private  String eName;
	private String  eEmail;
	private String  cAddress;
	private String  pAddress;
	public EmployeeDetails(String eName, String eEmail, String cAddress, String pAddress) {
		this.eName = eName;
		this.eEmail = eEmail;
		this.cAddress = cAddress;
		this.pAddress = pAddress;
	}
	public EmployeeDetails() {
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteEmail() {
		return eEmail;
	}
	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public String getpAddress() {
		return pAddress;
	}
	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}
}
