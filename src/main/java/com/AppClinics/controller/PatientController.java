package com.AppClinics.controller;

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
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	PatientRepository repo;

	@GetMapping(value = "/")
	public ResponseEntity<List<Patient>> getPatients() {
		return new ResponseEntity<List<Patient>>((List<Patient>) repo.findAll(), HttpStatus.OK);
	}

	// public Class Wrapper() {

	// }

	@PostMapping(value = "/")
	public ResponseEntity<Patient> savePatients(@PathParam(value = "name") String name,
			@PathParam(value = "surname") String surname, @PathParam(value = "age") int age,
			@PathParam(value = "phone") int phone) {

		// Wrapper wrapper = new Wrapper();

		Patient patient = new Patient(name, surname, 0, 0);
		patient.setName(name);
		patient.setSurname(surname);
		patient.setAge(age);
		patient.setTelephone(phone);

		repo.save(patient);

		return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);

	}

}
