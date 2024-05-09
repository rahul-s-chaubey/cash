package com.idbiintech.cash.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idbiintech.cash.Entity.BankMaster;
import com.idbiintech.cash.Entity.UserMaster;


public interface UserMasterRepository extends JpaRepository<UserMaster, Integer>
{
	
	@Query("FROM UserMaster um WHERE um.userId=:userId")
	List<UserMaster> getUserById(@Param("userId") Integer userId );
	
	
	@Query("FROM UserMaster um WHERE um.isActive=1")
	List<UserMaster> getUserList();
	
	@Query("FROM UserMaster um WHERE um.email=:email AND um.password=:password AND um.isActive=1")
	UserMaster getUser(@Param("email") String emailId, @Param("password") String password );
	
	UserMaster  findByUserId(Integer userId);
	
	
}