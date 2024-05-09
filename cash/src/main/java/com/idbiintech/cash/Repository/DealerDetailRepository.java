package com.idbiintech.cash.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idbiintech.cash.Entity.DealerDetail;

@Repository
public interface DealerDetailRepository extends JpaRepository<DealerDetail, Integer> {

}
