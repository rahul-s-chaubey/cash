package com.idbiintech.cash.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idbiintech.cash.Entity.RolesModuleMaster;
@Repository
public interface RoleModuleMasterRepository extends JpaRepository<RolesModuleMaster, Integer> {

    @Query("FROM RolesModuleMaster rm WHERE rm.roleId =:roleId")
    List<RolesModuleMaster> getRoleModuleList(@Param("roleId") Integer roleId);
    
    @Query("FROM RolesModuleMaster rm WHERE rm.roleId =:roleId AND rm.moduleId =:moduleId ")
    List<RolesModuleMaster> getPermissionList(@Param("roleId") Integer roleId, @Param("moduleId") Integer moduleId);
    

	@Query("  from RolesModuleMaster rm where rm.moduleId =:moduleId AND rm.checker =1 AND rm.customerId =:customerId")
	List<RolesModuleMaster> getRoleIds(@Param("moduleId")Long moduleId, @Param("customerId")Integer customerId);
	 
	
	@Query("SELECT rm.roleId from RolesModuleMaster rm where rm.moduleId =:moduleId AND rm.checker =1")
	RolesModuleMaster getRoleId(@Param("moduleId")Long moduleId);

	
}
