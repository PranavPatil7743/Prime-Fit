package com.app.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.core.dto.BranchDTO;
import com.app.core.pojos.GymBranch;
import com.app.core.service.IBranchService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/branches")
public class BranchController {
	
	@Autowired
	private IBranchService branchService;
	
	public BranchController() {
		// TODO Auto-generated constructor stub
	System.out.println("in constructor of "+getClass());
	}
	

	@GetMapping("/branch")
	public BranchDTO<?> getAllBranches(){
		System.out.println("in get all batches");
		return new BranchDTO<>(HttpStatus.OK,"Branches found", branchService.getAllBranches());
	}
	
	@PostMapping("/add")
	public  BranchDTO<?> addBranch(@RequestBody GymBranch branch) {
		System.out.println("In add batch "+branch);
		GymBranch b=branchService.addNewBranch(branch);
		return new BranchDTO<>(HttpStatus.OK,"Branch added successfully", b);
	}
	
	@GetMapping("/branch/{id}")
	public ResponseEntity<?> getBranch(@PathVariable int id) {
		System.out.println("In get branch "+id);
		return new ResponseEntity<>(branchService.getBranchDetails(id),HttpStatus.OK);
	}
	///////////////////////////////////////////////////
	
	@PutMapping("/update/{id}")
	public  BranchDTO<?> updateBranch(@RequestBody GymBranch branch,@PathVariable int id) {
		System.out.println("in update batch "+branch+ " id "+id);
		GymBranch b=branchService.updateBranch(branch,id);
		return new BranchDTO<>(HttpStatus.OK,"Branch updated successfully", b);
	}

	@DeleteMapping("/delete/{id}")
	public  BranchDTO<?> deleteBranch(@PathVariable int id) {
		System.out.println("in delete batch "+id);
		String deleteBranch=branchService.deleteBranch(id);
		return new BranchDTO<>(HttpStatus.OK, "branch deleted successfully", deleteBranch);
	}

}
