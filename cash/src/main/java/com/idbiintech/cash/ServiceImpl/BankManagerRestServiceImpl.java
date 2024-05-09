package com.idbiintech.cash.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.DTO.BankManagerDTO;
import com.idbiintech.cash.DTO.BankManagerResponseDTO;
import com.idbiintech.cash.DTO.BankManagerResponseWrapperDTO;
import com.idbiintech.cash.DTO.PermissionRequestDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.Entity.BankMaster;
import com.idbiintech.cash.Entity.RolesModuleMaster;
import com.idbiintech.cash.Repository.BankMasterRepository;
import com.idbiintech.cash.Repository.RoleModuleMasterRepository;
import com.idbiintech.cash.Service.BankManagerRestService;


@Service
public class BankManagerRestServiceImpl implements BankManagerRestService {

	@Autowired
	private BankMasterRepository BankMasterRepository;
	
	@Autowired
	RoleModuleMasterRepository RoleModuleMasterRepository;
	
	
	
	@Override
	public ResponseUIVO createbank(BankManagerDTO bankManager) {
		
		
		
		ResponseUIVO responseUIVO=null;
		
		try {
			
			responseUIVO=new ResponseUIVO();
			
			BankMaster bankmaster = new BankMaster();
			
			bankmaster.setAddress(bankManager.getAddress());
			bankmaster.setBankName(bankManager.getBankName());
			bankmaster.setContact(bankManager.getContact());
			bankmaster.setIfscCode(bankManager.getIfscCode());
			bankmaster.setRegNo(bankManager.getRegNo());
			bankmaster.setSwiftCode(bankManager.getSwiftCode());
			bankmaster.setIsActive(1);
			  
			BankMasterRepository.save(bankmaster);
			 
			
			
			responseUIVO.setMessage("Bank Added Succesfully");
			responseUIVO.setStatus(201);
			
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

//	@Override
//	public BankManagerDTO getbankById(BankManagerDTO bankManager) {
//
//		List<BankMaster> bankMaster = new ArrayList<>();
//		BankManagerDTO bankmangerdto = null;
//
//		try {
//			
//			bankMaster = BankMasterRepository.findById(bankManager.getBankMasterId());
//			
//					bankmangerdto = new BankManagerDTO();
//			BeanUtils.copyProperties(bankMaster,bankmangerdto);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return bankMaster;
//		
//
//	}

	
	@Override
	public BankManagerResponseDTO getallbank(Integer roleId) {
		

		
		BankManagerDTO bankmanagerDTO = null;
		BankManagerResponseDTO bankmanagerresponseDTO =new BankManagerResponseDTO();
		List<BankManagerDTO> list =new ArrayList<>();

		try {

			List<BankMaster> bankMasterList = new ArrayList<>();
			bankMasterList = BankMasterRepository.getbankList();
			
			
			
			for (BankMaster bankMaster : bankMasterList) {
				bankmanagerDTO = new BankManagerDTO();
				BeanUtils.copyProperties(bankMaster, bankmanagerDTO);
				list.add(bankmanagerDTO);
			}
			bankmanagerresponseDTO.setBankmanagerDTOList(list);


			
			
			
			/* permission */ 
		  	  
		  	  
		  	  PermissionRequestDTO permissions = null; 
		//	  RoleManagerResponseWrapperDTO roleMasterResponseVO = new RoleManagerResponseWrapperDTO();
			  List<PermissionRequestDTO> permissionlist = new ArrayList<PermissionRequestDTO>();
			  
			  Integer moduleId = 3;
			List<RolesModuleMaster> permissionList = RoleModuleMasterRepository.getPermissionList(roleId,moduleId );
			  
			  for (RolesModuleMaster rolesmoduleMaster : permissionList) { 
				  permissions = new PermissionRequestDTO();
				  BeanUtils.copyProperties(rolesmoduleMaster, permissions);
				  permissionlist.add(permissions);
				  }
			  		bankmanagerresponseDTO.setPermissionDTOList(permissionlist);
			 
			
			
			
			
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return bankmanagerresponseDTO;
			
		
		
	}

	@Override
	public BankManagerResponseWrapperDTO getbankById(Integer bankMasterId) {
		
		
		 BankManagerResponseWrapperDTO bankManagerResponseWrapperDTO = new BankManagerResponseWrapperDTO();

	        Optional<BankMaster> bankMasterOptional = BankMasterRepository.findById(bankMasterId);
	        if (bankMasterOptional.isPresent()) {
	            BankMaster bankMaster = bankMasterOptional.get();

	            if (bankMaster != null) { 
	            	
	                BeanUtils.copyProperties(bankMaster, bankManagerResponseWrapperDTO);

	            
	                ResponseUIVO responseUIVO = new ResponseUIVO();
	                responseUIVO.setStatus(200);
	                responseUIVO.setMessage("Data fetched successfully");
	                bankManagerResponseWrapperDTO.setResponseUIVO(responseUIVO);
	            } else {
	              
	                ResponseUIVO responseUIVO = new ResponseUIVO();
	                responseUIVO.setStatus(500);
	                responseUIVO.setMessage("Bank Master is null for ID: " + bankMasterId);
	                bankManagerResponseWrapperDTO.setResponseUIVO(responseUIVO);
	            }
	        } else {
	         
	            ResponseUIVO responseUIVO = new ResponseUIVO();
	            responseUIVO.setStatus(404);
	            responseUIVO.setMessage("Bank Manager not found for ID: " + bankMasterId);
	            bankManagerResponseWrapperDTO.setResponseUIVO(responseUIVO);
	        }

	        return bankManagerResponseWrapperDTO;
	    }
	
	
	
	

	@Override
	public BankManagerResponseWrapperDTO getbankBybankname(String bankName) {
		


	       
		BankManagerResponseWrapperDTO bankManagerResponseWrapperDTO = null;

			try {
				
				List<BankMaster> bankMaster = null;
				bankMaster = BankMasterRepository.getbanknamelist(bankName);
				System.out.println("bankmaster" +bankMaster);
				
				
				for (BankMaster bankmaster : bankMaster) {
					bankManagerResponseWrapperDTO = new BankManagerResponseWrapperDTO();
					BeanUtils.copyProperties(bankmaster,bankManagerResponseWrapperDTO);
				}
				
				
				

			} catch (Exception e) {
				e.printStackTrace();
			}


	        return bankManagerResponseWrapperDTO;
	        
	}

	@Override
	public ResponseUIVO deletebank(Integer bankMasterId) {
		
		
		ResponseUIVO responseUIVO=null;

	
			
			try {
				
				responseUIVO=new ResponseUIVO();
				
				BankMaster bankmaster = new BankMaster();
				
				bankmaster = BankMasterRepository.findByBankMasterId(bankMasterId);
				
				bankmaster.setIsActive(0);
				
				BankMasterRepository.save(bankmaster);
				 
				
				
				responseUIVO.setMessage("Bank Delete Succesfully");
				responseUIVO.setStatus(201);
				
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

	@Override
	public ResponseUIVO updatebank(BankManagerResponseWrapperDTO bankManager) {
		
		ResponseUIVO responseUIVO=null;

		
		
		try {
			
			responseUIVO=new ResponseUIVO();
			
			BankMaster bankmaster = new BankMaster();
			
			bankmaster = BankMasterRepository.findByBankMasterId(bankManager.getBankMasterId());
			bankmaster.setAddress(bankManager.getAddress());
			bankmaster.setBankName(bankManager.getBankName());
			bankmaster.setContact(bankManager.getContact());
			bankmaster.setIfscCode(bankManager.getIfscCode());
			bankmaster.setRegNo(bankManager.getRegNo());
			bankmaster.setSwiftCode(bankManager.getSwiftCode());
			
			
			BankMasterRepository.save(bankmaster);
			 
			
			
			responseUIVO.setMessage("Bank Updated Succesfully");
			responseUIVO.setStatus(201);
			
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
