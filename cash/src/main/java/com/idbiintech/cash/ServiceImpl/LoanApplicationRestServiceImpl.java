package com.idbiintech.cash.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.DTO.LoanApplicationDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.Entity.CustomerMaster;
import com.idbiintech.cash.Entity.LoanDetails;
import com.idbiintech.cash.Repository.CustomerMasterRepository;
import com.idbiintech.cash.Repository.LoanDetailsRepository;
import com.idbiintech.cash.Service.LoanApplicationRestService;

@Service
public class LoanApplicationRestServiceImpl implements LoanApplicationRestService {
	
	
	@Autowired
	CustomerMasterRepository CustomerMasterRepository;
	
	
	@Autowired
	LoanDetailsRepository LoanDetailsRepository;

	@Override
	public ResponseUIVO savedata(LoanApplicationDTO loanapplication) {
		
	
		
		ResponseUIVO responseUIVO=null;
		
		try {
			
			responseUIVO=new ResponseUIVO();
			
			CustomerMaster customermaster = new CustomerMaster();
			customermaster.setAddress(loanapplication.getAddress());
			customermaster.setCity(loanapplication.getCity());
			customermaster.setFirstName(loanapplication.getFirstName());
			customermaster.setMiddleName(loanapplication.getMiddleName());
			customermaster.setLastName(loanapplication.getLastName());
			customermaster.setGender(loanapplication.getGender());
		//	customermaster.setPincode(loanapplication.getPincode());
			customermaster.setState(loanapplication.getState());
			
			CustomerMasterRepository.save(customermaster);
			
			
			LoanDetails loandet = new LoanDetails();
//			loandet.setLoanAmount(loanapplication.getLoanAmount());
			loandet.setLoanCategory(loanapplication.getLoanCategory());
//			loandet.setLoanDuration(loanapplication.getLoanDuration());
//			loandet.setLoanInterest(loanapplication.getLoanInterest());
//			loandet.setLoanproposalDate(loanapplication.getLoanproposalDate());
			loandet.setLoanPurpose(loanapplication.getLoanPurpose());
			
			LoanDetailsRepository.save(loandet);
			
			loandet.getLoanmstId();
			
			responseUIVO.setMessage("Data Added Succesfully");
			responseUIVO.setStatus(201);
			responseUIVO.setApplicationId(loandet.getLoanmstId());
			
			return responseUIVO;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			responseUIVO=new ResponseUIVO();
			responseUIVO.setStatus(400);
			responseUIVO.setMessage("Error Occured in DB Server");
			return responseUIVO;
		}
		
		

	}

}
