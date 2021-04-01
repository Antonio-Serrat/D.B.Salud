package com.AppClinics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AppClinics.repositories.AccountRepository;

@Controller
@RequestMapping(value = "/api/accounts")
public class AccountController {

	AccountRepository repo;

	public AccountController(AccountRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/homeTh")
	public String home() {

		return "homeTh";
	}

	@GetMapping(value = "/me")
	public String me() {

		return "me";
	}

}
