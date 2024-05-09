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
import com.idbiintech.cash.DTO.BankManagerResponseWrapperDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.DTO.UserManagerDTO;
import com.idbiintech.cash.DTO.UserManagerResponseDTO;
import com.idbiintech.cash.DTO.UserManagerResponseWrapperDTO;
import com.idbiintech.cash.Service.UserManagerRestService;

@CrossOrigin
@RestController
public class UserManagerRestController {

	@Autowired
	UserManagerRestService userManagerRestService;
	
	
	//Create New User
	@PostMapping("/createuser")
	public  ResponseEntity<ResponseUIVO> createuser(@RequestBody String request) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseUIVO responseUIVO=null;
		
		
		try {
			UserManagerDTO usermanager = new UserManagerDTO();

			usermanager = objectMapper.readValue(request, UserManagerDTO.class);
			
			responseUIVO = userManagerRestService.createuser(usermanager);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	
	//Get All User List 
	@GetMapping("/getalluserlist/{role_id}")
	public ResponseEntity<UserManagerResponseDTO> getallusers(@PathVariable("role_id") Integer roleId){
		
		UserManagerResponseDTO usermanagerresponseDTO = new UserManagerResponseDTO();
		ResponseUIVO responseUIVO=null;
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	
		try {

		
			usermanagerresponseDTO =  userManagerRestService.getallbank(roleId);
		
			status = HttpStatus.OK;
		ResponseUIVO responseUVIO = new ResponseUIVO();
		responseUVIO.setMessage("All data fetched successfully");
		responseUVIO.setStatus(200);
		usermanagerresponseDTO.setResponseUIVO(responseUVIO);
	}catch (Exception ex) {
		ex.printStackTrace();
		ResponseUIVO responseUVIO = new ResponseUIVO();
		responseUVIO.setMessage("All data fetched successfully");
		responseUVIO.setStatus(200);
		usermanagerresponseDTO.setResponseUIVO(responseUVIO);
		
	}

	
		return ResponseEntity.status(status).body(usermanagerresponseDTO);

	}
	
	
	
	// Get User ById
		@GetMapping(value = "/getUserById/{user_id}")
		public ResponseEntity<UserManagerResponseWrapperDTO> getuserById(@PathVariable("user_id") Integer userId) {
			
			UserManagerResponseWrapperDTO userManagerResponseDTO = new UserManagerResponseWrapperDTO();
			
			
			try {
				userManagerResponseDTO = userManagerRestService.getbankById(userId) ;
						
						
				ResponseUIVO responseUVIO = new ResponseUIVO();

				responseUVIO.setMessage("Data fetched successfully");
				responseUVIO.setStatus(200);
				userManagerResponseDTO.setResponseUIVO(responseUVIO);
				return new ResponseEntity<>(userManagerResponseDTO, HttpStatus.OK);
			}

			catch (Exception e) {
				e.printStackTrace();
				ResponseUIVO responseUVIO = new ResponseUIVO();
				responseUVIO.setMessage("Something Went Wrong");
				responseUVIO.setStatus(500);
				userManagerResponseDTO.setResponseUIVO(responseUVIO);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userManagerResponseDTO);
			}
			
		}
		
		
	
		// delete user 
		@GetMapping(value = "/deleteuser/{user_id}")
		public ResponseEntity<ResponseUIVO> deleteuserById(@PathVariable("user_id") Integer userId) {
			
			ResponseUIVO responseUIVO=null;
			
			try {
				
				responseUIVO = userManagerRestService.deleteuser(userId);


			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
		}
		
	
		// update user 
		@PutMapping("/updateuser")
		public ResponseEntity<ResponseUIVO> updateuser(@RequestBody String request) {
			ObjectMapper objectMapper = new ObjectMapper();
			ResponseUIVO responseUIVO=null;
			
			
			try {
				UserManagerResponseWrapperDTO usermanager = new UserManagerResponseWrapperDTO();

				usermanager = objectMapper.readValue(request, UserManagerResponseWrapperDTO.class);
				
				responseUIVO = userManagerRestService.updateuser(usermanager);


			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
			

		}

	
	
}
