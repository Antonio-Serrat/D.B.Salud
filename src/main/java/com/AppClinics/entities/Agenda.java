package com.AppClinics.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Therapist therapist;
	private Calendar Calendar;
	@OneToOne
	private Turn turn;

	public Agenda() {

	}

	public Therapist getTherapist() {
		return therapist;
	}

	public void setTherapist(Therapist therapist) {
		this.therapist = therapist;
	}

	public Calendar getCalendar() {
		return Calendar;
	}

	public void setCalendar(Calendar calendar) {
		Calendar = calendar;
	}

}
