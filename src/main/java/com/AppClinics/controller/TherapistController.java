package com.AppClinics.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.AppClinics.entities.Patient;
import com.AppClinics.entities.Therapist;
import com.AppClinics.repositories.AccountRepository;
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
	private AccountRepository repoAcc;

	@Autowired
	private ClinicHistoryRepository repoHistory;

	@Autowired
	public TherapistController(TherapistRepository repo, PatientRepository repoPatient, TurnRepository repoTurn,
			AgendaRepository repoAgenda, AccountRepository repoAcc) {

		this.repo = repo;
		this.repoPatient = repoPatient;
		this.repoTurn = repoTurn;
		this.repoAgenda = repoAgenda;
		this.repoAcc = repoAcc;

	}

	@GetMapping(value = "/homeTh")
	public String home(Model model) {

		return "homeTh";
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public String me(Model model) {

		return "me";
	}

	@RequestMapping(value = "/formularyPatient")
	public String formularyPatient(@ModelAttribute Therapist therapist, Model model) {

		Patient patient = new Patient();
		patient.setBirthdate(new Date());

		Long id = therapist.getId();

		therapist = repo.findById(id).get();
		List<Patient> patients = new ArrayList<>();
		therapist.setPatients(patients);

		therapist.patients.add(patient);
		repo.save(therapist);

		model.addAttribute("therapist", therapist);

		model.addAttribute("patient", patient);

		return "formularyPatient";
	}

	@RequestMapping(value = "/formPatient", method = { RequestMethod.POST, RequestMethod.PUT })
	public String savePatient(@ModelAttribute Therapist therapist, @RequestAttribute(value = "id") Long id,
			@ModelAttribute Patient patient, @RequestParam(value = "name") String name,
			@RequestParam(value = "surname") String surname, @RequestParam(value = "age") Integer age,
			@RequestParam(value = "phone") Integer phone, @RequestParam(value = "email") String email, Model model)
			throws ParseException {
		therapist = repo.findById(id).get();

		List<Patient> patients = new ArrayList<>();
		therapist.setPatients(patients);

		patient.setName(name);
		patient.setSurname(surname);
		patient.setAge(age);
		patient.setEmail(email);
		patient.setPhone(phone);
		patient.setTherapist(therapist);
		repoPatient.save(patient);

		model.addAttribute("patient", patient);
		model.addAttribute("therapist", therapist);
		return "redirect:/api/therapist/patients";
	}

	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public String patientsList(Therapist therapist, Model model) {

		model.addAttribute("patients", repoPatient.findAll());
		return "patients";
	}

	@PostMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {

		repoPatient.deleteById(id);

		return "redirect:/api/therapist/patients";

	}

	@RequestMapping(value = "/agenda", method = RequestMethod.GET)
	public String agenda(Model model) {

		return "agenda";
	}
}
