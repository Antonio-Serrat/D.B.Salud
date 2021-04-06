package com.AppClinics.entities;

import java.io.Serializable;
import java.time.Instant;

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
public class Turn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Patient patient;
	@OneToOne
	private Agenda agenda;
	private Instant fecha;

	public Turn(Patient patient, Instant fecha, Agenda agenda) {
		this.patient = patient;
		this.fecha = fecha;
		this.agenda = agenda;

	}

}
