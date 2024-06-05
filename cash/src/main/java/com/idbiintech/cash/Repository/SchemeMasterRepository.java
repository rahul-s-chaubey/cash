package com.idbiintech.cash.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idbiintech.cash.Entity.SchemeMaster;

@Repository
public interface SchemeMasterRepository extends CrudRepository<SchemeMaster, Long> {

	
	 @Query("FROM SchemeMaster sm where sm.casteName =:casteName and sm.incomeBracket =:incomeBracket")
		public List<SchemeMaster> getSchemeMasterBycasteandincome(@Param("casteName") String casteName,@Param("incomeBracket") String incomeBracket);	
	
	
}
