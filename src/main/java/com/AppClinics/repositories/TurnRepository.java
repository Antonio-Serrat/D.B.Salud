package com.AppClinics.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Turn;

@Repository
@Transactional
public interface TurnRepository extends CrudRepository<Turn, Long> {

}
