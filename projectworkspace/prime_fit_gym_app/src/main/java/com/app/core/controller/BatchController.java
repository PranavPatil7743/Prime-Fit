package com.app.core.controller;

import java.util.List;

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

import com.app.core.dto.BatchDTO;
import com.app.core.dto.ResponseDTO;
import com.app.core.pojos.Batch;
import com.app.core.pojos.User;
import com.app.core.service.IBatchService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/batches")
public class BatchController {
	
	@Autowired
	private IBatchService batchService;
	
	public BatchController() {
		// TODO Auto-generated constructor stub
		System.out.println("In constructor of "+getClass());
	}
	
	@GetMapping("/batch")
	public BatchDTO<?> getAllBatches(){
		System.out.println("in get all batches");
		return  new BatchDTO<>(HttpStatus.OK,"Batches Found ", batchService.getAllBatches());
	}
	
	@PostMapping("/add/{branchBranchId}")
	public  BatchDTO<?> addBatch(@RequestBody Batch batch,@PathVariable int branchBranchId) {
		System.out.println("In add batch "+batch+ " batchBranchId "+branchBranchId);
		Batch b=batchService.addNewBatch(batch,branchBranchId);
		return new BatchDTO<>(HttpStatus.OK,"Batch added successfully", b);
	}
	
	@GetMapping("/batch/{id}")
	public ResponseEntity<?> getBatch(@PathVariable int id) {
		System.out.println("In get batch "+id);
		return  new ResponseEntity<>(batchService.getBatchDetails(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public  BatchDTO<?> updateBatch(@RequestBody Batch batch,@PathVariable int id) { 
		System.out.println("in update batch "+batch+" id "+id);
		Batch b= batchService.updateBatch(batch,id);
		return new BatchDTO<>(HttpStatus.OK,"Batch updated successfully", b);
	}

	@DeleteMapping("/delete/{id}")
	public  BatchDTO<?> deleteBatch(@PathVariable int id) {
		System.out.println("in delete batch "+id);
		String b=batchService.deleteBatch(id);
		return new BatchDTO<>(HttpStatus.OK,"Batch deleted successfully", b);
	}
	
	@GetMapping("/batchesbyid/{id}")
	public ResponseDTO<?> getBatchesByBranchId(@PathVariable int id){
		System.out.println("In get Batches by branch id "+id);
		List<Batch> batches=batchService.getBatchesByBranchId(id);
		return new ResponseDTO<>(HttpStatus.OK,"All users of the branch id "+id,batches );
		
		
	}
	
	

}
