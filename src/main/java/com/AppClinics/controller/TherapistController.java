package com.AppClinics.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AppClinics.entities.Therapist;
import com.AppClinics.repositories.TherapistRepository;

@Controller
@RequestMapping(value = "/api/therapist")
public class TherapistController {

	TherapistRepository repo;

	@Autowired
	public TherapistController(TherapistRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Therapist>> newTherapist() {
		return new ResponseEntity<List<Therapist>>((List<Therapist>) repo.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = "/")
	public ResponseEntity<Therapist> saveTherapist(@PathParam(value = "name") String name,
			@PathParam(value = "surname") String surname, @PathParam(value = "specialty") String specialty,
			@PathParam(value = "tlf") Long tlf, @PathParam(value = "email") String email,
			@PathParam(value = "dni") Long dni) {

		Therapist therapist = new Therapist();
		therapist.setName(name);
		therapist.setSurname(surname);
		therapist.setSpecialty(specialty);
		therapist.setTlf(tlf);
		therapist.setEmail(email);
		therapist.setDni(dni);

		repo.save(therapist);

		return new ResponseEntity<Therapist>(therapist, HttpStatus.CREATED);
	}

	@PostMapping(value = "/patients")
	public String addPatient() {

		return null;
	}
}
