package com.AppClinics.RESTController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppClinics.repositories.ClinicHistoryRepository;

@RestController
@RequestMapping(value = "/api/ClinicHistory")
public class ClinicHistoryRest {

	ClinicHistoryRepository repo;

	@Autowired
	public ClinicHistoryRest(ClinicHistoryRepository repo) {
		this.repo = repo;
	}
}