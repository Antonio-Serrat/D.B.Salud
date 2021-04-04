package com.AppClinics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AppClinics.repositories.PatientRepository;

@Controller
@RequestMapping(value = "/api/patients")
public class PatientController {

	PatientRepository repo;

	@Autowired
	public PatientController(PatientRepository repo) {

		this.repo = repo;
	}

	@GetMapping(value = "/all")
	public String patients() {
		repo.findAll();

		return "patients";

	}
}
