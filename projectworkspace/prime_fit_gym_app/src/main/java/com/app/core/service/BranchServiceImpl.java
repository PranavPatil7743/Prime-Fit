package com.app.core.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.core.dao.BatchRepository;
import com.app.core.dao.GymBranchRepository;
import com.app.core.dao.UserRepository;
import com.app.core.pojos.Batch;
import com.app.core.pojos.GymBranch;
import com.app.core.pojos.User;

@Service
@Transactional
public class BranchServiceImpl implements IBranchService{
	
	@Autowired
	private GymBranchRepository branchRepo;
	
	@Autowired
	private BatchRepository batchRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<GymBranch> getAllBranches() {
		// TODO Auto-generated method stub
		return branchRepo.findAll();
	}

	@Override
	public GymBranch addNewBranch(GymBranch branch) {
		// TODO Auto-generated method stub
		return branchRepo.save(branch);
	}

	@Override
	public GymBranch updateBranch(GymBranch branch,int id) {
		// TODO Auto-generated method stub
		GymBranch b=branchRepo.findById(id).get();
		b.setBranchName(branch.getBranchName());
		b.setCity(branch.getCity());
		b.setLocality(branch.getLocality());
		b.setPhone(branch.getPhone());
		b.setState(branch.getState());
		b.setZipCode(branch.getZipCode());	
		return branchRepo.save(b);
		
	}

	@Override
	public String deleteBranch(int branchId) {
		// TODO Auto-generated method stub
		GymBranch b=branchRepo.findById(branchId).get();
		
		List<Batch> batches=batchRepo.getBatchByBranchId(b);
		batches.forEach(System.out::println);
		
		for (Batch batch : batches) {
			batchRepo.deleteById(batch.getId());
		}
		
		List<User> users=userRepo.getBranchusers(b);
		for (User user : users) {
			userRepo.deleteById(user.getId());
		}
		
		branchRepo.deleteById(branchId);
		return "Branch with Id "+branchId+" deleted successfully";
	}

	@Override
	public GymBranch getBranchDetails(int branchId) {
		// TODO Auto-generated method stub
		return branchRepo.findById(branchId)
				.orElseThrow(()->new NoSuchElementException("Branch by Id "+branchId+" not found"));
	}

}
