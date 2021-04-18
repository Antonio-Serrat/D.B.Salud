package com.AppClinics.entities;

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

@Entity
@Data
@Table(name = "Roles")
@AllArgsConstructor
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@Cascade(CascadeType.ALL)
	private Account account;

	private String rol;

	public Roles() {

	}

}
