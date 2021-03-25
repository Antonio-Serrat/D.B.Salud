package com.AppClinics.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Account;

@Repository
@Transactional
public interface AccountRepository extends CrudRepository<Account, Long> {

}
