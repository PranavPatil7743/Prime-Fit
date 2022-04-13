package com.app.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.core.pojos.GymBranch;
@Repository
public interface GymBranchRepository extends JpaRepository<GymBranch, Integer> {

}
