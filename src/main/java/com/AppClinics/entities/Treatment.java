package com.AppClinics.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Treatment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Patient patient;
	private Date Date;
	private String Prescription;
	private String Evolution;
	private String Observations;

	public Treatment() {

	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getPrescription() {
		return Prescription;
	}

	public void setPrescription(String prescription) {
		Prescription = prescription;
	}

	public String getEvolution() {
		return Evolution;
	}

	public void setEvolution(String evolution) {
		Evolution = evolution;
	}

	public String getObservations() {
		return Observations;
	}

	public void setObservations(String observations) {
		Observations = observations;
	}

}
