package com.AppClinics.RESTController;

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
public class AccountRest {

	AccountRepository repo;

	public AccountRest(AccountRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/get")
	public ResponseEntity<List<Account>> getAccounts() {
		return new ResponseEntity<List<Account>>((List<Account>) repo.findAll(), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delAllAccounts")
	public ResponseEntity<List<Account>> deleteAll() {

		repo.deleteAll();

		return new ResponseEntity<List<Account>>(HttpStatus.OK);

	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Account> deleteAccount(@PathParam(value = "id") Long id) {

		repo.findAll();
		repo.deleteById(id);

		return new ResponseEntity<Account>(HttpStatus.OK);
	}
}
