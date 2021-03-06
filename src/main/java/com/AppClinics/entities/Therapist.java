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
	private String tlf;
	private String dni;
	private Agenda agenda;

	@OneToOne
	private Account account;
	// @ManyToOne
	// private Patient patient;
	@OneToMany
	public List<Turn> turnList;
	@OneToMany
	public List<Patient> patientsList;

	public Therapist(){
		
	}
	public Therapist(String name, String speciality, String email, String dni, String tlf) {
		this.name = name;
		this.specialty = speciality;
		this.email = email;
		this.dni = dni;
		this.tlf = tlf;
		this.patientsList = new ArrayList<>();
		this.turnList = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	/*
	 * public Patient getPatient() { return patient; }
	 * 
	 * public void setPatient(Patient patient) { this.patient = patient; }
	 */

}
