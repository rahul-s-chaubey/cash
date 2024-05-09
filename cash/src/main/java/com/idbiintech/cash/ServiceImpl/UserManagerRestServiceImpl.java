package com.idbiintech.cash.ServiceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.DTO.PermissionRequestDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.DTO.UserManagerDTO;
import com.idbiintech.cash.DTO.UserManagerResponseDTO;
import com.idbiintech.cash.DTO.UserManagerResponseWrapperDTO;
import com.idbiintech.cash.Entity.BankMaster;
import com.idbiintech.cash.Entity.RolesModuleMaster;
import com.idbiintech.cash.Entity.UserMaster;
import com.idbiintech.cash.Repository.RoleModuleMasterRepository;
import com.idbiintech.cash.Repository.UserMasterRepository;
import com.idbiintech.cash.Service.UserManagerRestService;

@Service
public class UserManagerRestServiceImpl implements UserManagerRestService {
	
	@Autowired
	UserMasterRepository UserMasterRepository;
	
	@Autowired
	RoleModuleMasterRepository RoleModuleMasterRepository;


	@Override
	public ResponseUIVO createuser(UserManagerDTO userManager) {
		
	
		ResponseUIVO responseUIVO=null;
		
		
		
		try {
			
//			 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
//			 Date date;
//				date = formatter.parse(userManager.getBirthDate());
//			
			 
			 String s= userManager.getGender();  
			 char gender =s.charAt(0);
			 
			
			responseUIVO=new ResponseUIVO();
			
			UserMaster usermaster = new UserMaster();
			
			usermaster.setAddress(userManager.getAddress());
			usermaster.setAltAddress(userManager.getAltAddress());
			usermaster.setAltMobileNumber(userManager.getAltMobileNumber());
//			usermaster.setBirthDate(date);
			usermaster.setCustomerId(userManager.getCustomerId());
			usermaster.setEmail(userManager.getEmail());
			usermaster.setFirstName(userManager.getFirstName());
			usermaster.setMiddleName(userManager.getMiddleName());
			usermaster.setLastName(userManager.getLastName());
			usermaster.setGender(gender);
			usermaster.setIsActive(1);
			usermaster.setMobileNumber(userManager.getMobileNumber());
			usermaster.setPassword(userManager.getPassword());
			usermaster.setUserName(userManager.getUserName());
			  
			UserMasterRepository.save(usermaster);
			 
			
			
			responseUIVO.setMessage("User Added Succesfully");
			responseUIVO.setStatus(201);
			
			return responseUIVO;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			responseUIVO=new ResponseUIVO();
			responseUIVO.setStatus(400);
			responseUIVO.setMessage("Error Occured in DB Server");
			return responseUIVO;
		}
		
		

	}

	@Override
	public UserManagerResponseDTO getallbank(Integer roleId) {
	
		UserManagerDTO usermanagerDTO = null;
		UserManagerResponseDTO usermanagerresponseDTO =new UserManagerResponseDTO();
		List<UserManagerDTO> list =new ArrayList<>();

		try {

			List<UserMaster> userMasterList = new ArrayList<>();
			userMasterList = UserMasterRepository.getUserList();
			
			
			
			for (UserMaster userMaster : userMasterList) {
				usermanagerDTO = new UserManagerDTO();
				BeanUtils.copyProperties(userMaster, usermanagerDTO);
				list.add(usermanagerDTO);
			}
			usermanagerresponseDTO.setUsermanagerDTOList(list);

			
			
			/* permission */ 
		  	  
		  	  
		  	  PermissionRequestDTO permissions = null; 
		//	  RoleManagerResponseWrapperDTO roleMasterResponseVO = new RoleManagerResponseWrapperDTO();
			  List<PermissionRequestDTO> permissionlist = new ArrayList<PermissionRequestDTO>();
			  
			  Integer moduleId = 5;
			List<RolesModuleMaster> permissionList = RoleModuleMasterRepository.getPermissionList(roleId,moduleId);
			  
			  for (RolesModuleMaster rolesmoduleMaster : permissionList) { 
				  permissions = new PermissionRequestDTO();
				  BeanUtils.copyProperties(rolesmoduleMaster, permissions);
				  permissionlist.add(permissions);
				  }
			  		usermanagerresponseDTO.setPermissionDTOList(permissionlist);
			 
			
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return usermanagerresponseDTO;
	}

	
	
	@Override
	public UserManagerResponseWrapperDTO getbankById(Integer userId) {
		
		UserManagerResponseWrapperDTO userManagerResponseWrapperDTO = null;

		try {
			
			List<UserMaster> userMaster = null;
			userMaster = UserMasterRepository.getUserById(userId);
			
			
			
			for (UserMaster usermaster : userMaster) {
				userManagerResponseWrapperDTO = new UserManagerResponseWrapperDTO();
				BeanUtils.copyProperties(usermaster,userManagerResponseWrapperDTO);
			}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}


        return userManagerResponseWrapperDTO;
        

	}

	@Override
	public ResponseUIVO deleteuser(Integer userId) {
		
		ResponseUIVO responseUIVO=null;

		
		
		try {
			
			responseUIVO=new ResponseUIVO();
			
			UserMaster usermaster = new UserMaster();
			
			usermaster = UserMasterRepository.findByUserId(userId);
			
			usermaster.setIsActive(0);
			
			UserMasterRepository.save(usermaster);
			 
			
			
			responseUIVO.setMessage("Bank Delete Succesfully");
			responseUIVO.setStatus(201);
			
			return responseUIVO;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			responseUIVO=new ResponseUIVO();
			responseUIVO.setStatus(400);
			responseUIVO.setMessage("Error Occured in DB Server");
			return responseUIVO;
		}
		

	}

	@Override
	public ResponseUIVO updateuser(UserManagerResponseWrapperDTO usermanager) {
	
		ResponseUIVO responseUIVO=null;
	
		
		try {
			
			responseUIVO=new ResponseUIVO();
			
			UserMaster usermaster = new UserMaster();
			
			
			usermaster = UserMasterRepository.findByUserId(usermanager.getUserId());
			usermaster.setAddress(usermanager.getAddress());
			usermaster.setAltAddress(usermanager.getAltAddress());
			usermaster.setAltMobileNumber(usermanager.getAltMobileNumber());
			usermaster.setEmail(usermanager.getEmail());
			usermaster.setFirstName(usermanager.getFirstName());
			usermaster.setLastName(usermanager.getLastName());
			usermaster.setMiddleName(usermanager.getMiddleName());
			usermaster.setMobileNumber(usermanager.getMobileNumber());
			usermaster.setPassword(usermanager.getPassword());
			
			UserMasterRepository.save(usermaster);

			
			responseUIVO.setMessage("User Updated Succesfully");
			responseUIVO.setStatus(201);
			
			return responseUIVO;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			responseUIVO=new ResponseUIVO();
			responseUIVO.setStatus(400);
			responseUIVO.setMessage("Error Occured in DB Server");
			return responseUIVO;
		}
		
		
	}

}
