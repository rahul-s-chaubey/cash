package com.idbiintech.cash.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DEALER_DETAIL")
public class DealerDetail {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    	
	@Column(name="dealer_det_id")
	Integer dealerDetailId;
	
	@Column(name="bank_name")
	String bankName;
	
	@Column(name="branch")
	String branch;
	
	@Column(name="address")
	String address;
	
	@Column(name="acct_no")
	String acctNo;

	public Integer getDealerDetailId() {
		return dealerDetailId;
	}

	public void setDealerDetailId(Integer dealerDetailId) {
		this.dealerDetailId = dealerDetailId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	
	
	
}
