package com.idbiintech.cash.DTO;

public class BankManagerResponseWrapperDTO {

	
	
	Integer bankMasterId;
	
	String bankName;

	String address;

	String contact;

	String swiftCode;
	
	String ifscCode;

	String regNo;
	
	private ResponseUIVO responseUIVO;

	public Integer getBankMasterId() {
		return bankMasterId;
	}

	public void setBankMasterId(Integer bankMasterId) {
		this.bankMasterId = bankMasterId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public ResponseUIVO getResponseUIVO() {
		return responseUIVO;
	}

	public void setResponseUIVO(ResponseUIVO responseUIVO) {
		this.responseUIVO = responseUIVO;
	}
	
	
	
}
