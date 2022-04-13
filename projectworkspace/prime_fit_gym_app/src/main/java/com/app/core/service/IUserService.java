package com.app.core.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.app.core.dto.LoginRequest;
import com.app.core.pojos.User;
import com.app.core.pojos.UserRole;

public interface IUserService {
	// getall users of the gym
	List<User> getAllMembers();
	
	List<User> getAllTrainers();
	
	List<User> getAllLocalAdmins();

	// get all members of the gym
//	 List<User> getAllMembers(Role member);
//
//	// get all the trainers of the gym
//	 List<User> getAllTrainers(Role trainer);
//
//	// get all the localAdmins of the gum
//	 List<User> getAllLocalAdmins(Role localAdmin);

	// update user
	 User updateUser(User user,int id);

	// register new user
	User register(User user, int userBranchId);
//	 User register(User user);

	// delete user
	String deleteUser(int userId);

	// get user by id
	User getUserDetails(int userId);
	
	User authenticateUserLogin(LoginRequest loginRequst);
	
	List<User> getUserByBranchId( UserRole role, int id);
	
	

}
