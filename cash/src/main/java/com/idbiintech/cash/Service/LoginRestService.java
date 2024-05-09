package com.idbiintech.cash.Service;

import com.idbiintech.cash.DTO.LoginDetailDTO;

public interface LoginRestService {

	public LoginDetailDTO getLoggedInUserDetails(String emailId, String password);
}
