package com.idbiintech.cash.DTO;

import java.util.ArrayList;
import java.util.List;

public class BankManagerResponseDTO {
	
	private List<BankManagerDTO> bankmanagerDTOList=new ArrayList<>();
	
	private ResponseUIVO responseUIVO;

	private List<PermissionRequestDTO> permissionDTOList=new ArrayList<>();

	public List<BankManagerDTO> getBankmanagerDTOList() {
		return bankmanagerDTOList;
	}

	public void setBankmanagerDTOList(List<BankManagerDTO> bankmanagerDTOList) {
		this.bankmanagerDTOList = bankmanagerDTOList;
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
