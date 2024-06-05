package com.idbiintech.cash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idbiintech.cash.DTO.ApprovalDTO;
import com.idbiintech.cash.DTO.LoanApplicationDTO;
import com.idbiintech.cash.DTO.StatusDTO;
import com.idbiintech.cash.Service.StatusService;
import com.idbiintech.cash.Service.WorkflowProcessRestService;

@CrossOrigin
@RestController
public class StatusController {

	 
	@Autowired
	StatusService StatusService;
	
	@Autowired
	WorkflowProcessRestService workflowprocessrestservice;
	
	@GetMapping("/getallworkflow/{role_id}/{dealer_master_id}")
	public StatusDTO getallstatus(@PathVariable("role_id") Integer roleId, @PathVariable("dealer_master_id") Integer dealerMasterId) {
		
		String status = "PENDING";
		
		StatusDTO listofworkflow = StatusService.listofworkflow(roleId, dealerMasterId, status);
		
		return listofworkflow;
		
	}
	
	
	@GetMapping("/getbyloanid/{LOAN_MST_ID}")
	public ApprovalDTO getworkflowbyloanid(@PathVariable("LOAN_MST_ID") Integer loanmstId) {
		
		
		ApprovalDTO loanid = StatusService.getByLoanmastId(loanmstId);
		
		return loanid;
		
	}
	
	
	@PostMapping("/approveorreject/{status}/{loanmstId}")
	public String approveorreject(@RequestBody String request, @PathVariable("status") String Status,  @PathVariable("loanmstId") Integer loanmstId ) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
	try {
		LoanApplicationDTO loanapplication = new LoanApplicationDTO();

		loanapplication = objectMapper.readValue(request, LoanApplicationDTO.class);
		
		
		Integer moduleId = 1;
		
		String requestType = "created";
				
		Integer applicationId = loanmstId;
		System.out.println(applicationId);
		
		
		workflowprocessrestservice.createupdateWorkflowProcess(loanapplication,moduleId , applicationId, Status, requestType );


	}catch (Exception e) {
		e.printStackTrace();
		

	}
		
		
	return "Sucess";
	}
	
	
}
