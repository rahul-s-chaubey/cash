package com.idbiintech.cash.Service;

import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.DTO.UserManagerDTO;
import com.idbiintech.cash.DTO.UserManagerResponseDTO;
import com.idbiintech.cash.DTO.UserManagerResponseWrapperDTO;

public interface UserManagerRestService {

	public ResponseUIVO createuser(UserManagerDTO userManager);
	
	public UserManagerResponseDTO getallbank(Integer roleId);
	
	public UserManagerResponseWrapperDTO getbankById(Integer userId);

	public ResponseUIVO deleteuser(Integer userId);
	
	public ResponseUIVO updateuser(UserManagerResponseWrapperDTO usermanager);
	
}
