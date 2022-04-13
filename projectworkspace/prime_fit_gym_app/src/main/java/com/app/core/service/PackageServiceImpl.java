package com.app.core.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.core.dao.PackageRepository;
import com.app.core.pojos.Package;

@Service
@Transactional
public class PackageServiceImpl implements IPackageService {
	
	@Autowired
	private PackageRepository packageRepo;

	@Override
	public List<Package> getAllPackages() {
		//to return all the packages 
		
		return packageRepo.findAll();
	}

	@Override
	public Package addNewPackage(Package p) {
		// TODO Auto-generated method stub
		return packageRepo.save(p);
	}

	@Override
	public Package updatePackage(Package p,int id) {
		// TODO Auto-generated method stub
		Package pack=packageRepo.getById(id);
		pack.setPackageName(p.getPackageName());
		pack.setPackagePrice(p.getPackagePrice());
		pack.setPackageDescription(p.getPackageDescription());
		return packageRepo.save(pack);
	}

	@Override
	public String deletePackage(int packageId) {
		// TODO Auto-generated method stub
		packageRepo.deleteById(packageId);
		
		return "Package with ID "+packageId+ " deleted successfully";
	}

	@Override
	public Package getPackageDetails(int packageId) {
		// TODO Auto-generated method stub
		return packageRepo.findById(packageId)
				.orElseThrow(() -> new NoSuchElementException("Package by Id "+packageId+" not found"));
	}

}
