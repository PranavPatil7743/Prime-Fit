package com.app.core.service;

import java.util.List;

import com.app.core.pojos.Batch;

public interface IBatchService {
	
	// get all active batches
	List<Batch> getAllBatches();
	
	//add new batch
	Batch addNewBatch(Batch batch,int batchBranchId);
	
	//update batch
	Batch updateBatch(Batch batch,int id);
	
	//delete batch
	String deleteBatch(int batchId);
	
	//get batch details by id
	Batch getBatchDetails(int batchId);
	
	List<Batch> getBatchesByBranchId(int id);

}
