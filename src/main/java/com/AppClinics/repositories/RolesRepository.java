package com.AppClinics.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Roles;

@Repository
@Transactional
public interface RolesRepository extends CrudRepository<Roles, Long> {

}
