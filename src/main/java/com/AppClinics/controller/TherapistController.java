package com.AppClinics.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.AppClinics.entities.Patient;
import com.AppClinics.entities.Therapist;
import com.AppClinics.repositories.AgendaRepository;
import com.AppClinics.repositories.ClinicHistoryRepository;
import com.AppClinics.repositories.PatientRepository;
import com.AppClinics.repositories.TherapistRepository;
import com.AppClinics.repositories.TurnRepository;

@Controller
@RequestMapping(value = "/api/therapist")
public class TherapistController {

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat();
	@Autowired
	private TherapistRepository repo;
	@Autowired
	private PatientRepository repoPatient;
	@Autowired
	private TurnRepository repoTurn;
	@Autowired
	private AgendaRepository repoAgenda;

	@Autowired
	private ClinicHistoryRepository repoHistory;

	@Autowired
	public TherapistController(TherapistRepository repo, PatientRepository repoPatient, TurnRepository repoTurn,
			AgendaRepository repoAgenda) {

		this.repo = repo;
		this.repoPatient = repoPatient;
		this.repoTurn = repoTurn;
		this.repoAgenda = repoAgenda;

	}

	@RequestMapping(value = "/formularyPatient")
	public String formularyPatient(Model model) {

		Patient patient = new Patient();
		patient.setBirthdate(new Date());
		model.addAttribute("patient", patient);

		return "formularyPatient";
	}

	@RequestMapping(value = "/formPatient", method = { RequestMethod.POST, RequestMethod.PUT })
	public String savePatient(@ModelAttribute Therapist therapist, @ModelAttribute Patient patient,
			@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname,
			@RequestParam(value = "age") Integer age, @RequestParam(value = "phone") Integer phone,
			@RequestParam(value = "email") String email, Model model) throws ParseException {

		Patient p = new Patient();

		p.setName(name);
		p.setSurname(surname);
		p.setAge(age);
		p.setEmail(email);
		p.setPhone(phone);

		repoPatient.save(p);

		model.addAttribute("patient", patient);

		return "redirect:/api/therapist/patients";
	}

	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public String patientsList(Model model) {
		model.addAttribute("patients", repoPatient.findAll());
		return "patients";
	}

	@PostMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {

		repoPatient.findById(id);

		repoPatient.deleteById(id);

		return "patients";

	}

}
