package com.idbiintech.cash.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idbiintech.cash.Entity.WorkflowMaster;

public interface WorkflowMasterRepository extends JpaRepository<WorkflowMaster, Integer> {
	
	 WorkflowMaster findByWorkflowId(Integer workflowId);
	 
	 @Query("FROM WorkflowMaster wm where wm.moduleId =:moduleId and wm.dealerMasterId =:dealerMasterId")
		public WorkflowMaster getWorkflowMasterByModuleId(@Param("moduleId") Integer moduleId,@Param("dealerMasterId") Integer dealerMasterId);	


}
