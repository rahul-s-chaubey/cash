package com.idbiintech.cash.DTO;

public class RequestDTO {

	private Integer customerId;
	private Integer roleId;
	private Integer userId;
	private Integer projectId;
	private String userName;
	private String roleName;
	private String moduleUIVO;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getModuleUIVO() {
		return moduleUIVO;
	}
	public void setModuleUIVO(String moduleUIVO) {
		this.moduleUIVO = moduleUIVO;
	}
	
	
}
