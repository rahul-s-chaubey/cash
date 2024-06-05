package com.idbiintech.cash.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idbiintech.cash.Entity.BankMaster;
import com.idbiintech.cash.Entity.RoleMaster;
import com.idbiintech.cash.Entity.UserMaster;

@Repository
public interface RoleMasterRepository extends JpaRepository<RoleMaster, Integer> {

	/* List<RoleMaster> getRoleList(); */
	
	@Query("FROM RoleMaster rm WHERE rm.roleId=:roleId ")
	List<RoleMaster> getRoleList(@Param("roleId") Integer roleId );
	
	
	RoleMaster findByRoleId(Integer roleId);
	
	
	@Query("FROM RoleMaster rm WHERE rm.isActive=1")
	List<RoleMaster> getRoleList();
	
	
	
//	@Query("FROM RoleMaster r where r.ROLEID =:roleId")
//	public RoleMaster findByRoleId(@Param("roleId")Long roleId);


//	Object getById(long longValue);

}
