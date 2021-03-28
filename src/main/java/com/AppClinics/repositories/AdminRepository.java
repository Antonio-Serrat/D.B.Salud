package com.AppClinics.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

	// public findById(Long id);
}
