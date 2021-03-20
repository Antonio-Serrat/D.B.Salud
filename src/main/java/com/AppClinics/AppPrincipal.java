package com.AppClinics;

//import java.util.List;
//import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.AppClinics.entities.Account;
import com.AppClinics.entities.Admin;

@SpringBootApplication
public class AppPrincipal {
	public static void main(String[] args) {
		SpringApplication.run(AppPrincipal.class, args);
	}

	@SuppressWarnings("null")
	public void newAdmin() {
		String name = "root";
		String pass = "PASSroot4";

		Account aca = new Account(name, pass);
		Admin root = new Admin(name, aca);

		root.setId((long) 1111);
		aca.setAdmin(root);
	}
}
