package com.idbiintech.cash.Service;

import java.util.LinkedHashMap;
import java.util.List;

import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.DTO.WorkflowManagerRequestDTO;
import com.idbiintech.cash.DTO.WorkflowManagerResponseDTO;
import com.idbiintech.cash.DTO.WorkflowMangerWrapperResponseDTO;
import com.idbiintech.cash.Entity.WorkflowDetails;

public interface WorkflowRestService {
	
	public WorkflowMangerWrapperResponseDTO getallworkflow(Integer roleId);
	
	ResponseUIVO createWorkflow(WorkflowManagerRequestDTO[] workflowManagerRequestUIVO);
	
	ResponseUIVO createWorkflow(List<WorkflowManagerRequestDTO> workflowManagerRequestDTOList);
	
	ResponseUIVO createWorkflowLinkedHashMap(List<LinkedHashMap<String, String>> workflowManagerRequestDTOList);
	
	List<WorkflowDetails> getWorkflowById(Integer workflowId);
	
	WorkflowManagerResponseDTO deleteWorkflowById(Integer workflowId);

	

}
