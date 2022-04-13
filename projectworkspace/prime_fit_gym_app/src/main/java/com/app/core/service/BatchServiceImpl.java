package com.app.core.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.core.dao.BatchRepository;
import com.app.core.dao.GymBranchRepository;
import com.app.core.pojos.Batch;
import com.app.core.pojos.GymBranch;
@Service
@Transactional
public class BatchServiceImpl implements IBatchService {
	
	@Autowired
	private BatchRepository batchRepo;
	
	@Autowired
	private GymBranchRepository branchRepo;
	

	@Override
	public List<Batch> getAllBatches() {
		// TODO Auto-generated method stub
		return batchRepo.findAll();
	}

	@Override
	public Batch addNewBatch(Batch batch,int branchBranchId) {
		// TODO Auto-generated method stub
		GymBranch b=branchRepo.findById(branchBranchId).get();
		batch.setBranch(b);		
		return batchRepo.save(batch);
	}

	@Override
	public Batch updateBatch(Batch batch,int id) {
		// TODO Auto-generated method stub
		Batch b=batchRepo.findById(id).get();
		b.setBatchTime(batch.getBatchTime());
		b.setBatchType(batch.getBatchType());
		
		return batchRepo.save(b);
		
	}

	@Override
	public String deleteBatch(int batchId) {
		// TODO Auto-generated method stub
		batchRepo.deleteById(batchId);
		return "Batch with Id "+batchId+" deleted successfully";
	}

	@Override
	public Batch getBatchDetails(int batchId) {
		// TODO Auto-generated method stub
		return batchRepo.findById(batchId)
				.orElseThrow(()-> new NoSuchElementException("Batch with id "+batchId+ "not found"));
	}

	@Override
	public List<Batch> getBatchesByBranchId(int id) {
		// TODO Auto-generated method stub
		GymBranch branch= branchRepo.findById(id).get();
		
		return batchRepo.getBatchByBranchId(branch);
	}

}
