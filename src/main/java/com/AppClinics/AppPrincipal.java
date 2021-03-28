package com.AppClinics;

//import java.util.List;
//import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppPrincipal {
	public static void main(String[] args) {
		SpringApplication.run(AppPrincipal.class, args);
	}
	/*
	 * public void newAdmin() { String name = "root"; String pass = "PASSroot4";
	 * 
	 * Account aca = new Account(); Admin root = new Admin();
	 * 
	 * root.setId((long) 1111); root.setAccount(aca); aca.setAdmin(root);
	 * aca.setName(name); aca.setPassword(pass);
	 * 
	 * }
	 */
}
