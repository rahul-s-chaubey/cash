package com.idbiintech.cash.DTO;

import java.util.ArrayList;
import java.util.List;

public class StatusDTO {

	
	private List<WorkflowProcessDTO> workflowprocessdto = new ArrayList<>();
	
	private List<LoanDetailDTO> loandetdto = new ArrayList<>();

	public List<WorkflowProcessDTO> getWorkflowprocessdto() {
		return workflowprocessdto;
	}

	public void setWorkflowprocessdto(List<WorkflowProcessDTO> workflowprocessdto) {
		this.workflowprocessdto = workflowprocessdto;
	}

	public List<LoanDetailDTO> getLoandetdto() {
		return loandetdto;
	}

	public void setLoandetdto(List<LoanDetailDTO> loandetdto) {
		this.loandetdto = loandetdto;
	}
	
	
	
	
}
