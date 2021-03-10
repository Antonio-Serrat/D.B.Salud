package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity

public class TherapistMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date Agenda;
	public List<Patients> patient;
	private List<Turn> Date, turn;
	
	public TherapistMenu(int i, String string) {
		this.patient = new ArrayList<>();
		this.turn = new ArrayList<>();
		
	}


	
}
