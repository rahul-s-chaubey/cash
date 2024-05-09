package com.idbiintech.cash.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idbiintech.cash.Entity.BankMaster;

@Repository
public interface BankMasterRepository extends JpaRepository<BankMaster, Integer> {
	
	@Query("FROM BankMaster bm WHERE bm.bankName=:bankName ")
	List<BankMaster> getbanknamelist(@Param("bankName") String bankName );
	
	@Query("FROM BankMaster bm WHERE bm.bankMasterId=:bankMasterId ")
	List<BankMaster> getbanklist(@Param("bankMasterId") Integer bankMasterId );
	
	
	BankMaster findByBankMasterId(Integer bankMasterId);
	
	@Query("FROM BankMaster cm WHERE  cm.isActive=1")
	List<BankMaster> getbankList( );


}
