package com.AppClinics.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Derivation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	public static List<Therapist> therapist;
	private String obs;

	public Derivation() {
		this.therapist = new ArrayList<>();
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
