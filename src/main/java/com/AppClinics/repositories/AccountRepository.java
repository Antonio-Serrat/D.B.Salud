package com.AppClinics.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.AppClinics.entities.Account;

@Repository

public interface AccountRepository extends CrudRepository<Account, Long> {

	public Optional<Account> findByEmail(String email);
//	Account findByEmail(String email);
}
