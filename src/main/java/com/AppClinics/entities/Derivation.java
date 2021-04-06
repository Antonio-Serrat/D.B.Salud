package com.AppClinics.entities;

import java.io.Serializable;

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
public class Derivation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Therapist therapist;
	@OneToOne
	private Patient patient;
	private String observation;

	public Derivation(Patient patient, Therapist therapist, String observ) {
		this.patient = patient;
		this.therapist = therapist;
		this.observation = observ;

	}

}
