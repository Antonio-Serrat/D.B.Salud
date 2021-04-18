package com.AppClinics.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Therapist;

@Repository
@Transactional
public interface TherapistRepository extends CrudRepository<Therapist, Long> {

	Therapist findByEmail(String email);

}