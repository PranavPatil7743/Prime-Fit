package com.app.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.core.pojos.Package;
@Repository
public interface PackageRepository extends JpaRepository<Package, Integer> {

}
