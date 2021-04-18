package com.AppClinics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.AppClinics.services.AccountService;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

	@Autowired
	AccountService userDet;
	@Autowired
	PasswordEncoder bcrypt;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.formLogin().usernameParameter("email").passwordParameter("password")
				.defaultSuccessUrl("/api/therapist/homeTh/${account.therapist.id}").permitAll();
		http.authorizeRequests().antMatchers("/", "/index", "/about", "/signup", "/signUp", "/login").permitAll().and()
				.authorizeRequests().antMatchers("/api/***").hasAnyRole("USER").anyRequest().authenticated().and()
				.logout().logoutSuccessUrl("/");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDet).passwordEncoder(bcrypt);

	}
}
