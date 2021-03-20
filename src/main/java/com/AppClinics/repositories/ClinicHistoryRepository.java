package com.AppClinics.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.ClinicHistory;

@Repository
@Transactional
public interface ClinicHistoryRepository extends CrudRepository<ClinicHistory, Long> {

}
