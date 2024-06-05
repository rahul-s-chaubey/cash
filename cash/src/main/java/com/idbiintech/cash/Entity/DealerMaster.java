package com.idbiintech.cash.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DEALER_MASTER")
public class DealerMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    	
	@Column(name="dealer_master_id")
	Integer dealerMasterId;
	
	@Column(name="name")
	String name;
	
	@Column(name="address")
	String address;
	
	@Column(name="contact")
	String contact;
	
	@Column(name="GST")
	String gst;
	
	@Column(name="email")
	String email;
	
	@Column(name="TIN")
	String tin;
	
	@Column(name="Business_RegistrationNo")
	String BusinessRegistrationNo;
	
	@Column(name="acct_no")
	String accountNo;
	
	@Column(name="business_name")
	String businessname;

	@Column(name="bank_name")
	String bankName;
	
	@Column(name ="is_active")
	Integer isActive;
	
	
	@Column(name="user_type")
	String usertype;


	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getDealerMasterId() {
		return dealerMasterId;
	}

	public void setDealerMasterId(Integer dealerMasterId) {
		this.dealerMasterId = dealerMasterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getBusinessRegistrationNo() {
		return BusinessRegistrationNo;
	}

	public void setBusinessRegistrationNo(String businessRegistrationNo) {
		BusinessRegistrationNo = businessRegistrationNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBusinessname() {
		return businessname;
	}

	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	
	
	
	
	
}
