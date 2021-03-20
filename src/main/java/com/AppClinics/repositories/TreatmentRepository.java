package com.AppClinics.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Treatment;

@Repository
@Transactional
public interface TreatmentRepository extends CrudRepository<Treatment, Long> {

}
