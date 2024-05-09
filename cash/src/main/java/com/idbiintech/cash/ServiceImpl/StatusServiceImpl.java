package com.idbiintech.cash.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.DTO.ApprovalDTO;
import com.idbiintech.cash.DTO.CustomerMasterDTO;
import com.idbiintech.cash.DTO.LoanDetailDTO;
import com.idbiintech.cash.DTO.StatusDTO;
import com.idbiintech.cash.DTO.WorkflowProcessDTO;
import com.idbiintech.cash.Entity.CustomerMaster;
import com.idbiintech.cash.Entity.LoanDetails;
import com.idbiintech.cash.Entity.WorkflowProcess;
import com.idbiintech.cash.Repository.CustomerMasterRepository;
import com.idbiintech.cash.Repository.LoanDetailsRepository;
import com.idbiintech.cash.Repository.WorkflowProcessRepository;
import com.idbiintech.cash.Service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	WorkflowProcessRepository WorkflowProcessRepository;

	@Autowired
	LoanDetailsRepository loanDetailsRepository;

	@Autowired
	CustomerMasterRepository customermasterrepository;

	@Override
	public StatusDTO listofworkflow(Integer roleId, Integer dealerMasterId, String status) {

//				List<WorkflowProcess> workflowprocess = new ArrayList<>();
//				
//				workflowprocess = WorkflowProcessRepository.getlistofjob(roleid, dealerMasterId, status);

//				List<LoanDetails> loandet = loanDetailsRepository.getloandet(roleid, dealerMasterId, status);

		LoanDetailDTO loandetDTO = null;
		WorkflowProcessDTO workflowprocessDTO = null;
		StatusDTO statusDTO = new StatusDTO();
		List<LoanDetailDTO> list = new ArrayList<>();
		List<WorkflowProcessDTO> workflowprocesslist = new ArrayList<>();

		try {

			List<LoanDetails> loandet = loanDetailsRepository.getloandet(roleId, dealerMasterId, status);

			for (LoanDetails loandetlist : loandet) {
				loandetDTO = new LoanDetailDTO();
				BeanUtils.copyProperties(loandetlist, loandetDTO);
				list.add(loandetDTO);
			}
			statusDTO.setLoandetdto(list);

			List<WorkflowProcess> workflowprocess = new ArrayList<>();

			workflowprocess = WorkflowProcessRepository.getlistofjob(roleId, dealerMasterId, status);

			for (WorkflowProcess workflowlist : workflowprocess) {
				workflowprocessDTO = new WorkflowProcessDTO();
				BeanUtils.copyProperties(workflowlist, workflowprocessDTO);
				workflowprocesslist.add(workflowprocessDTO);
			}
			statusDTO.setWorkflowprocessdto(workflowprocesslist);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return statusDTO;
	}

	@Override
	public ApprovalDTO getByLoanmastId(Integer loanmstId) {

		List<LoanDetails> loandet = null;
		LoanDetailDTO loandetDTO = null;
		List<LoanDetailDTO> list = new ArrayList<>();
		List<CustomerMaster> customermst = null;
		CustomerMasterDTO customermasterDTO = null;
		List<CustomerMasterDTO> list2 = new ArrayList<>();
		ApprovalDTO approvalDTO = new ApprovalDTO();

		try {

//			loandet = loanDetailsRepository.findByLoanmstId(loanmstId);

//			customermst = customermasterrepository.findByLoanmstId(loanmstId);

			loandet = loanDetailsRepository.findByLoanmstId(loanmstId);

			for (LoanDetails loandetlist : loandet) {
				loandetDTO = new LoanDetailDTO();
				BeanUtils.copyProperties(loandetlist, loandetDTO);
				list.add(loandetDTO);
			}
			approvalDTO.setLoandetdto(list);
			
//			CUSTOMER DETAILS

			customermst = customermasterrepository.findByLoanmstId(loanmstId);

			for (CustomerMaster customerdetlist : customermst) {
				customermasterDTO = new CustomerMasterDTO();
				BeanUtils.copyProperties(customerdetlist, customermasterDTO);
				list2.add(customermasterDTO);
			}
			approvalDTO.setCustomermasterdto(list2);

		}

		catch (Exception e) {
			e.printStackTrace();

		}

		return approvalDTO;
	}

}
