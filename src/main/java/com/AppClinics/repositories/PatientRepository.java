package com.AppClinics.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Patient;

@Repository
@Transactional
public interface PatientRepository extends CrudRepository<Patient, Long> {

//	public default Patient findByTherapistId(Long id) {
//		Therapist therapist;
//		therapist.getId();	
//		
//	}
}