package com.AppClinics.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppClinics.entities.Roles;
import com.AppClinics.repositories.RolesRepository;

@RestController
@RequestMapping(value = "/api/admin")
public class RolesController {

	RolesRepository repo;

	@Autowired
	public RolesController(RolesRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Roles>> getAdmins() {
		return new ResponseEntity<List<Roles>>((List<Roles>) repo.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Roles> saveAdmin(@PathParam(value = "name") String role) {

		Roles rol = new Roles();
		rol.setRol(role);

		repo.save(rol);

		return new ResponseEntity<Roles>(rol, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/dellOFFall")
	public ResponseEntity<List<Roles>> deleteAll(@PathParam(value = "id") Long id) {

		repo.deleteAll();

		return new ResponseEntity<List<Roles>>(HttpStatus.OK);
	}
	/*
	 * @DeleteMapping(value = "/{id}") public ResponseEntity<Admin>
	 * deleteAccount(@PathParam(value = "Id") Long id) {
	 * 
	 * 
	 * 
	 * AccountController repoAcc; repoAcc.repo.deleteById(id);
	 * 
	 * return new ResponseEntity<Admin>(HttpStatus.OK); }
	 */
}
