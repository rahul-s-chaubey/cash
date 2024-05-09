package com.idbiintech.cash.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idbiintech.cash.DTO.BankManagerDTO;
import com.idbiintech.cash.DTO.ModuleManagerResponseDTO;
import com.idbiintech.cash.DTO.RequestDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.DTO.RoleManagerResponseWrapperDTO;
import com.idbiintech.cash.DTO.WorkFlowModulesListDTO;
import com.idbiintech.cash.DTO.WorkflowManagerRequestDTO;
import com.idbiintech.cash.DTO.WorkflowManagerResponseDTO;
import com.idbiintech.cash.DTO.WorkflowMangerWrapperResponseDTO;
import com.idbiintech.cash.Entity.WorkflowDetails;
import com.idbiintech.cash.Service.ModuleMasterService;
import com.idbiintech.cash.Service.RoleManagerRestService;
import com.idbiintech.cash.Service.WorkflowRestService;

@CrossOrigin
@RestController
public class WorkflowRestController {
	
	@Autowired
	WorkflowRestService workflowrestservice;
	
	@Autowired
	ModuleMasterService modulemasterservice;
	
	@Autowired
	RoleManagerRestService rolemanagerrestservice;
	
	
	//GetList Of WorkFlow API
		@GetMapping("/workflow-manager/workflows/{role_id}")
		public ResponseEntity<WorkflowMangerWrapperResponseDTO> getListWorkFlow(@PathVariable("role_id") Integer roleId) {
			
			WorkflowMangerWrapperResponseDTO workFlowManagerWrapperResponseUIVO=null;
			HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
			try {
				status=HttpStatus.OK;
				workFlowManagerWrapperResponseUIVO = workflowrestservice.getallworkflow(roleId);

			   } 
			catch (Exception e) {
				e.printStackTrace();
			}
		return ResponseEntity.status(status).body(workFlowManagerWrapperResponseUIVO);
				
			
		}
			
		
	// Create Workflow 	
		@PostMapping(value  = "/createworkflow")
		public ResponseEntity<ResponseUIVO> createWorkflow
		( @RequestBody String request)
		
		
		{
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			ResponseUIVO responseUIVO=null;
			
			ObjectMapper objectMapper = new ObjectMapper();
			WorkflowManagerRequestDTO[] workflowManagerRequestUIVO = null;
			
			try 
			{
				status = HttpStatus.CREATED;
//				
//				RequestDTO uiVO=new RequestDTO();
//				
//				uiVO = objectMapper.readValue(request, RequestDTO.class);
//				  
//				  workflowManagerRequestUIVO = objectMapper.readValue(request, WorkflowManagerRequestDTO[].class);
				
				

				workflowManagerRequestUIVO = objectMapper.readValue(request, WorkflowManagerRequestDTO[].class);
				
				
				  
				  responseUIVO = workflowrestservice.createWorkflow(workflowManagerRequestUIVO);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();	
		
			}
			
//			return ResponseEntity.status(status).body(responseUIVO);
			
			return new ResponseEntity<>(responseUIVO, HttpStatus.BAD_REQUEST);
		}
		 
		
		//GetById WorkFlow Master
		@GetMapping(value = "/workflowbyid/{workflow-id}")
		public ResponseEntity<List<WorkflowDetails>> getWorkflowById(@PathVariable("project-id") Integer projectId,
				@PathVariable("customer-id") Integer customerId,@PathVariable("workflow-id") Integer workflowId) {
			
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			List<WorkflowDetails> workflowDetailsList = null;
			ResponseUIVO responseUVIO = null;
			try {
				status = HttpStatus.CREATED;
				workflowDetailsList = workflowrestservice.getWorkflowById(workflowId);
			} catch (Exception ex) {
				ex.printStackTrace();
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}

			return ResponseEntity.status(status).body(workflowDetailsList);
		}
		

		// Delete Mapping
		
		@GetMapping(value = "/deleteworkflows/{workflow-id}")
		public ResponseEntity<ResponseUIVO> deleteWorkflowById(
				@PathVariable("workflow-id") Integer workflowId) 
		  {
			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
			
			WorkflowManagerResponseDTO workflowManagerResponseUIVO = null;
			ResponseUIVO responseUVIO = null;
			try {
				status = HttpStatus.CREATED;
				workflowManagerResponseUIVO = workflowrestservice.deleteWorkflowById(workflowId);
			} catch (Exception ex) {
				ex.printStackTrace();
				responseUVIO = new ResponseUIVO();
				workflowManagerResponseUIVO = new WorkflowManagerResponseDTO();
				//responseUVIO.setCustomerId(customerId);
				//responseUVIO.setProjectId(projectId);
				responseUVIO.setMessage(ex.getMessage());
				responseUVIO.setStatus(500);
				responseUVIO.setData(null);
				workflowManagerResponseUIVO.setResponseUIVO(responseUVIO);
			}

			return ResponseEntity.status(status).body(workflowManagerResponseUIVO.getResponseUIVO());
		}
		

		
		
		@GetMapping("/get-modules-list/workflows/{role_id}")
		public ResponseEntity<WorkFlowModulesListDTO> getAllModulesList(@PathVariable("role_id") Integer roleId) {
			
			
			ModuleManagerResponseDTO modulesManagerResponseUIVO = null;
			
		//	CustomerManagerResponseWrapperUIVO customerManagerResponseWrapperUIVO = null ;
			
			RoleManagerResponseWrapperDTO roleMasterResponseVO = null ;
			
			WorkFlowModulesListDTO workFlowModulesListUIVO=null;
			
			HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
			try {
				status=HttpStatus.OK;
				modulesManagerResponseUIVO = modulemasterservice.getallmodule();
				
			//	customerManagerResponseWrapperUIVO =customerManagerDBServiceImpl.getAllCustomer(projectId);
				
				roleMasterResponseVO = rolemanagerrestservice.getallrolelist(roleId);
	 
				workFlowModulesListUIVO = new WorkFlowModulesListDTO();
				
			//	workFlowModulesListUIVO.setCustomerManagerResponseWrapperUIVO(customerManagerResponseWrapperUIVO);
				workFlowModulesListUIVO.setModulesManagerResponseUIVO(modulesManagerResponseUIVO);
				workFlowModulesListUIVO.setRoleMasterResponseVO(roleMasterResponseVO);
				
				return ResponseEntity.status(status).body(workFlowModulesListUIVO);
				
			   } 
			catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(status).body(null);
				
			}
			
		}
		
		
		
		
		

}
