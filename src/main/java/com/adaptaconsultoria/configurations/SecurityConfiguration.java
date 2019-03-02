package com.adaptaconsultoria.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService detailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests().antMatchers("/setview", "/campaings").permitAll()
//				.antMatchers("/admin/**").hasRole("admin")
//				.anyRequest().authenticated().and().formLogin()
//				.loginPage("/login").defaultSuccessUrl("/dashboard", true).passwordParameter("password")
//				.usernameParameter("login").permitAll().and().logout().and().exceptionHandling()
//				.accessDeniedPage("/login");
//
//		http.csrf().disable();
//	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/vendors/**");
	}
}
