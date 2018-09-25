package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {		
		auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("employee").password("{noop}123456").roles("EMPLOYEE");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/","/login").permitAll()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/employee/**").access("hasRole('ROLE_EMPLOYEE') or hasRole('ROLE_ADMIN')")
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").loginProcessingUrl("/Login").defaultSuccessUrl("/dashboard")
			.failureUrl("/login?error")
			.usernameParameter("username")
			.passwordParameter("password")
			.and().logout().logoutUrl("/Logout").logoutSuccessUrl("/login");
		
	}
}