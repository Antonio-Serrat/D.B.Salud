package com.AppClinics.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class ClinicHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String formulary;
	private String Observations;

}
