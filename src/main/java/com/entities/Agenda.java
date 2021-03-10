package com.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;


@Entity

public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	private Calendar Calendar;

	public Calendar getCalendar() {
		return Calendar;
	}

	public void setCalendar(Calendar calendar) {
		Calendar = calendar;
	}
	

	
}
