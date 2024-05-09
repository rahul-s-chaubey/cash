package com.idbiintech.cash.DTO;

import java.util.ArrayList;
import java.util.List;

public class ModuleManagerResponseDTO {
	
	private List<ModulesDTO> moduleDTOList=new ArrayList<>();
	
	private ResponseUIVO responseUIVO;

	public List<ModulesDTO> getModuleDTOList() {
		return moduleDTOList;
	}

	public void setModuleDTOList(List<ModulesDTO> moduleDTOList) {
		this.moduleDTOList = moduleDTOList;
	}

	public ResponseUIVO getResponseUIVO() {
		return responseUIVO;
	}

	public void setResponseUIVO(ResponseUIVO responseUIVO) {
		this.responseUIVO = responseUIVO;
	}

	

}
