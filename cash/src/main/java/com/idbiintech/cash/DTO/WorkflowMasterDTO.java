package com.idbiintech.cash.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ankita
 *
 */
public class WorkflowMasterDTO {
	
	private Integer workflowmstId;
	private String workflowName;
	private Long workflowId;
	private String customerName;
	 private Integer customerId; 
	private Integer moduleId;
	private Integer roleId;
	private String roleName;
	private String status;
	List<StagesDTO> stages = new ArrayList<StagesDTO>();
	public Integer getWorkflowmstId() {
		return workflowmstId;
	}
	public void setWorkflowmstId(Integer workflowmstId) {
		this.workflowmstId = workflowmstId;
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public Long getWorkflowId() {
		return workflowId;
	}
	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<StagesDTO> getStages() {
		return stages;
	}
	public void setStages(List<StagesDTO> stages) {
		this.stages = stages;
	}
	
	
	

}
