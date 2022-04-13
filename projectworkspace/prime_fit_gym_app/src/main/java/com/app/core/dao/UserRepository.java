package com.app.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.core.pojos.GymBranch;
import com.app.core.pojos.User;
import com.app.core.pojos.UserRole;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.email=:mail and u.password=:pwd")
	User validateUser(@Param("mail")String mail,@Param("pwd")String pwd);
	
	List<User> findByRole(UserRole role);
	
//	@Query("SELECT l FROM LearningLicense l where l.user = :a")
//    public LearningLicense findByUserId(@Param(value = "a") User user);
	@Query("select u from User u where u.role=:role and u.branch=:id")
	List<User> getUserByBranchId(@Param("role") UserRole role, @Param("id")GymBranch id);
	
	
	@Query("select u from User u where u.branch=:id")
	List<User> getBranchusers( @Param("id")GymBranch id);
}
