package com.AppClinics.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Therapists")
public class Therapist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String specialty;
	private String email;
	private int tlf;
	private int dni;

	@OneToOne
	private Agenda agenda;
	@OneToOne
	private Account account;
	// @ManyToOne
	// private Patient patient;
	@OneToMany
	public List<Turn> turnList;
	@OneToMany
	public List<Patient> patientsList;

	public Therapist(Account account) {
		this.getAccount();
	}

	public Therapist(String name, String speciality, String email, int dni, int tlf, Agenda agenda) {
		this.name = name;
		this.specialty = speciality;
		this.email = email;
		this.dni = dni;
		this.tlf = tlf;
		this.agenda = agenda;
		this.patientsList = new ArrayList<>();
		this.turnList = new ArrayList<>();
	}

	public List<Patient> getPatientsList() {
		return patientsList;
	}

	public void setPatientsList(Patient patient) {
		patientsList.add(patient);
	}

	public List<Turn> getTurnList() {
		return turnList;
	}

	public void setTurnList(Turn turn) {
		turnList.add(turn);
	}

}
