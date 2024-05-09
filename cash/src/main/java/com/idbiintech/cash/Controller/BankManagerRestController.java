package com.idbiintech.cash.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idbiintech.cash.DTO.BankManagerDTO;
import com.idbiintech.cash.DTO.BankManagerResponseDTO;
import com.idbiintech.cash.DTO.BankManagerResponseWrapperDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.Service.BankManagerRestService;

@CrossOrigin
@RestController
public class BankManagerRestController {

	@Autowired
	BankManagerRestService bankmanagerrestservice;
	
	//Create new bank 
	@PostMapping("/savebank")
	public ResponseEntity<ResponseUIVO> createbank(@RequestBody String request) {
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseUIVO responseUIVO=null;
		
		
		try {
			BankManagerDTO bankmanager = new BankManagerDTO();

			bankmanager = objectMapper.readValue(request, BankManagerDTO.class);
			
			responseUIVO = bankmanagerrestservice.createbank(bankmanager);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
		

	}
	
	
	
	// Get Bank ById
	@GetMapping(value = "/getById/{bank_master_id}")
	public ResponseEntity<BankManagerResponseWrapperDTO> getbankById(@PathVariable("bank_master_id") Integer bankMasterId) {
		
		BankManagerResponseWrapperDTO bankManagerResponseDTO = new BankManagerResponseWrapperDTO();
		
		
		try {
			bankManagerResponseDTO = bankmanagerrestservice.getbankById(bankMasterId);
					
					
			ResponseUIVO responseUVIO = new ResponseUIVO();

			responseUVIO.setMessage("Data fetched successfully");
			responseUVIO.setStatus(200);
			bankManagerResponseDTO.setResponseUIVO(responseUVIO);
			return new ResponseEntity<>(bankManagerResponseDTO, HttpStatus.OK);
		}

		catch (Exception e) {
			e.printStackTrace();
			ResponseUIVO responseUVIO = new ResponseUIVO();
			responseUVIO.setMessage("Something Went Wrong");
			responseUVIO.setStatus(500);
			bankManagerResponseDTO.setResponseUIVO(responseUVIO);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bankManagerResponseDTO);
		}
		
	}
	
	
	
	//Get All Bank List 
	@GetMapping("/getallbanklist/{role_id}")
	public ResponseEntity<BankManagerResponseDTO> getallbanks(@PathVariable("role_id") Integer roleId) {
		
		BankManagerResponseDTO bankmanagerresponseDTO = new BankManagerResponseDTO();
		ResponseUIVO responseUIVO=null;
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	
		try {

		
			bankmanagerresponseDTO = bankmanagerrestservice.getallbank(roleId);
		
			status = HttpStatus.OK;
		ResponseUIVO responseUVIO = new ResponseUIVO();
		responseUVIO.setMessage("All data fetched successfully");
		responseUVIO.setStatus(200);
		bankmanagerresponseDTO.setResponseUIVO(responseUVIO);
	}catch (Exception ex) {
		ex.printStackTrace();
		ResponseUIVO responseUVIO = new ResponseUIVO();
		responseUVIO.setMessage("All data fetched successfully");
		responseUVIO.setStatus(200);
		bankmanagerresponseDTO.setResponseUIVO(responseUVIO);
		
	}

	
		return ResponseEntity.status(status).body(bankmanagerresponseDTO);

	}
	
	
	
	// Get Bank Bybankname
		@GetMapping(value = "/getBybankname/{bank_name}")
		public ResponseEntity<BankManagerResponseWrapperDTO> getbankBybankname(@PathVariable("bank_name") String bankName) {
			
			BankManagerResponseWrapperDTO bankManagerResponseDTO = new BankManagerResponseWrapperDTO();
			
			
			try {
				bankManagerResponseDTO = bankmanagerrestservice.getbankBybankname(bankName);
						
						
				ResponseUIVO responseUVIO = new ResponseUIVO();

				responseUVIO.setMessage("Data fetched successfully");
				responseUVIO.setStatus(200);
				bankManagerResponseDTO.setResponseUIVO(responseUVIO);
				return new ResponseEntity<>(bankManagerResponseDTO, HttpStatus.OK);
			}

			catch (Exception e) {
				e.printStackTrace();
				ResponseUIVO responseUVIO = new ResponseUIVO();
				responseUVIO.setMessage("Something Went Wrong");
				responseUVIO.setStatus(500);
				bankManagerResponseDTO.setResponseUIVO(responseUVIO);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(bankManagerResponseDTO);
			}
			
		}
		
	
		
		// delete bank 
				@GetMapping(value = "/deletebank/{bank_master_id}")
				public ResponseEntity<ResponseUIVO> deletebankById(@PathVariable("bank_master_id") Integer bankMasterId) {
					
					ResponseUIVO responseUIVO=null;
					
					try {
						
						responseUIVO = bankmanagerrestservice.deletebank(bankMasterId);


					} catch (Exception e) {
						e.printStackTrace();
					}
					return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
				}
				
				
				
				
				
		// update bank 
				@PutMapping("/updatebank")
				public ResponseEntity<ResponseUIVO> updatebank(@RequestBody String request) {
					ObjectMapper objectMapper = new ObjectMapper();
					ResponseUIVO responseUIVO=null;
					
					
					try {
						BankManagerResponseWrapperDTO bankmanager = new BankManagerResponseWrapperDTO();

						bankmanager = objectMapper.readValue(request, BankManagerResponseWrapperDTO.class);
						
						responseUIVO = bankmanagerrestservice.updatebank(bankmanager);


					} catch (Exception e) {
						e.printStackTrace();
					}
					return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
					

				}
	
}
