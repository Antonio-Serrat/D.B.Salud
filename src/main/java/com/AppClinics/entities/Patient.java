package com.AppClinics.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String Name;
	private String Surname;
	private String Email;
	private int Phone;
	private String Direction;
	private Date Birthdate;
	private int Age;

	ClinicHistory History;
	Treatment treatament;
	Derivations derivations;
	Turn turn;

	public Patient(String Name, String Surname, int Age, int Phone) {
		this.Name = Name;
		this.Surname = Surname;
		this.Age = Age;
		this.Phone = Phone;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getTelephone() {
		return Phone;
	}

	public void setTelephone(int phone) {
		Phone = phone;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String direction) {
		Direction = direction;
	}

	public Date getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(Date birdathe) {
		Birthdate = birdathe;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

}
