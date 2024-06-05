package com.idbiintech.cash.DTO;

import java.util.ArrayList;
import java.util.List;

public class SchemeMasterResponseDTO {

	
	private List<SchemeDTO> schemeDTOList = new ArrayList<>();
	
	private ResponseUIVO responseUIVO;

	public List<SchemeDTO> getSchemeDTOList() {
		return schemeDTOList;
	}

	public void setSchemeDTOList(List<SchemeDTO> schemeDTOList) {
		this.schemeDTOList = schemeDTOList;
	}

	public ResponseUIVO getResponseUIVO() {
		return responseUIVO;
	}

	public void setResponseUIVO(ResponseUIVO responseUIVO) {
		this.responseUIVO = responseUIVO;
	}

	
	
	
	
}
