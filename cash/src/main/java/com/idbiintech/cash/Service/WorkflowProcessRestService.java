package com.idbiintech.cash.Service;

import com.idbiintech.cash.DTO.LoanApplicationDTO;

public interface WorkflowProcessRestService {
	
	//public Integer createupdateWorkflowProcess(EmployeeDetailsDTO employeeDetailsDTO,Integer moduleId,Integer applicationId, String Status, String requestType);

	public Integer createupdateWorkflowProcess(LoanApplicationDTO loanapplication, Integer moduleId, Integer applicationId,
			String Status, String requestType);

}
