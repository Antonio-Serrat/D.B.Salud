package com.AppClinics.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.core.sym.Name;

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

	@OneToOne
	private Therapist Therapist;
	@OneToOne
	private Admin Admin;
	private String Name;
	private String Password; 
	private Boolean ADMIN = true;
	
	public Account(String Name, String Password) {
		if (ADMIN != false) {
			Account acA = new Account(Name, Password);
			Admin = new Admin();
			Admin.setName(Name);
			Admin.setAccount(acA);
		}else{
			Account acT = new Account(Name, Password);

			Therapist = new Therapist();
			Therapist.setAccount(acT);
		}
	}



	public boolean isADMIN() {
		return ADMIN;
	}

	public void setADMIN(boolean aDMIN) {
		this.ADMIN = aDMIN;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Therapist getTherapist() {
		return Therapist;
	}

	public void setTherapist(Therapist Therapist) {
		this.Therapist = Therapist;
	}

	public Admin getAdmin() {
		return Admin;
	}

	public void setAdmin(Admin Admin) {
		this.Admin = Admin;
	}

}
