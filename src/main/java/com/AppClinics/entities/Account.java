package com.AppClinics.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "Accounts")
@AllArgsConstructor
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;
	private String password;

	@OneToOne
	@Cascade(CascadeType.ALL)
	private Therapist therapist;

	@OneToOne
	@Cascade(CascadeType.ALL)
	private Roles roles;

	// private String roless;

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + email + ", password=" + password + "]";
	}

	public Account() {

	}

	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Account(String email, String password, Therapist therapist, Roles roles) {
		this(email, password);
		this.therapist = therapist;
		this.roles = roles;

	}

}
