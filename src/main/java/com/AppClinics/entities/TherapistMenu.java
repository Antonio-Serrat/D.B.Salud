package com.AppClinics.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TherapistMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date Agenda;
	public List<Patient> patient;
	private List<Turn> Date, turn;

	public TherapistMenu(int i, String string) {
		this.patient = new ArrayList<>();
		this.turn = new ArrayList<>();

	}

	public Date getAgenda() {
		return Agenda;
	}

	public void setAgenda(Date agenda) {
		Agenda = agenda;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	public List<Turn> getDate() {
		return Date;
	}

	public void setDate(List<Turn> date) {
		Date = date;
	}

	public List<Turn> getTurn() {
		return turn;
	}

	public void setTurn(List<Turn> turn) {
		this.turn = turn;
	}

}
