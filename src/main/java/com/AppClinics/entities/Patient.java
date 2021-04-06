package com.AppClinics.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String surname;
	private String email;
	private Integer phone;
	private String direction;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birthdate;

	private Integer age;

	@OneToOne
	Therapist therapist;

	@OneToOne
	ClinicHistory history;
	@OneToOne
	Treatment treatament;
	@OneToOne
	Derivation derivation;
	@OneToOne
	Turn turn;

	public Patient(String name, String surname, Integer age, Integer phone, String email, String direction,
			Date birthdate) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.direction = direction;
		this.birthdate = birthdate;
		this.history = new ClinicHistory();
		this.therapist = new Therapist();
		this.derivation = new Derivation();
		this.treatament = new Treatment();
		this.turn = new Turn();
	}

}
