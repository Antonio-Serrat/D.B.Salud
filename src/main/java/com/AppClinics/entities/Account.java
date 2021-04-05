package com.AppClinics.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Accounts")

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;
	private String password;

	@OneToOne
	private Therapist therapist;

	@OneToOne
	private Admin admin;

	public Account() {

	}

	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Account(String email, String password, Therapist therapist) {
		this(email, password);
		// this.therapist = therapist;
	}

	public Account(String email, String password, Admin admin) {
		this(email, password);
		this.admin = admin;
	}

	public boolean isTHerapist() {
		return therapist.getId() != null;
	}

	public boolean isAdmin() {
		return admin.getName() != null;
	}

}
