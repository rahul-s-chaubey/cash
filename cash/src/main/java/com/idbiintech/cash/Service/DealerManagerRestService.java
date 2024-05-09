package com.idbiintech.cash.Service;

import com.idbiintech.cash.DTO.DealerManagerDTO;
import com.idbiintech.cash.DTO.DealerManagerResponseDTO;
import com.idbiintech.cash.DTO.DealerManagerResponseWrapperDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;

public interface DealerManagerRestService {

	
	public ResponseUIVO createdealer(DealerManagerDTO bankManager);

	public DealerManagerResponseWrapperDTO getdealerById(Integer dealerMasterId);
	
	public DealerManagerResponseDTO getalldealer(Integer roleId);
	
	public DealerManagerResponseWrapperDTO getbankdealername(String name);
	
	public ResponseUIVO deletedealer(Integer bankMasterId);
	
	public ResponseUIVO updatedealer(DealerManagerResponseWrapperDTO dealermanager);
}
