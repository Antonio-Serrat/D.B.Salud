package com.AppClinics.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter

public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Therapist therapist;
	private Calendar calendar;
	@ManyToOne
	private Turn turn;

	public Agenda() {

	}

	public Agenda(Therapist therapist) {
		this.getTherapist();
	}

	public Agenda(Calendar calendar, Turn turn, Therapist therapist) {
		this.calendar = calendar;

		this.turn = getTurn();
	}

}
