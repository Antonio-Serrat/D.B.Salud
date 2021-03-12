package com.AppClinics.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private Calendar Calendar;

	public Calendar getCalendar() {
		return Calendar;
	}

	public void setCalendar(Calendar calendar) {
		Calendar = calendar;
	}

}
