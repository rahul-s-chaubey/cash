package com.idbiintech.cash.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDetailsDTO implements Serializable
{
	
/*
 *  roleId
 *  roleName
 *  dealerId
 *  
 * 
 * 
 * */
	
	
	
	
	
	
	
	
	
	private static final long serialVersionUID = -1615561016728131916L;
	
	private Integer employeeId;
	private Integer roleId;
	private String roleName; //maker or checker
	private Date updatedDate;
	private Map<String, List<ModulesDTO>> navigationMap = new HashMap<String,List<ModulesDTO>>();// nav bar
	private ControlDTO controlDTO ; // on page level
	private String status;
	private String userName;	
	private Integer dealerMasterId;
	private Integer customerType;
	private Integer customerId;
	private List<Integer> moduleIds = new ArrayList<Integer>();
	
	
	public Integer getDealerMasterId() {
		return dealerMasterId;
	}
	public void setDealerMasterId(Integer dealerMasterId) {
		this.dealerMasterId = dealerMasterId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Map<String, List<ModulesDTO>> getNavigationMap() {
		return navigationMap;
	}
	public void setNavigationMap(Map<String, List<ModulesDTO>> navigationMap) {
		this.navigationMap = navigationMap;
	}
	public ControlDTO getControlDTO() {
		return controlDTO;
	}
	public void setControlDTO(ControlDTO controlDTO) {
		this.controlDTO = controlDTO;
	}
	
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCustomerType() {
		return customerType;
	}
	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public List<Integer> getModuleIds() {
		return moduleIds;
	}
	public void setModuleIds(List<Integer> moduleIds) {
		this.moduleIds = moduleIds;
	}

	
}
