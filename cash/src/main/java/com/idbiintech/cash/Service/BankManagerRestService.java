package com.idbiintech.cash.Service;

import com.idbiintech.cash.DTO.BankManagerDTO;
import com.idbiintech.cash.DTO.BankManagerResponseDTO;
import com.idbiintech.cash.DTO.BankManagerResponseWrapperDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;

public interface BankManagerRestService {

	public ResponseUIVO createbank(BankManagerDTO bankManager);

	public BankManagerResponseWrapperDTO getbankById(Integer bankMasterId);
	
	public BankManagerResponseDTO getallbank(Integer roleId);
	
	public BankManagerResponseWrapperDTO getbankBybankname(String bankName);
	
	public ResponseUIVO deletebank(Integer bankMasterId);
	
	public ResponseUIVO updatebank(BankManagerResponseWrapperDTO bankmanager);
	
}
