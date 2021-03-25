package com.AppClinics.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Derivation;

@Repository
@Transactional
public interface DerivationRepository extends CrudRepository<Derivation, Long> {

}
