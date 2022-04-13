package com.app.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.core.pojos.Batch;
import com.app.core.pojos.GymBranch;
@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {
	
	@Query("select b from Batch b where b.branch=:id")
	List<Batch> getBatchByBranchId( @Param("id")GymBranch id);
	
	
	
}
