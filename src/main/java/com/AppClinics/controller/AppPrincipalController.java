package com.AppClinics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.AppClinics.entities.Account;
import com.AppClinics.repositories.AccountRepository;
import com.AppClinics.repositories.AgendaRepository;
import com.AppClinics.repositories.PatientRepository;
import com.AppClinics.repositories.TherapistRepository;
import com.AppClinics.repositories.TurnRepository;

@Controller
@RequestMapping(value = "/")
public class AppPrincipalController {

	@Autowired
	private TherapistRepository repo;
	@Autowired
	private PatientRepository repoPatient;
	@Autowired
	private TurnRepository repoTurn;
	@Autowired
	private AgendaRepository repoAgenda;
	@Autowired
	private AccountRepository repoAccount;

	@GetMapping(value = "/")
	public String Welcome() {
		return "index";
	}

	@GetMapping(value = "/signup")
	public String signup(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);

		return "signup";

	}

	@RequestMapping(value = "/signUp", method = { RequestMethod.PUT, RequestMethod.POST })
	public String newAccount(@ModelAttribute Account account, @RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, Model model) {

		account.setEmail(null);
		account.setPassword(null);
		repoAccount.save(account);
		model.addAttribute("account", account);

		return "index";
	}

	@GetMapping(value = "/about")
	public String about(Model model) throws ParseException {

		return "about";

	}

}
