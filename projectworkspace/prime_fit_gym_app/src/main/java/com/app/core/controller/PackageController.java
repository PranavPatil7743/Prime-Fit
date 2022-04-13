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

import com.app.core.dto.PackageDTO;
import com.app.core.pojos.Package;
import com.app.core.service.IPackageService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/packages")
public class PackageController {
	
	@Autowired
	private IPackageService packageService;
	 public PackageController() {
		 
	System.out.println("In constructor of "+getClass());
	}
	 
	 @GetMapping("/package")
	 public PackageDTO<?> getAllPackages(){
		 System.out.println("In get all packages ");
		 return new PackageDTO<>(HttpStatus.OK,"Packages Found",packageService.getAllPackages());
	 }
	 
	 @PostMapping("/add")
	 public PackageDTO<?> addPackage(@RequestBody Package p) {
		 System.out.println("In add package "+p);
		 Package pp=packageService.addNewPackage(p);
		 return new PackageDTO<>(HttpStatus.OK,"Package added Successfully",pp);
	 }
	 
	 @GetMapping("/package/{id}")
	 public ResponseEntity<?> getPackage(@PathVariable int id) {
		 System.out.println("in get package");
		 return new ResponseEntity<>(packageService.getPackageDetails(id),HttpStatus.OK);
	 }
	 
	 
	 @PutMapping("/update/{id}")
	 public PackageDTO<?> updatePackage(@RequestBody Package p,@PathVariable int id) {
		 System.out.println("in update package"+p+ " id "+id);
		 Package pp=packageService.updatePackage(p,id);
		 return new PackageDTO<>(HttpStatus.OK, "package updated successfully", pp);
	 }
	 
	 
	 @DeleteMapping("/delete/{id}")
	 public PackageDTO<?> deletePackage(@PathVariable int id) {
		 System.out.println("In delete package");
		 String deletePackage=packageService.deletePackage(id);
		 return new PackageDTO<>(HttpStatus.OK, "package deleted successfully", deletePackage);
	 }

}
