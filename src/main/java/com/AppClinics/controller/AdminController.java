package com.AppClinics.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AppClinics.entities.Admin;
import com.AppClinics.repositories.AdminRepository;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

	AdminRepository repo;

	@Autowired
	public AdminController(AdminRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value = "/")
	public ResponseEntity<List<Admin>> getAdmins() {
		return new ResponseEntity<List<Admin>>((List<Admin>) repo.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Admin> saveAdmin(@PathParam(value = "name") String name) {

		Admin root = new Admin();
		root.setName(name);

		repo.save(root);
		return new ResponseEntity<Admin>(root, HttpStatus.CREATED);
	}
}
