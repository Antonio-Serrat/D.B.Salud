package com.AppClinics.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Turn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Patient patient;
	private Date fecha;

	public Turn() {

	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
