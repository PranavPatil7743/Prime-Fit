package com.app.core.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.core.dao.GymBranchRepository;
import com.app.core.dao.UserRepository;
import com.app.core.dto.LoginRequest;
import com.app.core.pojos.GymBranch;
import com.app.core.pojos.User;
import com.app.core.pojos.UserRole;
@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private GymBranchRepository gymRepo;
	
	@Override
	public List<User> getAllMembers() {
		//to return all members
		return userRepo.findByRole(UserRole.MEMBER);
	}
	

	@Override
	public List<User> getAllTrainers() {
		// //to return all trainers
		return userRepo.findByRole(UserRole.TRAINER);
	}

	@Override
	public List<User> getAllLocalAdmins() {
		////to return all localAdmins
		return userRepo.findByRole(UserRole.LOCAL_ADMIN);
	}

	@Override
	public User register(User user,int userBranchId) {
		//to register or save the user details 
		GymBranch b=gymRepo.findById(userBranchId).get();
		user.setBranch(b);
		return userRepo.save(user);
	}

//	@Override
//	public User register(User user) {
//		// TODO Auto-generated method stub
//		return userRepo.save(user);
//	}

	@Override
	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		 userRepo.deleteById(userId);
		 return "User Details with Id "+userId+ "deleted successfully";
	}

	@Override
	public User getUserDetails(int userId) {
		// TODO Auto-generated method stub
		return userRepo.findById(userId)
				.orElseThrow(() -> new NoSuchElementException("User by Id "+userId+" not found"));
	}

	@Override
	public User updateUser(User user,int id) {
		GymBranch b=gymRepo.findById(id).get();
		User u1=userRepo.findById(user.getId()).get();
		
		u1.setBranch(b);
		
		return userRepo.save(u1);
	}
	
	@Override
	public User authenticateUserLogin(LoginRequest loginRequst) {
		
		return userRepo.validateUser(loginRequst.getEmail(), loginRequst.getPassword());
							
	}


	@Override
	public List<User> getUserByBranchId(UserRole role, int id) {
		// TODO Auto-generated method stub
		GymBranch b=gymRepo.findById(id).get();
		
		return userRepo.getUserByBranchId(role, b);
	}


	
}
