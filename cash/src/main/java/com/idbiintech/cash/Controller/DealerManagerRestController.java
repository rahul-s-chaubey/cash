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
import com.idbiintech.cash.DTO.DealerManagerDTO;
import com.idbiintech.cash.DTO.DealerManagerResponseDTO;
import com.idbiintech.cash.DTO.DealerManagerResponseWrapperDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.Service.DealerManagerRestService;

@CrossOrigin
@RestController
public class DealerManagerRestController {

	@Autowired
	DealerManagerRestService dealermanagerrestservice;
	
	//Create new dealer 
	@PostMapping("/savedealer")
	public ResponseEntity<ResponseUIVO> createdealer(@RequestBody String request) {
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseUIVO responseUIVO=null;
		
		
		try {
			DealerManagerDTO dealermanager = new DealerManagerDTO();

			dealermanager = objectMapper.readValue(request, DealerManagerDTO.class);
			responseUIVO = dealermanagerrestservice.createdealer(dealermanager);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
		

	}
	
	
	
	//Get All Dealer List 
	@GetMapping("/getalldealerlist/{role_id}")
	public ResponseEntity<DealerManagerResponseDTO> getallbanks(@PathVariable("role_id") Integer roleId) {
		
		DealerManagerResponseDTO dealermanagerresponseDTO = new DealerManagerResponseDTO();
		ResponseUIVO responseUIVO=null;
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	
		try {

		  
			dealermanagerresponseDTO = dealermanagerrestservice.getalldealer(roleId);
		
			status = HttpStatus.OK;
		ResponseUIVO responseUVIO = new ResponseUIVO();
		responseUVIO.setMessage("All data fetched successfully");
		responseUVIO.setStatus(200);
		dealermanagerresponseDTO.setResponseUIVO(responseUVIO);
	}catch (Exception ex) {
		ex.printStackTrace();
		ResponseUIVO responseUVIO = new ResponseUIVO();
		responseUVIO.setMessage("All data fetched successfully");
		responseUVIO.setStatus(200);
		dealermanagerresponseDTO.setResponseUIVO(responseUVIO);
		
	}

	
		return ResponseEntity.status(status).body(dealermanagerresponseDTO);

	}
	
	
	// Get Dealer ById
		@GetMapping(value = "/getdealerById/{dealer_master_id}")
		public ResponseEntity<DealerManagerResponseWrapperDTO> getDealerById(@PathVariable("dealer_master_id") Integer dealerMasterId) {
			
			DealerManagerResponseWrapperDTO dealerManagerResponseDTO = new DealerManagerResponseWrapperDTO();
			
			
			try {
				dealerManagerResponseDTO = dealermanagerrestservice.getdealerById(dealerMasterId) ;
						
						
				ResponseUIVO responseUVIO = new ResponseUIVO();

				responseUVIO.setMessage("Data fetched successfully");
				responseUVIO.setStatus(200);
				dealerManagerResponseDTO.setResponseUIVO(responseUVIO);
				return new ResponseEntity<>(dealerManagerResponseDTO, HttpStatus.OK);
			}

			catch (Exception e) {
				e.printStackTrace();
				ResponseUIVO responseUVIO = new ResponseUIVO();
				responseUVIO.setMessage("Something Went Wrong");
				responseUVIO.setStatus(500);
				dealerManagerResponseDTO.setResponseUIVO(responseUVIO);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dealerManagerResponseDTO);
			}
			
		}
		
		
		// Get Dealer Byname
				@GetMapping(value = "/getdealerByName/{name}")
				public ResponseEntity<DealerManagerResponseWrapperDTO> getDealerByName(@PathVariable("name") String name) {
					
					DealerManagerResponseWrapperDTO dealerManagerResponseDTO = new DealerManagerResponseWrapperDTO();
					
					
					try {
						dealerManagerResponseDTO = dealermanagerrestservice.getbankdealername(name);
								
								
						ResponseUIVO responseUVIO = new ResponseUIVO();

						responseUVIO.setMessage("Data fetched successfully");
						responseUVIO.setStatus(200);
						dealerManagerResponseDTO.setResponseUIVO(responseUVIO);
						return new ResponseEntity<>(dealerManagerResponseDTO, HttpStatus.OK);
					}

					catch (Exception e) {
						e.printStackTrace();
						ResponseUIVO responseUVIO = new ResponseUIVO();
						responseUVIO.setMessage("Something Went Wrong");
						responseUVIO.setStatus(500);
						dealerManagerResponseDTO.setResponseUIVO(responseUVIO);
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dealerManagerResponseDTO);
					}
					
				}
		
				
				// update dealer 
				@PutMapping("/updatedealer")
				public ResponseEntity<ResponseUIVO> updatedealer(@RequestBody String request) {
					ObjectMapper objectMapper = new ObjectMapper();
					ResponseUIVO responseUIVO=null;
					
					
					try {
						DealerManagerResponseWrapperDTO dealermanager = new DealerManagerResponseWrapperDTO();

						dealermanager = objectMapper.readValue(request, DealerManagerResponseWrapperDTO.class);
						
						responseUIVO = dealermanagerrestservice.updatedealer(dealermanager);


					} catch (Exception e) {
						e.printStackTrace();
					}
					return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
					

				}
	
				
				// delete dealer 
				@GetMapping(value = "/deletedealer/{dealer_master_id}")
				public ResponseEntity<ResponseUIVO> deletedealerById(@PathVariable("dealer_master_id") Integer dealerMasterId) {
					
					ResponseUIVO responseUIVO=null;
					
					try {
						
						responseUIVO = dealermanagerrestservice.deletedealer(dealerMasterId);


					} catch (Exception e) {
						e.printStackTrace();
					}
					return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
				}
				
				
						
				
	
}
