package com.idbiintech.cash.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.Commons.PlethoraConstants;
import com.idbiintech.cash.DTO.EmployeeDetailsDTO;
import com.idbiintech.cash.Entity.RolesModuleMaster;
import com.idbiintech.cash.Entity.WorkflowDetails;
import com.idbiintech.cash.Entity.WorkflowProcess;
import com.idbiintech.cash.Repository.RoleMasterRepository;
import com.idbiintech.cash.Repository.RoleModuleMasterRepository;
import com.idbiintech.cash.Repository.WorkflowDetailRepository;
import com.idbiintech.cash.Repository.WorkflowProcessRepository;
import com.idbiintech.cash.Service.CommonService;
import com.idbiintech.cash.Service.WorkflowProcessRestService;


@Service
public class WorkflowProcessRestServiceImpl  {
	
	@Autowired
	RoleModuleMasterRepository RoleModuleMasterRepository;
	
	@Autowired
	CommonService commonService;
	
	@Autowired
	WorkflowProcessRepository jobRepository;
	
	@Autowired
	RoleMasterRepository rolesRepository; 
	
	@Autowired
	WorkflowDetailRepository workflowDetailsRepository;


	public void createupdateWorkflowProcess(EmployeeDetailsDTO employeeDetailsDTO, Integer moduleId,
 		Integer applicationId, String Status, String requestType) {
//		
//		
//		WorkflowProcess jobEntity  = null;
//		Long roleId = null;
//		List<WorkflowProcess> jobList = new ArrayList<WorkflowProcess>();
//		try 
//		{
//			Boolean isWorkflowPresent = commonService.isWorkFlowPresent(moduleId, employeeDetailsDTO.getDealerMasterId());
//			if(!isWorkflowPresent)
//			{
//				//ROLESMODULE role = rolesModuleRepository.getRoleId(moduleId ) ;
//				List<RolesModuleMaster> rolesModuleList = RoleModuleMasterRepository.getRoleIds(moduleId.longValue(),employeeDetailsDTO.getDealerMasterId());
//				if(null == rolesModuleList || rolesModuleList.isEmpty())
//				{
//					roleId = 323L; //remove later
//				}	
//				else	
//				 	roleId = generateRoleId(rolesModuleList);
//				jobEntity = jobRepository.getJobRecordById(applicationId);
//				if(null == jobEntity)
//				{
//					jobEntity = new WorkflowProcess();
//					jobEntity.setApplicationId(applicationId);
//					jobEntity.setCustomerId(employeeDetailsDTO.getCustomerId());
//					jobEntity.setJobStatus(PlethoraConstants.PENDING);
//					jobEntity.setModuleId(moduleId);
//					jobEntity.setMakerId(employeeDetailsDTO.getRoleId());
//					jobEntity.setAssignedTo(roleId.intValue());
//					String roleName = rolesRepository.findByRoleId(employeeDetailsDTO.getRoleId().longValue()).getRoleName();
//					jobEntity.setJobLabel(PlethoraConstants.PENDING + " with "+ roleName);
//					jobEntity.setRequestType(requestType);
//					jobRepository.save(jobEntity);
//				//	updateMaster(employeeDetailsDTO, moduleId, applicationId, Status);
//				}
//				else 
//				{
//					jobEntity = jobRepository.getJobRecordsByModuleIdAndApplicationIdAndAssignedTo(applicationId, moduleId, employeeDetailsDTO.getRoleId());
//					jobEntity.setJobLabel(Status);
//					jobEntity.setJobStatus(Status + " By "+ employeeDetailsDTO.getRoleName());
//					jobRepository.save(jobEntity);
//					
//					
//					jobEntity = new WorkflowProcess();
//					jobEntity.setApplicationId(applicationId);
//					jobEntity.setCustomerId(employeeDetailsDTO.getCustomerId());
//					jobEntity.setJobStatus(Status);
//					jobEntity.setModuleId(moduleId);
//					jobEntity.setMakerId(employeeDetailsDTO.getRoleId());
//					jobEntity.setAssignedTo(roleId.intValue());
//					String roleName = rolesRepository.findByRoleId(roleId.longValue()).getRoleName();
//					jobEntity.setJobLabel(Status + " By "+employeeDetailsDTO.getRoleName());
//					jobRepository.save(jobEntity);
//					updateMaster(employeeDetailsDTO, moduleId, applicationId, Status,requestType);
//					
//				}
//			}
//			else 
//			{
//				jobList = jobRepository.getJobRecordsById(applicationId);
//				List<WorkflowDetails> workFlowDetailList = workflowDetailsRepository.getStagesByModuleId(moduleId);
//				Integer totalWorkflowStages = workFlowDetailList.size();
//				Integer stagesCompleted = 0;
//				
//				if(null == jobList || jobList.isEmpty())
//				{
//					jobEntity = new WorkflowProcess();
//					jobEntity.setApplicationId(applicationId);
//					jobEntity.setCustomerId(employeeDetailsDTO.getCustomerId());
//					jobEntity.setJobLabel(PlethoraConstants.PENDING);
//					jobEntity.setModuleId(moduleId);
//					jobEntity.setMakerId(employeeDetailsDTO.getRoleId());
//					jobEntity.setRequestType(requestType);
//					
//					WorkflowDetails  workflowDetails = workFlowDetailList.get(stagesCompleted);
//					jobEntity.setAssignedTo(workflowDetails.getRoleId());
//					String roleName = rolesRepository.getById(workflowDetails.getRoleId().longValue()).getROLENAME();
//					jobEntity.setJobStatus(PlethoraConstants.PENDING + " with "+ roleName);
//					jobRepository.save(jobEntity);
//					//updateMaster(employeeDetailsDTO, moduleId, applicationId, Status);
//				}
//				else 
//				{
//					stagesCompleted = jobList.size(); //2
//					//first Update the current stage
//					jobEntity = jobRepository.getJobRecordsByModuleIdAndApplicationIdAndAssignedTo(applicationId, moduleId, employeeDetailsDTO.getRoleId());
//					jobEntity.setJobLabel(Status);
//					jobEntity.setJobStatus(Status + " By "+ employeeDetailsDTO.getRoleName());
//					jobRepository.save(jobEntity);
//					
//					// then create a new row to assign it to a new role as per the workflow
//					
//						if(stagesCompleted == totalWorkflowStages)
//						{
//							updateMaster(employeeDetailsDTO, moduleId, applicationId, Status,requestType);
//						}
//						else 
//						{
//							stagesCompleted ++;
//							jobEntity.setMakerId(employeeDetailsDTO.getRoleId());
//							WorkflowDetails  workflowDetails = workflowDetailsRepository.getStagesByModuleId(moduleId).get(stagesCompleted-1);
//							jobEntity = new JOB();
//							jobEntity.setAssignedTo(workflowDetails.getRoleId());
//							jobEntity.setJobLabel(PlethoraConstants.PENDING);
//							String roleName = rolesRepository.getById(workflowDetails.getRoleId().longValue()).getROLENAME();
//							jobEntity.setJobStatus(PlethoraConstants.PENDING +" with "+roleName);
//							jobEntity.setModuleId(moduleId);
//							jobEntity.setApplicationId(applicationId);
//							jobEntity.setCustomerId(employeeDetailsDTO.getCustomerId());
//							jobRepository.save(jobEntity);
//							updateMaster(employeeDetailsDTO, moduleId, applicationId, Status,requestType);
//						}
//						
//				}
//			}
//		}		
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}
//		// TODO Auto-generated method stub
//		return jobEntity.getJobId();
//		
//		
//
//
}


	Long generateRoleId(List<RolesModuleMaster> rolesModuleList)
	{
		    Random random = new Random();
		    Integer index=  random.nextInt(rolesModuleList.size() - 0) + 0;
		    
		  return  rolesModuleList.get(index).getRoleId();
		    
	}
	

}
