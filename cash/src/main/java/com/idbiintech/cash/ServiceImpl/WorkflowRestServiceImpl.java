package com.idbiintech.cash.ServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.DTO.PermissionRequestDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.DTO.WorkflowManagerRequestDTO;
import com.idbiintech.cash.DTO.WorkflowManagerResponseDTO;
import com.idbiintech.cash.DTO.WorkflowMangerWrapperResponseDTO;
import com.idbiintech.cash.Entity.RolesModuleMaster;
import com.idbiintech.cash.Entity.WorkflowDetails;
import com.idbiintech.cash.Entity.WorkflowMaster;
import com.idbiintech.cash.Repository.RoleModuleMasterRepository;
import com.idbiintech.cash.Repository.WorkflowDetailRepository;
import com.idbiintech.cash.Repository.WorkflowMasterRepository;
import com.idbiintech.cash.Service.WorkflowRestService;


@Service
public class WorkflowRestServiceImpl implements WorkflowRestService {
	
	
	@Autowired
	WorkflowMasterRepository workflowMasterRepository;
	
	@Autowired
	WorkflowDetailRepository workflowDetailRepository;
	
	@Autowired
	RoleModuleMasterRepository RoleModuleMasterRepository;
	

	@Override
	public WorkflowMangerWrapperResponseDTO getallworkflow(Integer roleId) {
		
		WorkflowMangerWrapperResponseDTO workFlowManagerWrapperResponseUIVO =null;
		WorkflowManagerResponseDTO workFlowManagerResponseUIVO=null;
		List<WorkflowManagerResponseDTO> workFlowManagerResponseUIVOList=null;
		
		
		try {
		workFlowManagerResponseUIVOList=new ArrayList<>();
		List<WorkflowMaster> list=new ArrayList<>();
		workFlowManagerWrapperResponseUIVO =new WorkflowMangerWrapperResponseDTO();
		
		list= workflowMasterRepository.findAll();
		
		for(WorkflowMaster workflowMaster:list)
			
		{   
			
			workFlowManagerResponseUIVO=new WorkflowManagerResponseDTO();
			BeanUtils.copyProperties(workflowMaster, workFlowManagerResponseUIVO);
			workFlowManagerResponseUIVOList.add(workFlowManagerResponseUIVO);
		}
		
		workFlowManagerWrapperResponseUIVO.setList(workFlowManagerResponseUIVOList);
		ResponseUIVO  responseUIVO=new ResponseUIVO();
		responseUIVO.setStatus(200);
		responseUIVO.setMessage("All Data Fetched Successfully");
		workFlowManagerWrapperResponseUIVO.setResponseUIVO(responseUIVO);
		
		
		/* permission */ 
	  	  
	  	  
	  	  PermissionRequestDTO permissions = null; 
	//	  RoleManagerResponseWrapperDTO roleMasterResponseVO = new RoleManagerResponseWrapperDTO();
		  List<PermissionRequestDTO> permissionlist = new ArrayList<PermissionRequestDTO>();
		  
		  Integer moduleId = 6;
		List<RolesModuleMaster> permissionList = RoleModuleMasterRepository.getPermissionList(roleId,moduleId );
		  
		  for (RolesModuleMaster rolesmoduleMaster : permissionList) { 
			  permissions = new PermissionRequestDTO();
			  BeanUtils.copyProperties(rolesmoduleMaster, permissions);
			  permissionlist.add(permissions);
			  }
		  workFlowManagerWrapperResponseUIVO.setPermissionlist(permissionlist);
		 
	
		
	}
		catch (Exception e) {
			e.printStackTrace();
			ResponseUIVO  responseUIVO=new ResponseUIVO();
			responseUIVO.setStatus(500);
			responseUIVO.setMessage("Server Error");
			workFlowManagerWrapperResponseUIVO.setResponseUIVO(responseUIVO);
			
			
		}
		return workFlowManagerWrapperResponseUIVO;
	
	
	

	}

	
	
