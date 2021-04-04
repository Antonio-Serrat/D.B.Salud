package com.AppClinics.controller;

import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AppClinics.entities.ClinicHistory;
import com.AppClinics.entities.Patient;
import com.AppClinics.repositories.AgendaRepository;
import com.AppClinics.repositories.PatientRepository;
import com.AppClinics.repositories.TherapistRepository;
import com.AppClinics.repositories.TurnRepository;

@Controller
@RequestMapping(value = "/api/therapist")
public class TherapistController {

	TherapistRepository repo;
	PatientRepository repoPatient;
	TurnRepository repoTurn;
	AgendaRepository repoAgenda;

	@Autowired
	public TherapistController(TherapistRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/newPatients")
	public String newPatient() {

		return "newPatient";
	}

	@PostMapping(value = "/addPatient")
	public String savePatient(@PathParam(value = "name") String name, @PathParam(value = "surname") String surname,
			@PathParam(value = "age") Integer age, @PathParam(value = "phone") Integer phone,
			@PathParam(value = "email") String email, @PathParam(value = "birthdate") Date birthdate,
			@PathParam(value = "Clinic History") ClinicHistory history, Model model) {

		Patient patient = new Patient();
		patient.setName(name);
		patient.setSurname(surname);
		patient.setAge(age);
		patient.setBirthdate(birthdate);
		patient.setEmail(email);
		patient.setPhone(phone);
		patient.setHistory(history);

		model.addAttribute(patient);
		repoPatient.save(patient);

		return "patients";
	}

	@GetMapping(value = "/patients")
	public String patientsList(Model model) {
		model.addAttribute("patients", repoPatient.findAll());
		return "patients";
	}
}
