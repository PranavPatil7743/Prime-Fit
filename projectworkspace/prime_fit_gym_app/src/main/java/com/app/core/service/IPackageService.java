package com.app.core.service;

import java.util.List;

import com.app.core.pojos.Package;

public interface IPackageService {
	
	// to get all the packages
	List<Package> getAllPackages();
	
	//add new package
	Package addNewPackage(Package p);
	
	//edit package details
	Package updatePackage(Package p,int id);
	
	//delete package
	String deletePackage(int packageId);
	
	//get package by Id
	Package getPackageDetails(int packageId);

}
