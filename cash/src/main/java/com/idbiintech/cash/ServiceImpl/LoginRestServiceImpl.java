package com.idbiintech.cash.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.DTO.LoginDetailDTO;
import com.idbiintech.cash.Entity.UserMaster;
import com.idbiintech.cash.Repository.UserMasterRepository;
import com.idbiintech.cash.Service.LoginRestService;

@Service
public class LoginRestServiceImpl implements LoginRestService{
	
	@Autowired
	UserMasterRepository userMasterRespository;

	@Override
	public LoginDetailDTO getLoggedInUserDetails(String emailId, String password) {
		
		LoginDetailDTO  loginDetailsUIVO = new LoginDetailDTO();
		
		UserMaster userMaster = null;
		try
		{
			userMaster = userMasterRespository.getUser(emailId, password);
			
			if(userMaster != null)
			{	
				String userName=null;
				userName=userMaster.getFirstName() +" "+ userMaster.getLastName();
				loginDetailsUIVO.setCustomerId(userMaster.getCustomerId());
				loginDetailsUIVO.setUserId(userMaster.getUserId());
				loginDetailsUIVO.setProjectId(userMaster.getProjectId());
				loginDetailsUIVO.setRoleId(userMaster.getRoleId());
				loginDetailsUIVO.setRoleId(userMaster.getRoleId());
				loginDetailsUIVO.setDealerMasterId(userMaster.getDealerMasterId());
				
			
				loginDetailsUIVO.setUserName(userName);
				//RolesModuleMaster rolesModule = rolesModuleDBRepository.get
			}
			
			else return new LoginDetailDTO() ;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return loginDetailsUIVO;
	}

}
