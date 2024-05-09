package com.idbiintech.cash.DTO;

import java.util.ArrayList;
import java.util.List;

public class RoleManagerResponseWrapperDTO {

	
	private ResponseUIVO responseUIVO;
	private List<RoleManagerDTO> rolesMasterList = new ArrayList<RoleManagerDTO>();
	private List<PermissionRequestDTO> permissionList = new ArrayList<PermissionRequestDTO>();
	
	public ResponseUIVO getResponseUIVO() {
		return responseUIVO;
	}
	public void setResponseUIVO(ResponseUIVO responseUIVO) {
		this.responseUIVO = responseUIVO;
	}
	public List<RoleManagerDTO> getRolesMasterList() {
		return rolesMasterList;
	}
	public void setRolesMasterList(List<RoleManagerDTO> rolesMasterList) {
		this.rolesMasterList = rolesMasterList;
	}
	public List<PermissionRequestDTO> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<PermissionRequestDTO> permissionList) {
		this.permissionList = permissionList;
	}
	
	
	
}
