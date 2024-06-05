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
			
			
			LoanDetails loandet = new LoanDetails();
			loandet.setLoanAmount(Long.parseLong(loanapplication.getLoanAmount()));
			loandet.setLoanCategory(loanapplication.getLoanCategory());
			loandet.setLoanDuration(Long.parseLong(loanapplication.getLoanDuration()));
			loandet.setLoanInterest(Long.parseLong(loanapplication.getLoanInterest()));
//			loandet.setLoanproposalDate(loanapplication.getLoanproposalDate());
			loandet.setLoanPurpose(loanapplication.getLoanPurpose());
			loandet.setRoleId(loanapplication.getRoleId());
			loandet.setCarcolor(loanapplication.getCarcolor());
			loandet.setCarmake(loanapplication.getCarmake());
			loandet.setCarmodel(loanapplication.getCarmodel());
			loandet.setBorrowername(loanapplication.getBorrowername());
			loandet.setBorrroweemail(loanapplication.getBorroweremail());
			loandet.setStatus("pending");
			loandet.setDealerMasterId(loanapplication.getDealerMasterId());
			
			
			LoanDetailsRepository.save(loandet);
			
			loandet.getLoanmstId();
			
			
			CustomerMaster customermaster = new CustomerMaster();
			customermaster.setAddress(loanapplication.getAddress());
			customermaster.setCity(loanapplication.getCity());
			customermaster.setFirstName(loanapplication.getFirstName());
			customermaster.setMiddleName(loanapplication.getMiddleName());
			customermaster.setLastName(loanapplication.getLastName());
			customermaster.setGender(loanapplication.getGender());
			customermaster.setPincode(Long.parseLong(loanapplication.getPincode()));
			customermaster.setState(loanapplication.getState());
			customermaster.setLoanmstId(loandet.getLoanmstId());
			
			CustomerMasterRepository.save(customermaster);
			
			

			
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
