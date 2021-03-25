package com.AppClinics.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Accounts")

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String password;
	private String name;

	@OneToOne
	private Therapist therapist;
	@OneToOne
	private Admin admin;

	public Account(String name, String password) {
		this.password = password;
		this.name = name;
	}

	public Account(String name, String password, Therapist therapist) {
		this(name, password);
		this.therapist = therapist;
	}

	public Account(String name, String password, Admin admin) {
		this(name, password);
		this.admin = admin;
	}

	public boolean isTHerapist() {
		return therapist != null;
	}

	public boolean isAdmin() {
		return admin != null;
	}
}
