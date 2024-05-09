package com.idbiintech.cash.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idbiintech.cash.Entity.BankMaster;
import com.idbiintech.cash.Entity.DealerMaster;

@Repository
public interface DealerMasterRepository extends JpaRepository<DealerMaster, Integer>{

	@Query("FROM DealerMaster dm WHERE dm.name=:name ")
	List<DealerMaster> getdealernamelist(@Param("name") String name );
	
	
	DealerMaster findByDealerMasterId(Integer dealerMasterId);
	
	@Query("FROM DealerMaster cm WHERE  cm.isActive=1")
	List<DealerMaster> getdealerList( );

	
}
