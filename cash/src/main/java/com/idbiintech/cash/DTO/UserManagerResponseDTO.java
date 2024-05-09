package com.idbiintech.cash.DTO;

import java.util.ArrayList;
import java.util.List;

public class UserManagerResponseDTO {

	
	private List<UserManagerDTO> usermanagerDTOList=new ArrayList<>();
	
	private ResponseUIVO responseUIVO;

	private List<PermissionRequestDTO> permissionDTOList=new ArrayList<>();

	public List<UserManagerDTO> getUsermanagerDTOList() {
		return usermanagerDTOList;
	}

	public void setUsermanagerDTOList(List<UserManagerDTO> usermanagerDTOList) {
		this.usermanagerDTOList = usermanagerDTOList;
	}

	public ResponseUIVO getResponseUIVO() {
		return responseUIVO;
	}

	public void setResponseUIVO(ResponseUIVO responseUIVO) {
		this.responseUIVO = responseUIVO;
	}

	public List<PermissionRequestDTO> getPermissionDTOList() {
		return permissionDTOList;
	}

	public void setPermissionDTOList(List<PermissionRequestDTO> permissionDTOList) {
		this.permissionDTOList = permissionDTOList;
	}

	
	
	
}
