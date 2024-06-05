package com.idbiintech.cash.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SCHEME_MASTER")
public class SchemeMaster {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)    	
	@Column(name="scheme_master_id")
	Integer schemeMasterId;
	
	@Column(name="caste_name")
	String casteName;
	
	@Column(name="income_bracket")
	String incomeBracket;
	
	@Column(name="subsidy_name")
	String subsidyName;
	
	@Column(name="subsidy_amount")
	String subsidyAmount;
	
	@Column(name="description")
	String description;
	
	@Column(name="start_date")
	String startDate;
	
	@Column(name ="end_date")
	Integer endDate;

	public Integer getSchemeMasterId() {
		return schemeMasterId;
	}

	public void setSchemeMasterId(Integer schemeMasterId) {
		this.schemeMasterId = schemeMasterId;
	}

	public String getCasteName() {
		return casteName;
	}

	public void setCasteName(String casteName) {
		this.casteName = casteName;
	}

	public String getIncomeBracket() {
		return incomeBracket;
	}

	public void setIncomeBracket(String incomeBracket) {
		this.incomeBracket = incomeBracket;
	}

	public String getSubsidyName() {
		return subsidyName;
	}

	public void setSubsidyName(String subsidyName) {
		this.subsidyName = subsidyName;
	}

	public String getSubsidyAmount() {
		return subsidyAmount;
	}

	public void setSubsidyAmount(String subsidyAmount) {
		this.subsidyAmount = subsidyAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Integer getEndDate() {
		return endDate;
	}

	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}

	
	

}
