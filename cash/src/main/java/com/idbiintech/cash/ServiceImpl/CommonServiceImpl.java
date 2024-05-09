package com.idbiintech.cash.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idbiintech.cash.Entity.WorkflowMaster;
import com.idbiintech.cash.Repository.WorkflowMasterRepository;
import com.idbiintech.cash.Service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	WorkflowMasterRepository workflowMasterRepository;

	@Override
	public Boolean isWorkFlowPresent(Integer moduleId, Integer dealerMasterId) {
		Boolean isWorfklowPresent = false;
		try 
		{
			WorkflowMaster master =  workflowMasterRepository.getWorkflowMasterByModuleId(moduleId,dealerMasterId);
			if(null != master)
			{
				isWorfklowPresent = true;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return isWorfklowPresent;
	}

}
