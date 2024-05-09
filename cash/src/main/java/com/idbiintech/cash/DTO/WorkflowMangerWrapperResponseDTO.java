package com.idbiintech.cash.DTO;

import java.util.ArrayList;
import java.util.List;

public class WorkflowMangerWrapperResponseDTO {

	

	private List<WorkflowManagerResponseDTO> list=new ArrayList<>();
	
	private ResponseUIVO responseUIVO;

	private List<PermissionRequestDTO> permissionlist=new ArrayList<>();

	public List<WorkflowManagerResponseDTO> getList() {
		return list;
	}

	public void setList(List<WorkflowManagerResponseDTO> list) {
		this.list = list;
	}

	public ResponseUIVO getResponseUIVO() {
		return responseUIVO;
	}

	public void setResponseUIVO(ResponseUIVO responseUIVO) {
		this.responseUIVO = responseUIVO;
	}

	public List<PermissionRequestDTO> getPermissionlist() {
		return permissionlist;
	}

	public void setPermissionlist(List<PermissionRequestDTO> permissionlist) {
		this.permissionlist = permissionlist;
	}
	
	
}