	@Override
	public ResponseUIVO createWorkflow(WorkflowManagerRequestDTO[] workflowManagerRequestUIVO) {


//	    ResponseUIVO responseUIVO=new ResponseUIVO();
//	    WorkflowMaster workflowMaster=new WorkflowMaster();
//	    
//	    BeanUtils.copyProperties(workflowManagerRequestUIVO, workflowMaster);
//	    workflowMaster.setCreatedDate(new Date());
//	    workflowMaster.setProjectId(1);
//	    workflowMaster.setCreatedByRolename("rolename");
//	    workflowMasterRepository.save(workflowMaster);
//	    
//	   
//	    responseUIVO.setData("Data Inserted Successfully");
//	    responseUIVO.setMessage(null);
//	    responseUIVO.setStatus(201);
//	
//	    return responseUIVO;
		
		
		
		 Boolean isSaved=false;
	      WorkflowMaster workflowMaster =null;
	      
	      WorkflowDetails workflowDetails=null;
	      ResponseUIVO responseUIVO = null;
	      
	     for(WorkflowManagerRequestDTO workflowManagerRequestUIVOObj: workflowManagerRequestUIVO) {
	    	
	    	  {
	    	 workflowMaster =new WorkflowMaster();
	    	 workflowMaster.setWorkflowName(workflowManagerRequestUIVOObj.getWorkflowName());
	    	 workflowMaster.setWorkflowId(workflowManagerRequestUIVOObj.getWorkflowId());
	    	 workflowMaster.setCustomerName(workflowManagerRequestUIVOObj.getCustomerName());
	    //	 workflowMaster.setCustomerId(Integer.valueOf(workflowManagerRequestUIVOObj.getCustomerId()));
	    	 workflowMaster.setModuleId(Integer.valueOf(workflowManagerRequestUIVOObj.getModuleId()));
	    	// workflowMaster.setCreatedByUsername(requestUIVO.getUserName());
	    	// workflowMaster.setCreatedByRolename(requestUIVO.getRoleName());
	    	 workflowMaster.setCreatedDate(new Date());		    	
	    	 workflowMaster.setIsActive(1); 
	    	// workflowMaster.setProjectId(requestUIVO.getProjectId());
	    	 workflowMaster.setStatus("Created");
	    	 
	    	 workflowMaster= workflowMasterRepository.save(workflowMaster);
	    	 
	    	 
	    	 isSaved=true;
	    	 
	    	   responseUIVO=new ResponseUIVO();
		      responseUIVO.setData("Data Updated Successfully in workflowmaster");
		      responseUIVO.setStatus(200);
	    	 
	    	 
	    	  }
	    	
	    	
	    	 try {
	    		 
	    	 workflowDetails=new WorkflowDetails();
	    	 
	    	 workflowDetails.setWorkflowId(workflowMaster.getWorkflowId());
//	    	 workflowDetails.setWorkflowStageName(workflowManagerRequestUIVOObj.getStageName());
	    	 workflowDetails.setWorkflowStageNo(workflowManagerRequestUIVOObj.getStageNumber());
	    	 LocalDate currentDate = LocalDate.now();
//	    	 workflowDetails.setCreatedDate(currentDate);
	    	 workflowDetails.setIsActive(1);
	    	 workflowDetails.setModuleId(Integer.valueOf(workflowManagerRequestUIVOObj.getModuleId()));
//	    	 workflowDetails.setCustomerId(requestUIVO.getCustomerId());
//	    	 workflowDetails.setRoleId(requestUIVO.getRoleId());
//	    	 workflowDetails.setUserId(requestUIVO.getUserId());
//	    	 workflowDetails.setUserName(requestUIVO.getUserName());
//	    	 workflowDetails.setRoleName(requestUIVO.getRoleName());
//	    	 workflowDetails.setProjectId(requestUIVO.getProjectId());
	    	 
	    	 workflowDetailRepository.save(workflowDetails);
	    	 
	    	 

	    	   responseUIVO=new ResponseUIVO();
		      responseUIVO.setData("Data Updated Successfully in workflowdetails");
		      responseUIVO.setStatus(200);
	    	 
	    	 
	    	 
	    	 }
	    	 catch (Exception e) {
				e.printStackTrace();

		    	   responseUIVO=new ResponseUIVO();
			      responseUIVO.setData("Data Not Saved");
			      responseUIVO.setStatus(400);
		    	 
			}
	     }
	   
		return responseUIVO;

	}    



	@Override
	public List<WorkflowDetails> getWorkflowById(Integer workflowId) {
		
		List<WorkflowDetails> workflowDetails= new ArrayList();
		
		workflowDetails= workflowDetailRepository.findByWorkflowId(workflowId);
		
        return workflowDetails;
		
		
		

	}



	@Override
	public WorkflowManagerResponseDTO deleteWorkflowById(Integer workflowId) {
		
		
		WorkflowMaster workflowMaster = new WorkflowMaster();
		
		workflowMaster = workflowMasterRepository.findByWorkflowId(workflowId);
		workflowMaster.setIsActive(0);
		workflowMasterRepository.save(workflowMaster);
		
		
		WorkflowManagerResponseDTO workFlowManagerResponseUIVO = new WorkflowManagerResponseDTO();
		
		ResponseUIVO responseUIVO = new ResponseUIVO();
	//	responseUIVO.setCustomerId(customerId);
	//	responseUIVO.setProjectId(projectId);
		responseUIVO.setStatus(200);
		responseUIVO.setMessage("Workflow Deleted Sucessfully");
		workFlowManagerResponseUIVO.setResponseUIVO(responseUIVO);
		
		
		return workFlowManagerResponseUIVO;
		

	}

}
