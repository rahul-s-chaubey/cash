package com.idbiintech.cash.Service;

import com.idbiintech.cash.DTO.EmployeeDetailsDTO;

public interface WorkflowProcessRestService {
	
	public Integer createupdateWorkflowProcess(EmployeeDetailsDTO employeeDetailsDTO,Integer moduleId,Integer applicationId, String Status, String requestType);

}
