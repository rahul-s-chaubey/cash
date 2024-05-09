package com.idbiintech.cash.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORKFLOW_PROCESS")
public class WorkflowProcess {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOB_ID")
	public Integer jobId;
	
	@Column(name = "CUSTOMETR_ID")
	public Integer customerId;
	
	@Column(name = "USER_ID")
	public Integer userId;
	
	@Column(name = "MODULE_ID")
	public Integer moduleId;
	
	@Column(name = "APPLICATION_ID")
	public Integer applicationId;
	
	@Column(name = "REQUEST_TYPE")
	public String requestType;
	
	@Column(name = "JOB_STATUS")
	public String jobStatus;
	
	@Column(name = "USERID")
	public String jobLabel;
	
	@Column(name = "CREATED_BY")
	public Integer createdBy;
	
	@Column(name = "STAGE_NO")
	public Integer stageNo;
	
	@Column(name = "ASSIGNED_TO")
	public Integer assignedTo; //ROLE_ID
	
	@Column(name = "MAKER_ID")
	public Integer makerId;
	
	@Column(name = "CREATE_TS")
	public Date createTs;
	
	@Column(name = "UPDATE_TS")
	public Date updateTs;
	
	@Column(name="dealer_master_id")
	Integer dealerMasterId;
	
	@Column(name = "status", nullable = true)
	private String status;
		
	@Column(name = "role_id")
	private Integer roleId;
	
	
	
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

	public Integer getDealerMasterId() {
		return dealerMasterId;
	}

	public void setDealerMasterId(Integer dealerMasterId) {
		this.dealerMasterId = dealerMasterId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getJobLabel() {
		return jobLabel;
	}

	public void setJobLabel(String jobLabel) {
		this.jobLabel = jobLabel;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getStageNo() {
		return stageNo;
	}

	public void setStageNo(Integer stageNo) {
		this.stageNo = stageNo;
	}

	public Integer getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Integer assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Integer getMakerId() {
		return makerId;
	}

	public void setMakerId(Integer makerId) {
		this.makerId = makerId;
	}

	public Date getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}

	public Date getUpdateTs() {
		return updateTs;
	}

	public void setUpdateTs(Date updateTs) {
		this.updateTs = updateTs;
	}
	
	
	
	
}
