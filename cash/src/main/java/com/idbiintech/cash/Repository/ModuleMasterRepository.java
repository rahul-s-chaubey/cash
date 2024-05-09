package com.idbiintech.cash.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.idbiintech.cash.Entity.Modules;


public interface ModuleMasterRepository extends JpaRepository<Modules, Integer> {
	
//	
//	@Query("FROM Modules m WHERE  m.isActive=1")
//	List<Modules> getmoduleList( );


}
