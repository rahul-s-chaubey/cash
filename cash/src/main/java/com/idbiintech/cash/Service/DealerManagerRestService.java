package com.idbiintech.cash.Service;

import java.util.List;

import com.idbiintech.cash.DTO.DealerManagerDTO;
import com.idbiintech.cash.DTO.DealerManagerResponseDTO;
import com.idbiintech.cash.DTO.DealerManagerResponseWrapperDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.Entity.DealerMaster;

public interface DealerManagerRestService {

	
	public ResponseUIVO createdealer(DealerManagerDTO bankManager);

	public DealerManagerResponseWrapperDTO getdealerById(Integer dealerMasterId);
	
	public DealerManagerResponseDTO getalldealer(Integer roleId);
	
	public DealerManagerResponseWrapperDTO getbankdealername(String name);
	
	public List<DealerMaster> getDealerByUsertype(String usertype);
	
	public ResponseUIVO deletedealer(Integer bankMasterId);
	
	public ResponseUIVO updatedealer(DealerManagerResponseWrapperDTO dealermanager);
}
