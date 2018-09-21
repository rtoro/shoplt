package com.atomic.shoplt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception
	{
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring()
				.antMatchers("/webfonts/**")
				.antMatchers("/custom_css/**")
				.antMatchers("/custom_js/**")
				.antMatchers("/js/**")
				.antMatchers("/pass")
				.antMatchers("/css/**");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.
			authorizeRequests()
				.antMatchers("/login*").permitAll()
				.antMatchers("/user").authenticated()
				.antMatchers("/user/list").hasAuthority("ADMIN")
				.antMatchers("/user/remove").hasAuthority("ADMIN")
				.antMatchers("/user/add").hasAuthority("ADMIN")
				.antMatchers("/item/add").hasAuthority("ADMIN")
				.antMatchers("/item/remove").hasAuthority("ADMIN")
				.anyRequest().authenticated()
			.and()
				.csrf().disable()
			.formLogin()
				.loginPage("/login")
				.successForwardUrl("/")
				.permitAll()
			.and()
				.rememberMe()
					.tokenValiditySeconds(60 * 60 * 24 * 30) 
					.rememberMeCookieName("TOKEN")
			.and()
				.logout()
					.deleteCookies("SIC_TOKEN","JSESSIONID")
					.logoutSuccessUrl("/login?logout")
			.and()
				.sessionManagement()
					.sessionAuthenticationErrorUrl("/login?exception")				
			.and()
				.headers()
					.frameOptions()
					.sameOrigin();
	}
}
