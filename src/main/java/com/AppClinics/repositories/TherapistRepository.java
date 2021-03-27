package com.AppClinics.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Therapist;

@Repository

public interface TherapistRepository extends CrudRepository<Therapist, Long> {

}