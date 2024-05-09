package com.idbiintech.cash.DTO;

import java.sql.Date;

public class LoanDetailDTO {



	private long loanmstId;

	private String loanCategory;
	
	private long customerId;
	
	private long loandetId;
	
	private long loanAmount;
	
	private long loanInterest;
	
	private long loanDuration;
	
	private Date loanproposalDate;
	
	private String loanPurpose;
	
	private String loanStatus;
	
	private String smartcontractPath;

	public long getLoanmstId() {
		return loanmstId;
	}

	public void setLoanmstId(long loanmstId) {
		this.loanmstId = loanmstId;
	}

	public String getLoanCategory() {
		return loanCategory;
	}

	public void setLoanCategory(String loanCategory) {
		this.loanCategory = loanCategory;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getLoandetId() {
		return loandetId;
	}

	public void setLoandetId(long loandetId) {
		this.loandetId = loandetId;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public long getLoanInterest() {
		return loanInterest;
	}

	public void setLoanInterest(long loanInterest) {
		this.loanInterest = loanInterest;
	}

	public long getLoanDuration() {
		return loanDuration;
	}

	public void setLoanDuration(long loanDuration) {
		this.loanDuration = loanDuration;
	}

	public Date getLoanproposalDate() {
		return loanproposalDate;
	}

	public void setLoanproposalDate(Date loanproposalDate) {
		this.loanproposalDate = loanproposalDate;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getSmartcontractPath() {
		return smartcontractPath;
	}

	public void setSmartcontractPath(String smartcontractPath) {
		this.smartcontractPath = smartcontractPath;
	}
	
	
	
}
