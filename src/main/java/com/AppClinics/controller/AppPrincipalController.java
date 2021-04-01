package com.AppClinics.controller;

import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class AppPrincipalController {

	@GetMapping(value = "/")
	public String Welcome() {
		return "index";
	}

	@GetMapping(value = "/signup")
	public String signup(Model model) throws ParseException {

		return "signup";

	}

	@GetMapping(value = "/about")
	public String about(Model model) throws ParseException {

		return "about";

	}

}
