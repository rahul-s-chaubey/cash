package com.idbiintech.cash.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.Commons.PlethoraConstants;
import com.idbiintech.cash.DTO.EmployeeDetailsDTO;
import com.idbiintech.cash.Entity.WorkflowDetails;
import com.idbiintech.cash.Entity.WorkflowProcess;
import com.idbiintech.cash.Repository.RoleMasterRepository;
import com.idbiintech.cash.Repository.WorkflowDetailRepository;
import com.idbiintech.cash.Repository.WorkflowProcessRepository;
import com.idbiintech.cash.Service.CommonService;
import com.idbiintech.cash.Service.WorkflowProcessRestService;

@Service
public class WorkflowProcessServiceImpl implements WorkflowProcessRestService {

	
	@Autowired private	CommonService commonService;
	@Autowired private WorkflowProcessRepository workflowProcessRepository;
	@Autowired private WorkflowDetailRepository workflowDetailRepository;
	@Autowired private RoleMasterRepository roleRepository;
	
	@Override
	public Integer createupdateWorkflowProcess(EmployeeDetailsDTO employeeDetailsDTO, Integer moduleId,
			Integer applicationId, String Status, String requestType) {

		try {
			Integer stagesCompleted = 0;
			Integer definedStages = 0;
			 WorkflowProcess workflowProcess;
			 List<WorkflowProcess> workflowProcessList;
			//check for the workflow
			Boolean isWorkflowPresent = commonService.isWorkFlowPresent(moduleId, employeeDetailsDTO.getDealerMasterId());
			
			if(isWorkflowPresent)
			{
				List<WorkflowDetails> stageList = workflowDetailRepository.getStagesByModuleId(moduleId);
				workflowProcessList = workflowProcessRepository.getJobRecordsById(applicationId,moduleId);
				definedStages = workflowProcessList.size();
				if(null == workflowProcessList || workflowProcessList.isEmpty())
				{
					workflowProcess = new WorkflowProcess();
					workflowProcess.setApplicationId(applicationId);
					workflowProcess.setDealerMasterId(employeeDetailsDTO.getDealerMasterId());
					workflowProcess.setJobStatus(PlethoraConstants.PENDING);
					workflowProcess.setModuleId(moduleId);
					workflowProcess.setMakerId(employeeDetailsDTO.getRoleId());
					workflowProcess.setAssignedTo(stageList.get(stagesCompleted).getRoleId());
					String roleName = roleRepository.findByRoleId(stageList.get(stagesCompleted).getRoleId()).getRoleName();
					workflowProcess.setJobLabel(PlethoraConstants.PENDING + " with "+ roleName);
					workflowProcess.setRequestType(requestType);
					workflowProcessRepository.save(workflowProcess);
				}
				else 
				{
					stagesCompleted = workflowProcessList.size();
					workflowProcessList = workflowProcessRepository.getJobRecordsById(applicationId,moduleId);
					workflowProcess = workflowProcessList.get(workflowProcessList.size()-1);
					workflowProcess.setJobStatus(Status);
					workflowProcessRepository.save(workflowProcess);
					definedStages = workflowProcessList.size();
					if(Status.equalsIgnoreCase("APPROVED") && stagesCompleted <= definedStages)
					{
						workflowProcess = new WorkflowProcess();
						workflowProcess.setApplicationId(applicationId);
						workflowProcess.setDealerMasterId(employeeDetailsDTO.getDealerMasterId());
						if( stagesCompleted == definedStages)
							workflowProcess.setJobStatus("SENT_TO_BANK");
						else workflowProcess.setJobStatus(Status);
						workflowProcess.setModuleId(moduleId);
						workflowProcess.setMakerId(employeeDetailsDTO.getRoleId());
						workflowProcess.setAssignedTo(stageList.get(stagesCompleted).getRoleId());
						String roleName = roleRepository.findByRoleId(stageList.get(stagesCompleted).getRoleId()).getRoleName();
						workflowProcess.setJobLabel(PlethoraConstants.PENDING + " with "+ roleName);
						workflowProcess.setRequestType(requestType);
						workflowProcessRepository.save(workflowProcess);
					}
				}
				
			}
			else 
			{
				
			}

		} catch (Exception ex) {

		}
		return null;
	}

}
