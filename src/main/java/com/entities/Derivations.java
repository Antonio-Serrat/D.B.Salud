package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity

public class Derivations implements Serializable {
	private static final long serialVersionUID = 1L;

	public static List<Therapist> therapist;
	private String obs;
	
	public Derivations() {
		this.therapist = new ArrayList<>();
	}


	

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	
	
	
	
	
	
}
