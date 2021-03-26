package com.AppClinics.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppClinics.entities.Account;
import com.AppClinics.entities.Therapist;
import com.AppClinics.repositories.AccountRepository;

@RestController
@RequestMapping(value = "/api/accounts")
public class AccountController {

	AccountRepository repo;

	public AccountController(AccountRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Account>> getAccounts() {
		return new ResponseEntity<List<Account>>((List<Account>) repo.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = "/")
	public ResponseEntity<Account> saveAccount(@PathParam(value = "name") String name,
			@PathParam(value = "password") String password, @PathParam(value = "therapist") Therapist therapist) {

		Account account = new Account(name, password, therapist);
		account.setName(name);
		account.setPassword(password);
		account.setTherapist(therapist);

		repo.save(account);

		return new ResponseEntity<Account>(account, HttpStatus.CREATED);

	}

}
