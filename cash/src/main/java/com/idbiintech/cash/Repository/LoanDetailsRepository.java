package com.idbiintech.cash.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idbiintech.cash.Entity.LoanDetails;

public interface LoanDetailsRepository extends JpaRepository<LoanDetails, Integer> {

	
	List<LoanDetails> findByLoanmstId(long loanmstId);
	

	@Query("FROM LoanDetails ld where ld.roleId =:roleId AND ld.dealerMasterId =:dealerMasterId AND ld.status =:status")
	List<LoanDetails> getloandet(@Param("roleId") Integer roleId,
			@Param("dealerMasterId") Integer dealerMasterId,
			@Param("status") String status);

	
	
}
