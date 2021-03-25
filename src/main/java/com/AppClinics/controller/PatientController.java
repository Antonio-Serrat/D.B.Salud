package com.AppClinics.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppClinics.entities.Patient;
import com.AppClinics.repositories.PatientRepository;

@RestController
@RequestMapping(value = "/api/patients")
public class PatientController {

	PatientRepository repo;

	@Autowired
	public PatientController(PatientRepository repo) {

		this.repo = repo;
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Patient>> getPatients() {
		return new ResponseEntity<List<Patient>>((List<Patient>) repo.findAll(), HttpStatus.OK);
	}

	// public Class Wrapper() {

	// }

	@PostMapping(value = "/")
	public ResponseEntity<Patient> savePatients(@PathParam(value = "name") String name,
			@PathParam(value = "surname") String surname, @PathParam(value = "age") int age,
			@PathParam(value = "phone") int phone, @PathParam(value = "direction") String direction,
			@PathParam(value = "email") String email, @PathParam(value = "birthdate") Date birthdate) {

		// Wrapper wrapper = new Wrapper();

		Patient patient = new Patient(name, surname, phone, age, direction, email, birthdate);
		patient.setName(name);
		patient.setSurname(surname);
		patient.setAge(age);
		patient.setPhone(phone);
		patient.setDirection(direction);
		patient.setEmail(email);
		patient.setBirthdate(null);

		repo.save(patient);

		return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);

	}

}
