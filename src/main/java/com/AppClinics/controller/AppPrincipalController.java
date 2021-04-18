package com.AppClinics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.AppClinics.entities.Account;
import com.AppClinics.entities.Roles;
import com.AppClinics.entities.Therapist;
import com.AppClinics.repositories.AccountRepository;
import com.AppClinics.repositories.AgendaRepository;
import com.AppClinics.repositories.RolesRepository;
import com.AppClinics.repositories.TherapistRepository;
import com.AppClinics.services.AccountService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping(value = "/")
public class AppPrincipalController {

	private final AccountService userService;

	@Autowired
	PasswordEncoder bcrypt;
	@Autowired
	private TherapistRepository repoTherapist;
	@Autowired
	private AgendaRepository repoAgenda;
	@Autowired
	private AccountRepository repoAccount;
	@Autowired
	private RolesRepository repoRol;

	@GetMapping(value = "/")
	public String Welcome() {
		return "index";
	}

	@GetMapping(value = "/signup")
	public String signup(Account account, Model model) {

		account = new Account();
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
			@RequestParam(value = "phone", required = true) String phone, Model model) {

		String pass = bcrypt.encode(account.getPassword());

		Roles rol = new Roles();
		rol.setAccount(account);
		rol.setRol("USER");
		account.setRoles(rol);
		repoRol.save(rol);

		account.setEmail(email);
		account.setPassword(pass);

		therapist.setAccount(account);
		therapist.setName(name);
		therapist.setSurname(surname);
		therapist.setSpecialty(specialty);
		therapist.setDni(dni);
		therapist.setPhone(phone);
		therapist.setEmail(email);
		therapist.getPatients();

		repoTherapist.save(therapist);
		account.setTherapist(therapist);
		repoAccount.save(account);

		model.addAttribute("rol", rol);
		model.addAttribute("therapist", therapist);
		model.addAttribute("account", account);
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login() {

		return "/login";
	}

	@GetMapping(value = "/about")
	public String about(Model model) throws ParseException {
		return "about";
	}

	// @RequestMapping(value = "/login" ,method = {RequestMethod.})
}
