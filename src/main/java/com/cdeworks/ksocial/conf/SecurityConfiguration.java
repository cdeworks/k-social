package com.cdeworks.ksocial.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService users;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(users)
				.passwordEncoder(new BCryptPasswordEncoder());
	}

	
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring()
			.antMatchers("/bootstrap/**")
			.antMatchers("/dist/**")
			.antMatchers("/plugins/**");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest()
					.authenticated()
				.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
				.and()
				.httpBasic()
				.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.and()
					.exceptionHandling()
					.accessDeniedPage("/errors/403");
		
		
		
//				.and()
//					.formLogin() //.loginPage("/login")
//					.defaultSuccessUrl("/home")
//					.permitAll()
//				.and()
//					.httpBasic()
//				.and()
//					.logout()
//						.logoutRequestMatcher(new	AntPathRequestMatcher("/logout"))

	}
}
