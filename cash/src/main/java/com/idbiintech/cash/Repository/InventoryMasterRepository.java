package com.idbiintech.cash.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idbiintech.cash.Entity.InventoryMaster;

@Repository
public interface InventoryMasterRepository extends JpaRepository<InventoryMaster, Integer> {

}
