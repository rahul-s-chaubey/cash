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
import com.idbiintech.cash.DTO.DealerManagerDTO;
import com.idbiintech.cash.DTO.DealerManagerResponseDTO;
import com.idbiintech.cash.DTO.DealerManagerResponseWrapperDTO;
import com.idbiintech.cash.DTO.PermissionRequestDTO;
import com.idbiintech.cash.DTO.ResponseUIVO;
import com.idbiintech.cash.Entity.BankMaster;
import com.idbiintech.cash.Entity.DealerDetail;
import com.idbiintech.cash.Entity.DealerMaster;
import com.idbiintech.cash.Entity.RolesModuleMaster;
import com.idbiintech.cash.Repository.BankMasterRepository;
import com.idbiintech.cash.Repository.DealerDetailRepository;
import com.idbiintech.cash.Repository.DealerMasterRepository;
import com.idbiintech.cash.Repository.RoleModuleMasterRepository;
import com.idbiintech.cash.Service.DealerManagerRestService;

@Service
public class DealerManagerRestServiceImpl implements DealerManagerRestService {

	@Autowired
	private DealerDetailRepository DealerDetailRepository;
	
	@Autowired
	private DealerMasterRepository DealerMasterRepository;
	
	@Autowired
	RoleModuleMasterRepository RoleModuleMasterRepository;

