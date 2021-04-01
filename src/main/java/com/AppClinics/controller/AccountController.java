package com.AppClinics.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AppClinics.entities.Account;
import com.AppClinics.repositories.AccountRepository;

@Controller
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

	@GetMapping(value = "/Me{Therapist_id}")
	public String home(@PathParam(value = "id") Long id) {

		return "home";
	}

	@DeleteMapping(value = "/delall")
	public ResponseEntity<List<Account>> deleteAll() {

		repo.deleteAll();

		return new ResponseEntity<List<Account>>(HttpStatus.OK);

	}

}
