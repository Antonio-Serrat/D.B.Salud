package com.AppClinics.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Agenda;

@Repository
@Transactional
public interface AgendaRepository extends CrudRepository<Agenda, Long> {

}