	@Override
	public ResponseUIVO createdealer(DealerManagerDTO dealermanager) {
	ResponseUIVO responseUIVO=null;
		
		try {
			
			responseUIVO=new ResponseUIVO();
			
			DealerMaster dealermaster = new DealerMaster();
			
			dealermaster.setAddress(dealermanager.getAddress());
			dealermaster.setBusinessRegistrationNo(dealermanager.getBusinessRegistrationNo());
			dealermaster.setAccountNo(dealermanager.getAccountNo());
			dealermaster.setContact(dealermanager.getContact());
			dealermaster.setEmail(dealermanager.getEmail());
			dealermaster.setGst(dealermanager.getGst());
			dealermaster.setName(dealermanager.getName());
			dealermaster.setBusinessname(dealermanager.getName());
			dealermaster.setTin(dealermanager.getTin());
			dealermaster.setBankName(dealermanager.getBankName());
			dealermaster.setIsActive(1);
			
			
			
			  
			DealerMasterRepository.save(dealermaster);
			 
			DealerDetail dealerdetail = new DealerDetail();
			
//			dealerdetail.setAcctNo(dealermanager.getAcctNo());
			dealerdetail.setAddress(dealermanager.getAddress());
			dealerdetail.setBankName(dealermanager.getBankName());
			dealerdetail.setBranch(dealermanager.getBranch());
			
			
			responseUIVO.setMessage("Dealer Added Succesfully");
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
	public DealerManagerResponseDTO getalldealer(Integer roleId) {
		
		
		DealerManagerDTO dealermanagerDTO = null;
		DealerManagerResponseDTO dealermanagerresponseDTO =new DealerManagerResponseDTO();
		List<DealerManagerDTO> list =new ArrayList<>();

		try {

			List<DealerMaster> dealerMasterList = new ArrayList<>();
			dealerMasterList = DealerMasterRepository.getdealerList();
			
			
			
			for (DealerMaster dealerMaster : dealerMasterList) {
				dealermanagerDTO = new DealerManagerDTO();
				BeanUtils.copyProperties(dealerMaster, dealermanagerDTO);
				list.add(dealermanagerDTO);
			}
			dealermanagerresponseDTO.setDealermanagerDTOList(list);


			
			/* permission */ 
		  	  
		  	  
		  	  PermissionRequestDTO permissions = null; 
		//	  RoleManagerResponseWrapperDTO roleMasterResponseVO = new RoleManagerResponseWrapperDTO();
			  List<PermissionRequestDTO> permissionlist = new ArrayList<PermissionRequestDTO>();
			  
			  Integer moduleId = 4;
			List<RolesModuleMaster> permissionList = RoleModuleMasterRepository.getPermissionList(roleId,moduleId );
			  
			  for (RolesModuleMaster rolesmoduleMaster : permissionList) { 
				  permissions = new PermissionRequestDTO();
				  BeanUtils.copyProperties(rolesmoduleMaster, permissions);
				  permissionlist.add(permissions);
				  }
			  dealermanagerresponseDTO.setPermissionDTOList(permissionlist);
			 
			
			
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return dealermanagerresponseDTO;
		
		
		
		
		
		
		
	}





	@Override
	public DealerManagerResponseWrapperDTO getdealerById(Integer dealerMasterId) {
		DealerManagerResponseWrapperDTO dealerManagerResponseWrapperDTO = new DealerManagerResponseWrapperDTO();

	        Optional<DealerMaster> dealerMasterOptional = DealerMasterRepository.findById(dealerMasterId);
	        if (dealerMasterOptional.isPresent()) {
	        	DealerMaster dealerMaster = dealerMasterOptional.get();

	            if (dealerMaster != null) { 
	            	
	                BeanUtils.copyProperties(dealerMaster, dealerManagerResponseWrapperDTO);

	            
	                ResponseUIVO responseUIVO = new ResponseUIVO();
	                responseUIVO.setStatus(200);
	                responseUIVO.setMessage("Data fetched successfully");
	                dealerManagerResponseWrapperDTO.setResponseUIVO(responseUIVO);
	            } else {
	              
	                ResponseUIVO responseUIVO = new ResponseUIVO();
	                responseUIVO.setStatus(500);
	                responseUIVO.setMessage("Bank Master is null for ID: " + dealerMasterId);
	                dealerManagerResponseWrapperDTO.setResponseUIVO(responseUIVO);
	            }
	        } else {
	         
	            ResponseUIVO responseUIVO = new ResponseUIVO();
	            responseUIVO.setStatus(404);
	            responseUIVO.setMessage("Bank Manager not found for ID: " + dealerMasterId);
	            dealerManagerResponseWrapperDTO.setResponseUIVO(responseUIVO);
	        }

	        return dealerManagerResponseWrapperDTO;
	    }




	@Override
	public DealerManagerResponseWrapperDTO getbankdealername(String name) {
		
		DealerManagerResponseWrapperDTO dealerManagerResponseWrapperDTO = new DealerManagerResponseWrapperDTO();

		try {
			
			List<DealerMaster> dealerMaster = null;
			dealerMaster = DealerMasterRepository.getdealernamelist(name);
		
			
			
			for (DealerMaster dealermaster : dealerMaster) {
				dealerManagerResponseWrapperDTO = new DealerManagerResponseWrapperDTO();
				BeanUtils.copyProperties(dealermaster,dealerManagerResponseWrapperDTO);
			}
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

        return dealerManagerResponseWrapperDTO;
    }




	@Override
	public ResponseUIVO deletedealer(Integer bankMasterId) {
		
		ResponseUIVO responseUIVO=null;

		
		
		try {
			
			responseUIVO=new ResponseUIVO();
			
			DealerMaster dealermaster = new DealerMaster();
			
			dealermaster = DealerMasterRepository.findByDealerMasterId(bankMasterId);
			
			dealermaster.setIsActive(0);
			
			DealerMasterRepository.save(dealermaster);
			 
			
			
			responseUIVO.setMessage("Dealer Delete Succesfully");
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
	public ResponseUIVO updatedealer(DealerManagerResponseWrapperDTO dealermanager) {
	ResponseUIVO responseUIVO=null;

		 
		
		try {
			
			responseUIVO=new ResponseUIVO();
			
			DealerMaster dealermaster = new DealerMaster();
			
			dealermaster = DealerMasterRepository.findByDealerMasterId(dealermanager.getDealerMasterId());
			dealermaster.setAddress(dealermanager.getAddress());
			dealermaster.setAccountNo(dealermanager.getAccountNo());
			dealermaster.setBankName(dealermanager.getBankName());
			dealermaster.setBusinessname(dealermanager.getName());
			dealermaster.setBusinessRegistrationNo(dealermanager.getBusinessRegistrationNo());
			dealermaster.setContact(dealermanager.getContact());
			dealermaster.setEmail(dealermanager.getEmail());
			dealermaster.setGst(dealermanager.getGst());
			dealermaster.setTin(dealermanager.getTin());
			
			
			DealerMasterRepository.save(dealermaster);
			 
			
			
			responseUIVO.setMessage("Dealer Updated Succesfully");
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

	

