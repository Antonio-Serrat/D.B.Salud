package com.AppClinics.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String user;
	private String pass;

	public Admin() {

	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		pass = pass;
	}

}
