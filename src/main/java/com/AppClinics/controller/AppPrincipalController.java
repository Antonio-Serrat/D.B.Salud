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
import com.AppClinics.entities.Therapist;
import com.AppClinics.repositories.AccountRepository;
import com.AppClinics.repositories.AgendaRepository;
import com.AppClinics.repositories.PatientRepository;
import com.AppClinics.repositories.TherapistRepository;
import com.AppClinics.repositories.TurnRepository;

@Controller
@RequestMapping(value = "/")
public class AppPrincipalController {

	@Autowired
	private TherapistRepository repoTherapist;
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

		Therapist therapist = new Therapist();
		model.addAttribute("therapist", therapist);

		return "signup";

	}

	@RequestMapping(value = "/signUp", method = { RequestMethod.PUT, RequestMethod.POST })
	public String newAccount(@ModelAttribute Account account, @ModelAttribute Therapist therapist,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "surname", required = true) String surname,
			@RequestParam(value = "specialty", required = true) String specialty,
			@RequestParam(value = "dni", required = true) String dni,
			@RequestParam(value = "tlf", required = true) String tlf, Model model) {

		Account ac = new Account();
		Therapist th = new Therapist();
		ac.setEmail(email);
		ac.setPassword(password);
		ac.setTherapist(th);
		repoAccount.save(ac);
		model.addAttribute("account", account);

		th.setAccount(ac);
		th.setName(name);
		th.setSurname(surname);
		th.setSpecialty(specialty);
		th.setDni(dni);
		th.setTlf(tlf);
		th.setEmail(email);
		repoTherapist.save(th);
		model.addAttribute("therapist", therapist);

		return "redirect:/";
	}

	@GetMapping(value = "/login")
	public String login(@ModelAttribute Account account, @ModelAttribute Therapist therapist,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password, Model model) {

		repoAccount.findAll();

		if (account.getEmail() == email & account.getPassword() == password) {

			return "homeTh";
		}

		return "redirect=/";
	}

	@GetMapping(value = "/about")
	public String about(Model model) throws ParseException {
		return "about";
	}

	// @RequestMapping(value = "/login" ,method = {RequestMethod.})
}
