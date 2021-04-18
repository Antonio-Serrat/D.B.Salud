package com.AppClinics.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.AppClinics.entities.Account;
import com.AppClinics.repositories.AccountRepository;

@Service
public class AccountService implements UserDetailsService {

	@Autowired
	AccountRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Account appUser = repo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

		// Mapear nuestra lista de Authority con la de spring security
		List grantList = new ArrayList();

		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUser.getRoles().getRol());

		grantList.add(grantedAuthority);

		// Crear el objeto UserDetails que va a ir en sesion y retornarlo.
		UserDetails account = (UserDetails) new User(appUser.getEmail(), appUser.getPassword(), grantList);
		return account;

	}

}
