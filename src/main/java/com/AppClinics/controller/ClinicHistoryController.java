package com.AppClinics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppClinics.repositories.ClinicHistoryRepository;

@RestController
@RequestMapping(value = "/api/ClinicHistory")
public class ClinicHistoryController {

	ClinicHistoryRepository repo;

	@Autowired
	public ClinicHistoryController(ClinicHistoryRepository repo) {
		this.repo = repo;
	}
}