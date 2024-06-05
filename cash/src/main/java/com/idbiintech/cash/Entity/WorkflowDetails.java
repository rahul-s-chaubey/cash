package com.idbiintech.cash.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class WorkflowDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "stage_id", nullable = true)
	private Integer stageId;

	@Column(name = "workflow_stagename", nullable = true)
	private String workflowStagename;

	@Column(name = "approved_by", nullable = true)
	private Integer approvedBy;
	@Column(name = "approved_date", nullable = true)
	private Date approvedDate;
	@Column(name = "rejected_by", nullable = true)
	private Integer rejectedBy;
	@Column(name = "rejected_date", nullable = true)
	private Date rejectedDate;
	@Column(name = "workflow_stage_no", nullable = true)
	private Integer workflowStageNo;

	@Column(name = "created_by_rolename", nullable = true)
	private String createdByRolename;
	@Column(name = "created_by_username", nullable = true)
	private String createdByUsername;
	@Column(name = "updated_by_rolename", nullable = true)
	private String updatedByRolename;
	@Column(name = "updated_by_username", nullable = true)
	private String updatedByUsername;

	@Column(name = "created_date", nullable = true)
	private Date createdDate;
	@Column(name = "updated_date", nullable = true)
	private Date updatedDate;
	@Column(name = "is_active", nullable = true)
	private Integer isActive;

	@Column(name = "workflow_id", nullable = true)
	private Integer workflowId;

	@Column(name = "role_id", nullable = true)
	private Integer roleId;

	@Column(name = "module_id", nullable = true)
	private Integer moduleId;
	
	@Column(name="dealer_master_id")
	Integer dealerMasterId;
	

	public Integer getDealerMasterId() {
		return dealerMasterId;
	}

	public void setDealerMasterId(Integer dealerMasterId) {
		this.dealerMasterId = dealerMasterId;
	}

	public Integer getStageId() {
		return stageId;
	}

	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}

	public String getWorkflowStagename() {
		return workflowStagename;
	}

	public void setWorkflowStagename(String workflowStagename) {
		this.workflowStagename = workflowStagename;
	}

	public Integer getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Integer getRejectedBy() {
		return rejectedBy;
	}

	public void setRejectedBy(Integer rejectedBy) {
		this.rejectedBy = rejectedBy;
	}

	public Date getRejectedDate() {
		return rejectedDate;
	}

	public void setRejectedDate(Date rejectedDate) {
		this.rejectedDate = rejectedDate;
	}

	public Integer getWorkflowStageNo() {
		return workflowStageNo;
	}

	public void setWorkflowStageNo(Integer workflowStageNo) {
		this.workflowStageNo = workflowStageNo;
	}

	public String getCreatedByRolename() {
		return createdByRolename;
	}

	public void setCreatedByRolename(String createdByRolename) {
		this.createdByRolename = createdByRolename;
	}

	public String getCreatedByUsername() {
		return createdByUsername;
	}

	public void setCreatedByUsername(String createdByUsername) {
		this.createdByUsername = createdByUsername;
	}

	public String getUpdatedByRolename() {
		return updatedByRolename;
	}

	public void setUpdatedByRolename(String updatedByRolename) {
		this.updatedByRolename = updatedByRolename;
	}

	public String getUpdatedByUsername() {
		return updatedByUsername;
	}

	public void setUpdatedByUsername(String updatedByUsername) {
		this.updatedByUsername = updatedByUsername;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	
	
	
}
