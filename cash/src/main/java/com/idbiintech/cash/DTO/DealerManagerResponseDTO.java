package com.idbiintech.cash.DTO;

import java.util.ArrayList;
import java.util.List;

public class DealerManagerResponseDTO {

	private List<DealerManagerDTO> dealermanagerDTOList = new ArrayList<>();

	private ResponseUIVO responseUIVO;

	private List<PermissionRequestDTO> permissionDTOList = new ArrayList<>();

	public List<DealerManagerDTO> getDealermanagerDTOList() {
		return dealermanagerDTOList;
	}

	public void setDealermanagerDTOList(List<DealerManagerDTO> dealermanagerDTOList) {
		this.dealermanagerDTOList = dealermanagerDTOList;
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
