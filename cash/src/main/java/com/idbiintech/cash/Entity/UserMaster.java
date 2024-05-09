package com.idbiintech.cash.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_master")
public class UserMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private char gender;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "alt_mobile_number")
	private String altMobileNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "alt_address")
	private String altAddress;

	@Column(name = "is_active")
	private Integer isActive;

	@Column(name = "created_id")
	private Integer createId;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "updated_id")
	private Integer updatedId;

	@Column(name = "updated_date")
	private Date updatedDate;


	@Column(name = "transaction_limit")
	private Integer transactionLimit;

	@Column(name = "review_status")
	private Integer reviewStatus;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private String status;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "job_label")
	private String jobLabel;

	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name = "project_id")
	private Integer projectId;

	@Column(name = "db_version")
	private Integer dbVersion;
	
	@Column(name="dealer_master_id")
	Integer dealerMasterId;
	
	@Column(name="user_type")
	Integer usertype;
	

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	public Integer getDealerMasterId() {
		return dealerMasterId;
	}

	public void setDealerMasterId(Integer dealerMasterId) {
		this.dealerMasterId = dealerMasterId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAltMobileNumber() {
		return altMobileNumber;
	}

	public void setAltMobileNumber(String altMobileNumber) {
		this.altMobileNumber = altMobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAltAddress() {
		return altAddress;
	}

	public void setAltAddress(String altAddress) {
		this.altAddress = altAddress;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getUpdatedId() {
		return updatedId;
	}

	public void setUpdatedId(Integer updatedId) {
		this.updatedId = updatedId;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getTransactionLimit() {
		return transactionLimit;
	}

	public void setTransactionLimit(Integer transactionLimit) {
		this.transactionLimit = transactionLimit;
	}

	public Integer getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(Integer reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getJobLabel() {
		return jobLabel;
	}

	public void setJobLabel(String jobLabel) {
		this.jobLabel = jobLabel;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getDbVersion() {
		return dbVersion;
	}

	public void setDbVersion(Integer dbVersion) {
		this.dbVersion = dbVersion;
	}

	
}

