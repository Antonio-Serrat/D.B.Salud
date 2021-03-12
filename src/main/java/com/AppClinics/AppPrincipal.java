package com.AppClinics;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.AppClinics.dataBase.*;
import com.AppClinics.entities.*;


@SpringBootApplication
	public class AppPrincipal {
	public static void main(String[] args) {
		SpringApplication.run(AppPrincipal.class, args);
	}
	}

	/*	public static void main(String[] args) {
			Accounts accounts ;
			DataBase db = new DataBase();
			
			Scanner sc = new Scanner(System.in);
	
			int opcion = -1;
			while(opcion != 0) {
				System.out.println("*-*-*-*-*-*-*-*-*-*-*-");
				System.out.println("Welcome to D.B. Salud");
				System.out.println("*-*-*-*-*-*-*-*-*-*-*-");
				
				System.out.println("Ingrese 1 para crear una nueva cuenta");
				System.out.println("Ingrese 2 si ya posee una cuenta");
				System.out.println("Ingrese 0 para salir del programa");
			
			opcion = sc.nextInt();
			sc.nextLine();
		
			switch (opcion) {
					
			case 1: 
				//accounts = logIn(sc);
				db.singIn(sc);
				break;
			case 2:
				db.logIn(sc);
				//accounts = singIn(sc);
				break;

			}
		}
	}
/*
		private static Accounts logIn(Scanner sc) {
			
			System.out.println("****************************");
			System.out.println("Welcome to D.B. Salud");
			System.out.println("****************************");
			
			System.out.println("******Datos Personales******");
			System.out.println("Por favor ingrese su nombre ");
			String Name = (sc.nextLine());
			System.out.println("Ingrese su ocupación");
			String Specialty = (sc.nextLine());
			System.out.println("******Datos de Usuario******");
			System.out.println("Ingrese su Nombre de usuario");
			String usrName = sc.nextLine();
			System.out.println("Ingrese su Contraseña");
			String pass = sc.nextLine();
			System.out.println("****************************");
			System.out.println("****¡Log in completado!*****");
			Therapist therapist = new Therapist(Name, Specialty); 
			Accounts account = new Accounts(usrName, pass);
			account.newUser(therapist);
			therapist.newAccount(account);
		
			return null;
		}

		public static Accounts singIn(Scanner sc) {
		
			if(Accounts.userList != null) {
				
				System.out.println("Que gusto volver a vernos!");
				System.out.println("****************************");
				System.out.println("Ingrese su Usuario");
				String user = sc.nextLine();
				System.out.println("Ingrese su Contraseña");
				String pass = sc.nextLine();
				Accounts accountSing = new Accounts(user,pass);
				
				for(Therapist i : Accounts.userList) {
					if (accountSing.User().equals(Accounts.userList)) {
						System.out.println("JAJA estamos logrando");
					}
				}
			}
			else 
				System.out.println("Usted no posee una cuenta");
				return null;
		}
		*/
				

	

	
	
	
	
	
	
	
	
	
	
