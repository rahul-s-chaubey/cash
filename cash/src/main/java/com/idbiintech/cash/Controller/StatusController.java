package com.idbiintech.cash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.idbiintech.cash.DTO.ApprovalDTO;
import com.idbiintech.cash.DTO.StatusDTO;
import com.idbiintech.cash.Entity.LoanDetails;
import com.idbiintech.cash.Service.StatusService;

@CrossOrigin
@RestController
public class StatusController {

	 
	@Autowired
	StatusService StatusService;
	
	@GetMapping("/getallworkflow/{role_id}/{dealer_master_id}")
	public StatusDTO getallstatus(@PathVariable("role_id") Integer roleId, @PathVariable("dealer_master_id") Integer dealerMasterId) {
		
		String status = "Pending";
		
		StatusDTO listofworkflow = StatusService.listofworkflow(roleId, dealerMasterId, status);
		
		return listofworkflow;
		
	}
	
	
	@GetMapping("/getbyloanid/{LOAN_MST_ID}")
	public ApprovalDTO getworkflowbyloanid(@PathVariable("LOAN_MST_ID") Integer loanmstId) {
		
		
		ApprovalDTO loanid = StatusService.getByLoanmastId(loanmstId);
		
		return loanid;
		
	}
	
	
	
}
