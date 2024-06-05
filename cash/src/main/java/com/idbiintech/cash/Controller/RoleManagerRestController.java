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
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.DTO.RoleManagerDTO;
import com.idbiintech.cash.DTO.RoleManagerResponseWrapperDTO;
import com.idbiintech.cash.Service.RoleManagerRestService;

import jakarta.websocket.server.PathParam;

@CrossOrigin
@RestController
public class RoleManagerRestController {
	
	
	@Autowired
	RoleManagerRestService RoleManagerRestService;
	
	//Create New Role
		@PostMapping("/createrole")
		public  ResponseEntity<ResponseUIVO> createrole(@RequestBody String request) {
			
			ObjectMapper objectMapper = new ObjectMapper();
			ResponseUIVO responseUIVO=null;
			
			
			try {
				RoleManagerDTO rolemanager = new RoleManagerDTO();

				rolemanager = objectMapper.readValue(request, RoleManagerDTO.class);
				
				responseUIVO = RoleManagerRestService.createrole(rolemanager);


			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
			
			
		}
		
		
		
		//Get All Role List 
		@GetMapping("/getallrolelist/{role_id}")
		public ResponseEntity<RoleManagerResponseWrapperDTO> getallrolelist(@PathVariable("role_id") Integer roleId) {
			
			
			ResponseUIVO responseUIVO = null;
			RoleManagerResponseWrapperDTO rolesMasterVO = null;
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			try {

				rolesMasterVO = RoleManagerRestService.getallrolelist(roleId);
				
			//	rolesMasterVO = RoleManagerRestService.getpermission(roleId);
				
				status = HttpStatus.ACCEPTED;

			} catch (Exception e) {

				e.printStackTrace();
				responseUIVO = new ResponseUIVO();
				rolesMasterVO = new RoleManagerResponseWrapperDTO();
				responseUIVO.setMessage(e.getMessage());
				responseUIVO.setStatus(500);
				responseUIVO.setData(null);
				rolesMasterVO.setResponseUIVO(responseUIVO);

			}
			return ResponseEntity.status(status).body(rolesMasterVO);
		}
		
		
		
//		// Get User ById
		
		  @GetMapping(value = "/getRoleById/{role_id}")
		  public ResponseEntity<RoleManagerDTO> getroleById(@PathVariable("role_id") Integer roleId) {
		  
		  RoleManagerDTO userManagerResponseDTO = new RoleManagerDTO();
		  
		  
		  try {
			  
			  userManagerResponseDTO = RoleManagerRestService.getroleById(roleId) ;
		  
		  
		  ResponseUIVO responseUVIO = new ResponseUIVO();
		  
		  responseUVIO.setMessage("Data fetched successfully");
		  responseUVIO.setStatus(200);
		  userManagerResponseDTO.setResponseUIVO(responseUVIO);
		  
		  return new ResponseEntity<>(userManagerResponseDTO, HttpStatus.OK); 
		  
		  }catch (Exception e) {
			  e.printStackTrace();
			  ResponseUIVO responseUVIO = new ResponseUIVO();
			  responseUVIO.setMessage("Something Went Wrong");
			  responseUVIO.setStatus(500);
			  userManagerResponseDTO.setResponseUIVO(responseUVIO); return
			  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userManagerResponseDTO); }
		  
		  }
		  
		 
	
		// delete role 
			@GetMapping(value = "/deleterole/{role_id}")
			public ResponseEntity<ResponseUIVO> deletebankById(@PathVariable("role_id") Integer roleId) {
				
				ResponseUIVO responseUIVO=null;
				
				try {
					
					responseUIVO = RoleManagerRestService.deleteuser(roleId);


				} catch (Exception e) { 
					e.printStackTrace();
				}
				return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
			}
		  
	
			
			
			
	// update bank 
			@PutMapping("/updaterole/{role_id}")
			public ResponseEntity<ResponseUIVO> updatebank(@RequestBody String request,@PathVariable("role_id") Integer roleId) {
				ObjectMapper objectMapper = new ObjectMapper();
				ResponseUIVO responseUIVO=null;
				
				
				try {
					RoleManagerDTO rolemanager = new RoleManagerDTO();

					rolemanager = objectMapper.readValue(request, RoleManagerDTO.class);
					
					responseUIVO = RoleManagerRestService.updaterole(rolemanager,roleId);

				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
				

			}  

			
			//Get All Roles 
			@GetMapping("/getallroles")
			public ResponseEntity<RoleManagerResponseWrapperDTO> getallroles() {
				
				
				ResponseUIVO responseUIVO = null;
				RoleManagerResponseWrapperDTO rolesMasterVO = null;
				HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
				try {

					rolesMasterVO = RoleManagerRestService.getallroles();
					
				//	rolesMasterVO = RoleManagerRestService.getpermission(roleId);
					
					status = HttpStatus.ACCEPTED;

				} catch (Exception e) {

					e.printStackTrace();
					responseUIVO = new ResponseUIVO();
					rolesMasterVO = new RoleManagerResponseWrapperDTO();
					responseUIVO.setMessage(e.getMessage());
					responseUIVO.setStatus(500);
					responseUIVO.setData(null);
					rolesMasterVO.setResponseUIVO(responseUIVO);

				}
				return ResponseEntity.status(status).body(rolesMasterVO);
			}
			
			
			
			
			
}
