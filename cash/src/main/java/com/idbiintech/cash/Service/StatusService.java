package com.idbiintech.cash.Service;

import com.idbiintech.cash.DTO.ApprovalDTO;
import com.idbiintech.cash.DTO.StatusDTO;
import com.idbiintech.cash.Entity.LoanDetails;

public interface StatusService {

	public StatusDTO listofworkflow(Integer roleid, Integer dealerMasterId, String status);
	
	public ApprovalDTO getByLoanmastId(Integer loanmstId);
	
	
}
