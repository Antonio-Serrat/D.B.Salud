package com.AppClinics.controller;

import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class AppPrincipalController {

	@GetMapping(value = "/home")
	public String home() {
		return "home";
	}

	@GetMapping(value = "/signup")
	public String saveAccount(Model model) throws ParseException {

		return "signup";

	}

}
