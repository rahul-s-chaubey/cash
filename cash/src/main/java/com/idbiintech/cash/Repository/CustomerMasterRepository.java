package com.idbiintech.cash.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idbiintech.cash.Entity.CustomerMaster;

public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Integer> {
	
	
	List<CustomerMaster>  findByLoanmstId(long loanmstId);

}
