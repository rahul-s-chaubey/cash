package com.idbiintech.cash.DTO;

import java.util.ArrayList;
import java.util.List;

public class ApprovalDTO {

	private List<CustomerMasterDTO> customermasterdto = new ArrayList<>();

	private List<LoanDetailDTO> loandetdto = new ArrayList<>();

	public List<CustomerMasterDTO> getCustomermasterdto() {
		return customermasterdto;
	}

	public void setCustomermasterdto(List<CustomerMasterDTO> customermasterdto) {
		this.customermasterdto = customermasterdto;
	}

	public List<LoanDetailDTO> getLoandetdto() {
		return loandetdto;
	}

	public void setLoandetdto(List<LoanDetailDTO> loandetdto) {
		this.loandetdto = loandetdto;
	}
	
	
	
	

}
