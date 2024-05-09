package com.idbiintech.cash.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BANK_MASTER")
public class BankMaster {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    	
	@Column(name="bank_master_id")
	Integer bankMasterId;
	
	@Column(name="bank_name")
	String bankName;
	
	@Column(name="address")
	String address;
	
	@Column(name="contact")
	String contact;
	
	@Column(name="swift_code")
	String swiftCode;
	
	@Column(name="ifsc_code")
	String ifscCode;
	
	@Column(name="reg_no")
	String regNo;
	
	@Column(name ="is_active")
	Integer isActive;

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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	

	
	
}
