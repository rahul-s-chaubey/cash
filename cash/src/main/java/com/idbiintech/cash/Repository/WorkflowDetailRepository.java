package com.idbiintech.cash.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idbiintech.cash.Entity.WorkflowDetails;

public interface WorkflowDetailRepository extends JpaRepository<WorkflowDetails, Integer> {
	
	public List<WorkflowDetails> findByWorkflowId(Integer workflowId);
	
	@Query("FROM WorkflowDetails wd where wd.moduleId =:moduleId  and wd.dealerMasterId =:dealerMasterId ")
	public List<WorkflowDetails> getStagesByModuleId(@Param("moduleId") Integer moduleId,@Param("dealerMasterId") Integer dealerMasterId);	
}
