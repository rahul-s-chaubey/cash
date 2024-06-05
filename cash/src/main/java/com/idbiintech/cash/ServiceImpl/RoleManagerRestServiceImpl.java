package com.idbiintech.cash.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.DTO.ModuleRequestDTO;
import com.idbiintech.cash.DTO.PermissionRequestDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.DTO.RoleManagerDTO;
import com.idbiintech.cash.DTO.RoleManagerResponseWrapperDTO;
import com.idbiintech.cash.DTO.RoleModuleDTO;
import com.idbiintech.cash.Entity.RoleMaster;
import com.idbiintech.cash.Entity.RolesModuleMaster;
import com.idbiintech.cash.Repository.RoleMasterRepository;
import com.idbiintech.cash.Repository.RoleModuleMasterRepository;
import com.idbiintech.cash.Service.RoleManagerRestService;

@Service
public class RoleManagerRestServiceImpl implements RoleManagerRestService {

	@Autowired
	RoleMasterRepository RoleMasterRepository;

	@Autowired
	RoleModuleMasterRepository RoleModuleMasterRepository;

	@Override 
	public ResponseUIVO createrole(RoleManagerDTO roleManager) {
	  
	  ResponseUIVO responseUIVO = null;
	  RoleMaster rolesMaster = null;
	  RoleManagerDTO rolesMasterVO = new RoleManagerDTO();
	  RoleModuleDTO RolesModuleMasterVO = new RoleModuleDTO();
	  ResponseUIVO uiVO=new ResponseUIVO();
	  
	  try {
	  
	  
		  	rolesMaster = new RoleMaster();
		  	rolesMaster.setIsActive(1);
		  	rolesMaster.setCreatedByRoleName(roleManager.getRoleName());
		  	rolesMaster.setCreatedByUserName(roleManager.getCreatedByUserName());
		  	rolesMaster.setCreatedDate(new Date());
		  	rolesMaster.setRoleName(roleManager.getRoleName());
		  	rolesMaster.setCustomerId(roleManager.getCustomerId());
		  	
		  	
		  	RoleMasterRepository.save(rolesMaster);
		  	

	  // code for ROlesModule 
		  	for (RoleModuleDTO moduleRequestVO :  roleManager.getRolesModuleMasterVOlist()){
		  		
		  		
			  RolesModuleMaster rolesModuleMaster = new RolesModuleMaster();
			  //rolesModuleMaster.setCustomerId(customerId);
			  rolesModuleMaster.setRoleId(Long.valueOf(rolesMaster.getRoleId()));
			  rolesModuleMaster.setModuleId(moduleRequestVO.getModuleId());
			  rolesModuleMaster.setDbVersion(0); 
			  //rolesModuleMaster.setProjectId(projectId);
			  rolesModuleMaster.setAdd(moduleRequestVO.getAdd());
			  rolesModuleMaster.setEdit(moduleRequestVO.getEdit());
			  rolesModuleMaster.setDeleted(moduleRequestVO.getDeleted());
			  rolesModuleMaster.setView(moduleRequestVO.getView());
			  rolesModuleMaster.setChecker(moduleRequestVO.getChecker());
			  rolesModuleMaster.setImports(moduleRequestVO.getImports());
			  rolesModuleMaster.setExport(moduleRequestVO.getExport());
			  rolesModuleMaster.setModuleName(moduleRequestVO.getModuleName());
			  
			  RoleModuleMasterRepository.save(rolesModuleMaster); }
	  
			  responseUIVO = new ResponseUIVO();
			  responseUIVO.setMessage("User Added Succesfully");
			  responseUIVO.setStatus(201);
	  
			  } catch (Exception e) {
				  responseUIVO = new ResponseUIVO(); 
				  responseUIVO.setStatus(400);
			  responseUIVO.setMessage("Error Occured in DB Server"); }
			  
			  return responseUIVO;
			  
	  
	  }

	
	  @Override
	  public RoleManagerResponseWrapperDTO getallrolelist(Integer roleId) {
	  
	  RoleManagerDTO rolesMasterVO = null; 
	  Integer moduleId = 2;
	  RoleManagerResponseWrapperDTO roleMasterResponseVO = new RoleManagerResponseWrapperDTO();
	  List<RoleManagerDTO> roleMangerUIVOList = new ArrayList<RoleManagerDTO>();
	  
	  List<RoleMaster> roleMasterList = RoleMasterRepository.getRoleList();	  
	  
	  for (RoleMaster rolesMaster : roleMasterList) { 
		  rolesMasterVO = new RoleManagerDTO();
		  BeanUtils.copyProperties(rolesMaster, rolesMasterVO);
		  roleMangerUIVOList.add(rolesMasterVO);
		  }
	  	  roleMasterResponseVO.setRolesMasterList(roleMangerUIVOList); 
	  	  
	  	  
			/* permission */ 
	  	  
	  	  
	  	  PermissionRequestDTO permissions = null; 
	//	  RoleManagerResponseWrapperDTO roleMasterResponseVO = new RoleManagerResponseWrapperDTO();
		  List<PermissionRequestDTO> permissionlist = new ArrayList<PermissionRequestDTO>();
		  
		  List<RolesModuleMaster> permissionList = RoleModuleMasterRepository.getPermissionList(roleId,moduleId);
		  
		  for (RolesModuleMaster rolesmoduleMaster : permissionList) { 
			  permissions = new PermissionRequestDTO();
			  BeanUtils.copyProperties(rolesmoduleMaster, permissions);
			  permissionlist.add(permissions);
			  }
		  	  roleMasterResponseVO.setPermissionList(permissionlist); 
		 
		  	  return roleMasterResponseVO;
		  
		  }

	  	  
	  	  



	
	  @Override
	  public RoleManagerDTO getroleById(Integer roleId) {
	  
		
		  		RoleManagerDTO rolesMasterVO = null;
				
				List<RolesModuleMaster> rolesModuleMasterlist = new ArrayList<RolesModuleMaster>();
				ResponseUIVO responseUIVO = null;
				
				RoleModuleDTO rolesModuleMasterVO = null;
				
				List<RoleModuleDTO> rolesModuleMasterVOlist = new ArrayList<RoleModuleDTO>();
				
				try {
					RoleMaster roleMaster = new RoleMaster();
					
					roleMaster = RoleMasterRepository.findByRoleId(roleId);

					rolesModuleMasterlist = RoleModuleMasterRepository.getRoleModuleList(roleId);
					
					
					rolesMasterVO = new RoleManagerDTO();
					
					rolesMasterVO.setRoleId(roleMaster.getRoleId());
					rolesMasterVO.setRoleName(roleMaster.getRoleName());
					rolesMasterVO.setIsActive(roleMaster.getIsActive());
					rolesMasterVO.setStatus(roleMaster.getStatus());
					rolesMasterVO.setCreatedByRoleName(roleMaster.getCreatedByRoleName());
					rolesMasterVO.setCreatedByUserName(rolesMasterVO.getCreatedByUserName());
					rolesMasterVO.setCustomerId(roleMaster.getCustomerId());
					
					for (RolesModuleMaster rolesModuleMaster : rolesModuleMasterlist) {
						rolesModuleMasterVO = new RoleModuleDTO();
						rolesModuleMasterVO.setRoleId(rolesModuleMaster.getRoleId());
						rolesModuleMasterVO.setModuleId(rolesModuleMaster.getModuleId());
						rolesModuleMasterVO.setAdd(rolesModuleMaster.getAdd());
						rolesModuleMasterVO.setEdit(rolesModuleMaster.getEdit());
						rolesModuleMasterVO.setView(rolesModuleMaster.getView());
						rolesModuleMasterVO.setChecker(rolesModuleMaster.getChecker());
						rolesModuleMasterVO.setDeleted(rolesModuleMaster.getDeleted());
						rolesModuleMasterVO.setModuleName(rolesModuleMaster.getModuleName());
						rolesModuleMasterVO.setImports(rolesModuleMaster.getImports());
						rolesModuleMasterVO.setExport(rolesModuleMaster.getExport());

						rolesModuleMasterVOlist.add(rolesModuleMasterVO);
					}
					rolesMasterVO.setRolesModuleMasterVOlist(rolesModuleMasterVOlist);
					responseUIVO = new ResponseUIVO();
					
					responseUIVO.setMessage("success");
					responseUIVO.setData(null);
				
					rolesMasterVO.setResponseUIVO(responseUIVO);

				} catch (Exception e) {
					
					responseUIVO.setMessage("error");
					responseUIVO.setData(null);
				
					rolesMasterVO.setResponseUIVO(responseUIVO);
				}
				return rolesMasterVO;
			

		  
	  
	  }


