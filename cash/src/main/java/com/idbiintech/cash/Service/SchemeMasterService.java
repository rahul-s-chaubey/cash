package com.idbiintech.cash.Service;

import java.util.List;

import com.idbiintech.cash.DTO.SchemeDTO;

public interface SchemeMasterService {
	
	public List<SchemeDTO> getschemedata(String casteName, String incomeBracket);

}
