package com.idbiintech.cash.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="LOAN_DET")
public class LoanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LOAN_MST_ID")
	private long loanmstId;
	@Column(name="LOAN_CATEGORY")
	private String loanCategory;
	@Column(name="CUSTOMER_ID")
	private long customerId;
	@Column(name="LOAN_DET_ID")
	private long loandetId;
	@Column(name="LOAN_AMOUNT")
	private long loanAmount;
	@Column(name="LOAN_INTEREST")
	private long loanInterest;
	@Column(name="LOAN_DURATION")
	private long loanDuration;
	@Column(name="LOAN_PROPOSAL_DATE")
	private Date loanproposalDate;
	@Column(name="LOAN_PURPOSE")
	private String loanPurpose;
	@Column(name="LOAN_STATUS")
	private String loanStatus;
	@Column(name="SMARTCONTRACT_PATH")
	private String smartcontractPath;
	@Column(name="dealer_master_id")
	Integer dealerMasterId;
	@Column(name = "role_id")
	private Integer roleId;
	@Column(name = "status")
	private String status;
	
	@Column(name = "bank_name")
	private String bankname;	
	@Column(name = "car_make")
	private String carmake;
	@Column(name = "car_model")
	private String carmodel;
	@Column(name = "car_color")
	private String carcolor;
	@Column(name = "borrower_name")
	private String borrowername;
	@Column(name = "borrower_email")
	private String borrroweemail;
	
	
	
	
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getCarmake() {
		return carmake;
	}
	public void setCarmake(String carmake) {
		this.carmake = carmake;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	public String getBorrowername() {
		return borrowername;
	}
	public void setBorrowername(String borrowername) {
		this.borrowername = borrowername;
	}
	public String getBorrroweemail() {
		return borrroweemail;
	}
	public void setBorrroweemail(String borrroweemail) {
		this.borrroweemail = borrroweemail;
	}
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
	
	public Integer getDealerMasterId() {
		return dealerMasterId;
	}
	public void setDealerMasterId(Integer dealerMasterId) {
		this.dealerMasterId = dealerMasterId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
