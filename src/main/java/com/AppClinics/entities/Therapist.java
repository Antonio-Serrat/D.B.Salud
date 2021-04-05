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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Data;

@Data
@Entity
@Table(name = "Therapists")

public class Therapist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String surname;
	private String specialty;
	private String email;
	private Long tlf;
	private Long dni;

	@OneToOne
	@Cascade(CascadeType.ALL)
	private Agenda agenda;
	/*
	 * @OneToOne
	 * 
	 * @Cascade(CascadeType.ALL) private Account account;
	 */
	@OneToMany
	public List<Turn> turns;

	/*
	 * @OneToMany public List<Patient> patients;
	 */
	public Therapist() {

	}

	public Therapist(List<Patient> patients, List<Turn> turns) {
		// this.patients = new ArrayList<>();
		this.turns = new ArrayList<>();
	}

	public Therapist(Account account) {

	}

	public Therapist(String name, String surname, String speciality, String email, Long dni, Long tlf, Agenda agenda) {
		this.name = name;
		this.specialty = speciality;
		this.email = email;
		this.dni = dni;
		this.tlf = tlf;
		this.agenda = agenda;
	}

	/*
	 * public List<Patient> getPatients() { return patients; }
	 * 
	 * public void setPatients(Patient patient) { patients.add(patient); }
	 */
	public List<Turn> getTurn() {
		return turns;
	}

	public void setTurn(Turn turn) {
		turns.add(turn);
	}

}
