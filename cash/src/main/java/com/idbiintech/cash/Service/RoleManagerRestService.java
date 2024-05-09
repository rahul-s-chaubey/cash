package com.idbiintech.cash.Service;

import com.idbiintech.cash.DTO.PermissionRequestDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.DTO.RoleManagerDTO;
import com.idbiintech.cash.DTO.RoleManagerResponseWrapperDTO;

public interface RoleManagerRestService {

	public ResponseUIVO createrole(RoleManagerDTO roleManager);
	
	public RoleManagerResponseWrapperDTO getallrolelist(Integer roleId);

	public RoleManagerDTO getroleById(Integer roleId);

	public ResponseUIVO deleteuser(Integer roleId);
	
	public ResponseUIVO updaterole(RoleManagerDTO roleManager, Integer roleId);
	
	public RoleManagerResponseWrapperDTO getpermission(Integer roleId);
	
}
