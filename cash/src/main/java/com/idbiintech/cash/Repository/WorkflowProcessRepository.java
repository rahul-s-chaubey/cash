package com.idbiintech.cash.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idbiintech.cash.Entity.BankMaster;
import com.idbiintech.cash.Entity.WorkflowProcess;

public interface WorkflowProcessRepository extends JpaRepository<WorkflowProcess, Integer> {

	@Query("FROM WorkflowProcess job where job.applicationId =:applicationId")
	WorkflowProcess getJobRecordById(@Param("applicationId") Integer applicationId);
	
	@Query("FROM WorkflowProcess job where job.applicationId =:applicationId AND job.moduleId =:moduleId AND job.assignedTo =:assignedTo")
	WorkflowProcess getJobRecordsByModuleIdAndApplicationIdAndAssignedTo(
			@Param("applicationId") Integer applicationId,
			@Param("moduleId") Integer moduleId,
			@Param("assignedTo") Integer assignedTo);
	
	@Query("FROM WorkflowProcess job where job.applicationId =:applicationId AND job.moduleId =:moduleId")
	List<WorkflowProcess> getJobRecordsById(@Param("applicationId") Integer applicationId,@Param("moduleId") Integer moduleId);
	
	
	@Query("FROM WorkflowProcess wp where wp.roleId =:roleId AND wp.dealerMasterId =:dealerMasterId AND wp.status =:status")
	List<WorkflowProcess> getlistofjob(@Param("roleId") Integer roleId,
			@Param("dealerMasterId") Integer dealerMasterId,
			@Param("status") String status);

}
