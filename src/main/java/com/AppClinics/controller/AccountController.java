package com.AppClinics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AppClinics.repositories.AccountRepository;

@Controller
@RequestMapping(value = "/api/accounts")
public class AccountController {

	@Autowired
	AccountRepository repo;

	public AccountController(AccountRepository repo) {
		this.repo = repo;
	}

}
