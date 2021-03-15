package com.AppClinics.dataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.AppClinics.entities.Account;
import com.AppClinics.entities.Patient;
import com.AppClinics.entities.Therapist;
import com.AppClinics.entities.TherapistMenu;

public class DataBase implements Serializable {
	private static final long serialVersionUID = 1L;

	Set<Account> users = new HashSet<>();
	Map<Integer, TherapistMenu> menu = new HashMap<>();
	Set<Therapist> therapist = new HashSet<>();
	List<Patient> patient = new ArrayList<>();

	public void singIn(Scanner sc) {
		DataBase db = new DataBase();

		System.out.println("****************************");
		System.out.println("Welcome to D.B. Salud");
		System.out.println("****************************");

		System.out.println("******Para registrarse ingrese sus datos personales******");
		System.out.println("Por favor ingrese su nombre ");
		String Name = (sc.nextLine());
		System.out.println("Ingrese su ocupación");
		String Specialty = (sc.nextLine());
		System.out.println("Ingrese su D.N.I");
		String dni = (sc.nextLine());
		System.out.println("Ingrese su Telefono");
		String tlf = (sc.nextLine());
		System.out.println("Ingrese su email");
		String email = (sc.nextLine());
		System.out.println("******Datos de Usuario******");
		System.out.println("Ingrese su Nombre de usuario");
		String usrName = sc.nextLine();
		System.out.println("Ingrese su Contraseña");
		String pass = sc.nextLine();
		System.out.println("****************************");
		System.out.println("****¡Registro completado!*****");
		Therapist therapist = new Therapist(Name, Specialty, email, dni, tlf);
		// Account account = new Account(usrName, pass);
		// account.newUser(therapist);
		// therapist.newAccount(account);
		// setUsers(account);
		setTherapist(therapist);

	}

	/*
	 * public void logIn(Scanner sc) {
	 * 
	 * if (users.isEmpty()) { System.out.println("No hay cuentas agregadas"); } else
	 * {
	 * 
	 * System.out.println("Que gusto volver a vernos!");
	 * System.out.println("****************************");
	 * System.out.println("Ingrese su Usuario"); String user = sc.nextLine();
	 * System.out.println("Ingrese su Contraseña"); String pass = sc.nextLine();
	 * 
	 * for (Account i : users) { if (i.getUserName().equals(user) &&
	 * i.getPassword().equals(pass)) {
	 * 
	 * menuTherapist();
	 * 
	 * } } }
	 * 
	 * }
	 */
	public Set<Account> getUsers() {
		return users;
	}

	public void setUsers(Account users) {
		this.users.add(users);
	}

	public List<Patient> getPatients() {
		return patient;
	}

	public void setPatients(List<Patient> patient) {
		this.patient = patient;
	}

	public Map<Integer, TherapistMenu> menuTherapist() {

		Map<Integer, TherapistMenu> mapa = new HashMap<Integer, TherapistMenu>();
		System.out.println("*-*-*--*-*-*-*-*-*-D.B. Salud-*-*-*-*-*-*-*");
		System.out.println("-*-Bienvenido " + Therapist.class.getName() + "-*-");

		mapa.put(1, new TherapistMenu(1, "Ver Pacientes"));
		mapa.put(2, new TherapistMenu(2, "Agregar paciente"));
		mapa.put(3, new TherapistMenu(3, "Quitar Pacientes"));
		mapa.put(4, new TherapistMenu(4, "Ver Agenda"));
		mapa.put(5, new TherapistMenu(5, "Ver Turnos"));
		mapa.put(6, new TherapistMenu(6, "Agregar Turno"));
		mapa.put(7, new TherapistMenu(7, "Quitar Turno"));

		return mapa;
	}

	public Set<Therapist> getTherapist() {
		return therapist;
	}

	public void setTherapist(Therapist therapist) {
		this.therapist.add(therapist);
	}

}
