package com.idbiintech.cash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idbiintech.cash.DTO.EmployeeDetailsDTO;
import com.idbiintech.cash.DTO.LoanApplicationDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.Service.LoanApplicationRestService;
import com.idbiintech.cash.ServiceImpl.WorkflowProcessServiceImpl;

import jakarta.websocket.server.PathParam;

@CrossOrigin
@RestController
public class LoanApplicationController {
	
	@Autowired
	LoanApplicationRestService LoanApplicationRestService;
	
	@Autowired
	WorkflowProcessServiceImpl workflowprocessrestservice;
	
	
	@PostMapping("/savedata")
	public ResponseEntity<ResponseUIVO> savedata(@RequestBody String request, EmployeeDetailsDTO employeeDetailsDTO
			 ) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseUIVO responseUIVO=null;
		
		try {
			LoanApplicationDTO loanapplication = new LoanApplicationDTO();

			loanapplication = objectMapper.readValue(request, LoanApplicationDTO.class);
			
			responseUIVO = LoanApplicationRestService.savedata(loanapplication) ;
			
			Long application = responseUIVO.getApplicationId();
			
			int applicationId = application.intValue();  
			
			String Status = "pending";
			
			Integer moduleId = 1;
			
			String requestType = "created";
			
			workflowprocessrestservice.createupdateWorkflowProcess(employeeDetailsDTO, moduleId, applicationId, Status, requestType);
			
			


		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
		
	}
	

}
