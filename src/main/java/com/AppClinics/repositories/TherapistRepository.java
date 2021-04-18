package com.AppClinics.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Patient;
import com.AppClinics.entities.Therapist;

@Repository
@Transactional
public interface TherapistRepository extends CrudRepository<Therapist, Long> {

	public default Therapist getPatients(List<Patient> patients) {

		return getPatients(patients);
	}
}