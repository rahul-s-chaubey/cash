package com.idbiintech.cash.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WorkflowMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "workflow_id")
	private Integer workflowId;
	
	
	@Column(name = "workflow_mst_id" , nullable = true)
	private Integer workflowMasterId;
	
	@Column(name = "module_id" , nullable = true)
	private Integer moduleId;

	@Column(name = "customer_id" )
	private Integer customerId;
	
	@Column(name = "approved_by" , nullable = true)
	private Integer approvedBy;
	
	@Column(name = "approved_date" , nullable = true)
	private Date approvedDate;
	
	@Column(name = "rejected_by" , nullable = true)
	private Integer rejectedBy;
	
	@Column(name = "rejected_date" , nullable = true)
	private Date rejectedDate;
	
	@Column(name = "customer_name" , nullable = true)
	private String customerName;
	
	@Column(name = "created_by_rolename" , nullable = true)
	private String createdByRolename;
	
	@Column(name = "created_by_username" , nullable = true)
	private String createdByUsername;
	
	@Column(name = "updated_by_rolename" , nullable = true)
	private String updatedByRolename;
	
	@Column(name = "updated_by_username" , nullable = true)
	private String updatedByUsername;
	
	@Column(name = "workflow_name" , nullable = true)
	private String workflowName;
	
	@Column(name="created_by" , nullable = true)
	private String createdBy;
	
	@Column(name = "created_date" , nullable = true)
	private Date createdDate;
	
	@Column(name="updated_by" , nullable = true)
	private String updatedBy;
	
	@Column(name = "updated_date" , nullable = true)
	private Date updatedDate;
	
	@Column(name = "is_active", nullable = true)
	private Integer isActive; 
	
	@Column(name = "status", nullable = true)
	private String status;
	
	@Column(name="project_id")
	private Integer projectId;
	
	@Column(name="dealer_master_id")
	Integer dealerMasterId;
	
	@Column(name = "role_id")
	private Integer roleId;
	

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getDealerMasterId() {
		return dealerMasterId;
	}

	public void setDealerMasterId(Integer dealerMasterId) {
		this.dealerMasterId = dealerMasterId;
	}

	public Integer getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	public Integer getWorkflowMasterId() {
		return workflowMasterId;
	}

	public void setWorkflowMasterId(Integer workflowMasterId) {
		this.workflowMasterId = workflowMasterId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	
	

}
