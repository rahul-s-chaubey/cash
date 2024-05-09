package com.idbiintech.cash.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleManagerDTO {

	private Integer roleId;

	private String roleName;

	private Integer isActive;

	private String createdBy;

	private Date createdDate;

	private String updatedBy;

	private Date updatedDate;

	private String status;

	private String createdByRoleName;

	private String createdByUserName;

	private String updatedByRoleName;

	private String updatedByUserName;

	private Integer customerId;

	private ResponseUIVO responseUIVO;
	
	List<ModuleRequestDTO> modules = new ArrayList<ModuleRequestDTO>();

	public List<ModuleRequestDTO> getModules() {
		return modules;
	}

	public void setModules(List<ModuleRequestDTO> modules) {
		this.modules = modules;
	}

	List<RoleModuleDTO> rolesModuleMasterVOlist = new ArrayList<RoleModuleDTO>();

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

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedByRoleName() {
		return createdByRoleName;
	}

	public void setCreatedByRoleName(String createdByRoleName) {
		this.createdByRoleName = createdByRoleName;
	}

	public String getCreatedByUserName() {
		return createdByUserName;
	}

	public void setCreatedByUserName(String createdByUserName) {
		this.createdByUserName = createdByUserName;
	}

	public String getUpdatedByRoleName() {
		return updatedByRoleName;
	}

	public void setUpdatedByRoleName(String updatedByRoleName) {
		this.updatedByRoleName = updatedByRoleName;
	}

	public String getUpdatedByUserName() {
		return updatedByUserName;
	}

	public void setUpdatedByUserName(String updatedByUserName) {
		this.updatedByUserName = updatedByUserName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public ResponseUIVO getResponseUIVO() {
		return responseUIVO;
	}

	public void setResponseUIVO(ResponseUIVO responseUIVO) {
		this.responseUIVO = responseUIVO;
	}

	public List<RoleModuleDTO> getRolesModuleMasterVOlist() {
		return rolesModuleMasterVOlist;
	}

	public void setRolesModuleMasterVOlist(List<RoleModuleDTO> rolesModuleMasterVOlist) {
		this.rolesModuleMasterVOlist = rolesModuleMasterVOlist;
	}
	
	
	

}
