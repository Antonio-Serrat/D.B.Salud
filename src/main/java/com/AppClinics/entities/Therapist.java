package com.AppClinics.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Therapists")
public class Therapist implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String Name;
	private String Specialty;
	private String email;
	private String tlf;
	private String DNI;
	private Agenda agenda;

	@OneToMany
	public static List<Turn> turnList;
	@OneToMany
	public static List<Patient> patientsList;

	public Therapist(String name, String speciality, String email, String dni, String tlf) {
		this.Name = name;
		this.Specialty = speciality;
		this.email = email;
		this.DNI = dni;
		this.tlf = tlf;
		// this.accountsList = new ArrayList<>();
		this.patientsList = new ArrayList<>();
		this.turnList = new ArrayList<>();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSpecialty() {
		return Specialty;
	}

	public void setSpecialty(String specialty) {
		Specialty = specialty;
	}

	public static List<Patient> getPatientsList() {
		return patientsList;
	}

	public static void setPatientsList(Patient patient) {
		Therapist.patientsList.add(patient);
	}

	public static List<Turn> getTurnList() {
		return turnList;
	}

	public static void setTurnList(Turn turn) {
		Therapist.turnList.add(turn);
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

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	// public List<Accounts> getAccountsList() {
	// return accountsList;
	// }

	// public void setAccountList(Accounts accounts) {
	// this.accountsList.add(accounts);
	// }
//	public void newAccount(Accounts account) {
//		this.accountsList.add(account);
//	}

}
