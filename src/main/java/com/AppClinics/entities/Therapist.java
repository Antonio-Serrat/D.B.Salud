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

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "Therapists")
@AllArgsConstructor

public class Therapist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	private String name;
	private String surname;
	private String specialty;
	private String email;
	private String phone;
	private String dni;

	@OneToOne
	@Cascade(CascadeType.ALL)
	private Agenda agenda;

	@OneToOne
	@Cascade(CascadeType.ALL)
	private Account account;

	@OneToMany
	public List<Turn> turns = new ArrayList<>();

	@OneToMany
	public List<Patient> patients = new ArrayList<>();

	public Therapist() {

	}

	public Therapist(String name, String surname, String speciality, String email, String dni, String phone,
			Agenda agenda) {
		this.name = name;
		this.surname = surname;
		this.specialty = speciality;
		this.email = email;
		this.dni = dni;
		this.phone = phone;
		this.agenda = agenda;
	}

	public Therapist(Account account) {

	}

}
