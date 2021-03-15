package com.AppClinics.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class ClinicHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Patient patient;
	private String formulary;
	private String Observations;

	public ClinicHistory() {

	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getFormulary() {
		return formulary;
	}

	public void setFormulary(String formulary) {
		this.formulary = formulary;
	}

	public String getObservations() {
		return Observations;
	}

	public void setObservations(String observations) {
		Observations = observations;
	}

}
