package com.AppClinics.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Admin;

@Repository
@Transactional
public interface AdminRepository extends CrudRepository<Admin, Long> {

	// public findById(Long id);
}
