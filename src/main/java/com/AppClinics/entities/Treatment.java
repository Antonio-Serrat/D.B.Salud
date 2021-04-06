package com.AppClinics.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Treatment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Patient patient;
	private Date date;
	private String prescription;
	private String evolution;
	private String observations;

	public Treatment(Patient patient, String prescription, String evolution, String observations, Date date) {
		this.date = date;
		this.patient = patient;
		this.prescription = prescription;
		this.evolution = evolution;
		this.observations = observations;

	}

}
