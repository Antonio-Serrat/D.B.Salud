package com.AppClinics.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Therapist therapist;
	private Calendar calendar;
	@OneToOne
	private Turn turn;

	public Agenda(Calendar calendar, Turn turn, Therapist therapist) {
		this.getCalendar();
		this.getTherapist();
		this.getTurn();
	}

}