	@Override
	public ResponseUIVO deleteuser(Integer roleId) {
		
		
		ResponseUIVO responseUIVO=null;

		
		
		try {
			
			responseUIVO=new ResponseUIVO();
			
			RoleMaster rolemaster = new RoleMaster();
			
			rolemaster = RoleMasterRepository.findByRoleId(roleId);
			
			rolemaster.setIsActive(0);
			
			RoleMasterRepository.save(rolemaster);
			 
			
			
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
	public ResponseUIVO updaterole(RoleManagerDTO roleManager, Integer roleId) {
		
		
		
		List<RolesModuleMaster> rolesModuleMasterlist = new ArrayList<RolesModuleMaster>();
		
		List<RoleModuleDTO> rolesModuleMasterlistVO = new ArrayList<RoleModuleDTO>();
		
		List<ModuleRequestDTO> modules = new ArrayList<ModuleRequestDTO>();
		
		
		ResponseUIVO responseUIVO = null;

		try {
			RoleMaster rolesMaster = new RoleMaster();
			
			rolesMaster =   RoleMasterRepository.findByRoleId(roleId);
			
			
//			rolesMaster.setStatus(DatabaseManagerCommon.REQUEST_TYPE_EDIT);
//			rolesMaster.setIsActive(DatabaseManagerCommon.IS_ACTIVE);
			rolesMaster.setUpdatedDate(new Date());
			rolesMaster.setCreatedBy(null);
			rolesMaster.setCreatedByRoleName("admin");
			rolesMaster.setCreatedByUserName("shivam");
			rolesMaster.setDbVersion(1);
			rolesMaster.setRoleName(rolesMaster.getRoleName());
//			rolesMaster.setProjectId(projectId);
//			
//			rolesMaster.setCustomerId(customerId);

			RoleMasterRepository.save(rolesMaster);

			rolesModuleMasterlist = RoleModuleMasterRepository.getRoleModuleList(roleId);
			
			rolesModuleMasterlistVO = roleManager.getRolesModuleMasterVOlist();
			
			
			modules = roleManager.getModules();

			int i = 0;
			for (RoleModuleDTO m : rolesModuleMasterlistVO) {
				i++;
				int j = 0;
				// new
				for (RolesModuleMaster rolesModuleMaster : rolesModuleMasterlist) {
					j++;
					if (i == j) {
						rolesModuleMaster.setAdd(m.getAdd());
						rolesModuleMaster.setEdit(m.getEdit());
						rolesModuleMaster.setView(m.getView());
						rolesModuleMaster.setDeleted(m.getDeleted());
						rolesModuleMaster.setChecker(m.getChecker());
						rolesModuleMaster.setImports(m.getImports());
						rolesModuleMaster.setExport(m.getExport());
//						rolesModuleMaster.setCustomerId(customerId);
//						rolesModuleMaster.setProjectId(projectId);
						rolesModuleMaster.setDbVersion(1);
						rolesModuleMaster.setUpdatedDate(new Date());

						RoleModuleMasterRepository.save(rolesModuleMaster);
					}
				}
			}
			responseUIVO = new ResponseUIVO();
//			responseUIVO.setCustomerId(customerId);
//			responseUIVO.setProjectId(projectId);
			responseUIVO.setMessage("Sucess");
			responseUIVO.setData(null);
//			responseUIVO.setStatus(StatusCodeCommon.ROLE_UPDATE_SUCCESSFUL_CD);

		} catch (Exception e) {
			responseUIVO = new ResponseUIVO();
//			responseUIVO.setCustomerId(customerId);
//			responseUIVO.setProjectId(projectId);
			responseUIVO.setMessage("error");
			responseUIVO.setData(null);
//			responseUIVO.setStatus(StatusCodeCommon.ROLE_UPDATE_FAILED_CD);
		}
		return responseUIVO;
	}


	@Override
	public RoleManagerResponseWrapperDTO getpermission(Integer roleId) {
		
		  PermissionRequestDTO permissions = null; 
		  RoleManagerResponseWrapperDTO roleMasterResponseVO = new RoleManagerResponseWrapperDTO();
		  List<PermissionRequestDTO> roleMangerUIVOList = new ArrayList<PermissionRequestDTO>();
		  
		  Integer moduleId = 0;
		List<RolesModuleMaster> permissionList = RoleModuleMasterRepository.getPermissionList(roleId,moduleId );
		  
		  for (RolesModuleMaster rolesmoduleMaster : permissionList) { 
			  permissions = new PermissionRequestDTO();
			  BeanUtils.copyProperties(rolesmoduleMaster, permissions);
			  roleMangerUIVOList.add(permissions);
			  }
		  	  roleMasterResponseVO.setPermissionList(roleMangerUIVOList); 
		 
		  	  return roleMasterResponseVO;
		  
		  }


	@Override
	public RoleManagerResponseWrapperDTO getallroles() {
		
		
		 RoleManagerDTO rolesMasterVO = null; 
		  Integer moduleId = 0;
		  RoleManagerResponseWrapperDTO roleMasterResponseVO = new RoleManagerResponseWrapperDTO();
		  List<RoleManagerDTO> roleMangerUIVOList = new ArrayList<RoleManagerDTO>();
		  
		  List<RoleMaster> roleMasterList = RoleMasterRepository.findAll();
		  
		  
		  for (RoleMaster rolesMaster : roleMasterList) { 
			  rolesMasterVO = new RoleManagerDTO();
			  BeanUtils.copyProperties(rolesMaster, rolesMasterVO);
			  roleMangerUIVOList.add(rolesMasterVO);
			  }
		  	  roleMasterResponseVO.setRolesMasterList(roleMangerUIVOList); 

			 
			  	  return roleMasterResponseVO;
			  
			  }

	
	
	 

}
