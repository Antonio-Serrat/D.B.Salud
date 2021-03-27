package com.AppClinics.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppClinics.entities.Account;
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
			@PathParam(value = "password") String password) {

		Account account = new Account();
		account.setName(name);
		account.setPassword(password);

		repo.save(account);

		return new ResponseEntity<Account>(account, HttpStatus.CREATED);

	}

	@DeleteMapping(value = "/")
	public ResponseEntity<List<Account>> deleteAccount(@PathParam(value = "id") Long id) {

		repo.deleteById(id);

		return new ResponseEntity<List<Account>>(HttpStatus.OK);
	}
}
